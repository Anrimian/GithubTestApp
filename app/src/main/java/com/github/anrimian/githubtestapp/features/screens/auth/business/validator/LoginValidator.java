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

public class LoginValidator extends Validator<String>  {

    @NonNull
    @Override
    protected List<ValidateError> validateFields(String login) {
        List<ValidateError> validateErrors = new ArrayList<>();

        ValidateError loginValidationError = validateLogin(login);
        if (loginValidationError != null) {
            validateErrors.add(loginValidationError);
        }
        return validateErrors;
    }

    private ValidateError validateLogin(String login) {
        if (TextUtils.isEmpty(login)) {
            return new ValidateError(Field.LOGIN, ValidationErrorMessage.EMPTY_LOGIN);
        }
        return null;
    }
}
