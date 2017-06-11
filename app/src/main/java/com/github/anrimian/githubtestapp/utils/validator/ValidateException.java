package com.github.anrimian.githubtestapp.utils.validator;

import java.util.List;

/**
 * Created on 23.03.2017.
 */

public class ValidateException extends Exception {

    private List<ValidateError> validateErrors;

    ValidateException(List<ValidateError> validateErrors) {
        this.validateErrors = validateErrors;
    }

    public List<ValidateError> getValidateErrors() {
        return validateErrors;
    }
}
