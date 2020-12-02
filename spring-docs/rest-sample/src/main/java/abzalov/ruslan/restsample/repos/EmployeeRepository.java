package abzalov.ruslan.restsample.repos;

import abzalov.ruslan.restsample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Employee - тип данных, сохраняемых в базу данных;
 * Long - тип идентификатора сущности.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
