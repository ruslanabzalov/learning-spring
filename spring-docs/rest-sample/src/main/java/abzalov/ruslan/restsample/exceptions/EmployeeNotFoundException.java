package abzalov.ruslan.restsample.exceptions;

/**
 * Когда выбрасывается это исключение, реализованный Advice Spring MVC используется для отображения ошибки HTTP 404.
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
