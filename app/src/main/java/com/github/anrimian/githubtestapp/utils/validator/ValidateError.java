package com.github.anrimian.githubtestapp.utils.validator;

/**
 * Created on 23.03.2017.
 */

public class ValidateError {

    private Field field;
    private ValidationErrorMessage message;

    public ValidateError(Field field, ValidationErrorMessage message) {
        this.field = field;
        this.message = message;
    }

    public Field getField() {
        return field;
    }

    public ValidationErrorMessage getMessage() {
        return message;
    }
}
