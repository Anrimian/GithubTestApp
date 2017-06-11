package com.github.anrimian.githubtestapp.features.screens.auth.business.validator;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.github.anrimian.githubtestapp.utils.validator.Field;
import com.github.anrimian.githubtestapp.utils.validator.ValidateError;
import com.github.anrimian.githubtestapp.utils.validator.ValidationErrorMessage;
import com.github.anrimian.githubtestapp.utils.validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11.06.2017.
 */

public class PasswordValidator extends Validator<String>  {

    @NonNull
    @Override
    protected List<ValidateError> validateFields(String password) {
        List<ValidateError> validateErrors = new ArrayList<>();

        ValidateError passwordValidationError = validatePassword(password);
        if (passwordValidationError != null) {
            validateErrors.add(passwordValidationError);
        }
        return validateErrors;
    }

    private ValidateError validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            return new ValidateError(Field.PASSWORD, ValidationErrorMessage.EMPTY_PASSWORD);
        }
        return null;
    }
}
