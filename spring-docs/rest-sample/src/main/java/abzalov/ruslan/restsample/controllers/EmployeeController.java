package abzalov.ruslan.restsample.controllers;

import abzalov.ruslan.restsample.components.EmployeeModelAssembler;
import abzalov.ruslan.restsample.exceptions.EmployeeNotFoundException;
import abzalov.ruslan.restsample.model.Employee;
import abzalov.ruslan.restsample.repos.EmployeeRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * RestController - аннотация, которая говорит о том, что данные, возвращаемые каждым методом,
 * будут помещены прямо в тело ответа вместо рендеринга шаблона.
 */
@RestController
public class EmployeeController {

    /**
     * Репозиторий автоматически внедряется при создании экземпляра контроллера.
     */
    private final EmployeeRepository employeeRepository;

    private final EmployeeModelAssembler modelAssembler;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeModelAssembler employeeModelAssembler) {
        this.employeeRepository = employeeRepository;
        this.modelAssembler = employeeModelAssembler;
    }

    /**
     * CollectionModel - это контейнер Spring HATEOAS, предназначенный для инкапсуляции коллекций.
     * Позволяет включать в себя ссылки.
     */
    @GetMapping("/employees")
    public CollectionModel<EntityModel<Employee>> getAllEmployee() {
        List<EntityModel<Employee>> employees = employeeRepository.findAll().stream()
                .map(modelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(employees,
                linkTo(methodOn(EmployeeController.class).getAllEmployee()).withSelfRel());
    }

    @PostMapping("/employees")
    public ResponseEntity<?> saveNewEmployee(@RequestBody Employee employee) {
        EntityModel<Employee> entityModel = modelAssembler.toModel(employeeRepository.save(employee));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    /**
     * EntityModel - это контейнер Spring HATEOAS, который включает в себя не только данные, но и ссылки.
     */
    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return modelAssembler.toModel(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeByIdOrSave(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
