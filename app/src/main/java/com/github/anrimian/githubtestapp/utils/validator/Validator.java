package com.github.anrimian.githubtestapp.utils.validator;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Single;

/**
 * Created on 23.03.2017.
 */

public abstract class Validator<Model> {

    public Single<Model> validate(Model model) {
        return Single.fromCallable(() -> model)
                .map(this::validateModel)
                .flatMap(this::validateMap);
    }

    private Single<Model> validateMap(ValidateResultModel<Model> validateResultModel) {
        return Single.create(subscriber -> {
            List<ValidateError> validateErrors = validateResultModel.getValidateErrors();
            if (validateErrors.isEmpty()) {
                subscriber.onSuccess(validateResultModel.getModel());
            } else {
                subscriber.onError(new ValidateException(validateErrors));
            }
        });
    }

    private ValidateResultModel<Model> validateModel(Model model) {
        List<ValidateError> validateErrors = validateFields(model);
        return new ValidateResultModel<>(model, validateErrors);
    }

    @NonNull
    protected abstract List<ValidateError> validateFields(Model model);


}
