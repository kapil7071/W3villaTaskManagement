package com.w3villa.taskmanagement2.security.exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid ID format: " + ex.getValue());
        return "error"; // The view name for the error page
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(NumberFormatException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid task ID format.");
        return "error"; // The view name for the error page
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // The view name for the error page
    }
}
