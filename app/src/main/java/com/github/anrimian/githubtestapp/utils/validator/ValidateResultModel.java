package com.github.anrimian.githubtestapp.utils.validator;


import java.util.List;

/**
 * Created on 23.03.2017.
 */

class ValidateResultModel<T> {

    private T model;
    private List<ValidateError> validateErrors;

    ValidateResultModel(T model, List<ValidateError> validateErrors) {
        this.model = model;
        this.validateErrors = validateErrors;
    }

    T getModel() {
        return model;
    }

    List<ValidateError> getValidateErrors() {
        return validateErrors;
    }
}
