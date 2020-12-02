package abzalov.ruslan.restsample.advices;

import abzalov.ruslan.restsample.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ControllerAdvice говорит о том, как обрабатывать то или иное исключение во всём приложении,
 * а не в одном конкретном контроллере.
 */
@ControllerAdvice
public class EmployeeNotFoundAdvice {

    /**
     * ResponseBody говорит о том, что результат отработки "советчика" помещается напрямую в тело ответа.
     * ExceptionHandler говорит о том, на какое исключение распространяется "совет".
     * ResponseStatus говорит о том, каким будет статус ответа.
     */
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException) {
        return employeeNotFoundException.getMessage();
    }
}
