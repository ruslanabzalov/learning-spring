package abzalov.ruslan.restsample.controllers;

import abzalov.ruslan.restsample.exceptions.EmployeeNotFoundException;
import abzalov.ruslan.restsample.model.Employee;
import abzalov.ruslan.restsample.repos.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee saveNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
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
