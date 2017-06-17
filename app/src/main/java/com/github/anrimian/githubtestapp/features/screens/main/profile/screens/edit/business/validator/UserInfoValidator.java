package com.github.anrimian.githubtestapp.features.screens.main.profile.screens.edit.business.validator;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.github.anrimian.githubtestapp.repositories.users.models.UserInfoModel;
import com.github.anrimian.githubtestapp.utils.validator.Field;
import com.github.anrimian.githubtestapp.utils.validator.ValidateError;
import com.github.anrimian.githubtestapp.utils.validator.ValidationErrorMessage;
import com.github.anrimian.githubtestapp.utils.validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11.06.2017.
 */

public class UserInfoValidator extends Validator<UserInfoModel>  {

    @NonNull
    @Override
    protected List<ValidateError> validateFields(UserInfoModel userInfoModel) {
        List<ValidateError> validateErrors = new ArrayList<>();

        ValidateError nameValidationError = validateUserName(userInfoModel.getName());
        if (nameValidationError != null) {
            validateErrors.add(nameValidationError);
        }
        ValidateError emailValidationError = validateEmail(userInfoModel.getEmail());
        if (emailValidationError != null) {
            validateErrors.add(emailValidationError);
        }
        return validateErrors;
    }

    private ValidateError validateUserName(String login) {
        if (TextUtils.isEmpty(login)) {
            return new ValidateError(Field.NAME, ValidationErrorMessage.EMPTY_NAME);
        }
        return null;
    }

    private ValidateError validateEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return new ValidateError(Field.EMAIL, ValidationErrorMessage.EMPTY_EMAIL);
        }
        return null;
    }
}
