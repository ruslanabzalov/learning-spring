package abzalov.ruslan.restsample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Entity - аннотация, которая говорит о том, что объект может быть сохранён в базу данных.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;

    public Employee() {}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Employee))
            return false;

        Employee anotherEmployee = (Employee) object;
        return Objects.equals(this.id, anotherEmployee.id) &&
                Objects.equals(this.name, anotherEmployee.name) &&
                Objects.equals(this.role, anotherEmployee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee { id = '" + this.id + "', name = '" + this.name + "', role = '" + this.role + "' }";
    }
}
