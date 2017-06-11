package com.github.anrimian.githubtestapp.utils.errors;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.github.anrimian.githubtestapp.R;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.ErrorDetail;
import com.github.anrimian.githubtestapp.dataset.retrofit.responses.ErrorResponse;
import com.github.anrimian.githubtestapp.utils.errors.exceptions.FakeException;
import com.github.anrimian.githubtestapp.utils.errors.exceptions.PermissionException;
import com.github.anrimian.githubtestapp.utils.validator.ValidateError;
import com.github.anrimian.githubtestapp.utils.validator.ValidateException;
import com.github.anrimian.githubtestapp.utils.validator.ValidationErrorMessage;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import retrofit2.HttpException;


public class ErrorInfo {

    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected String message;

    @SuppressWarnings("WeakerAccess")
    @StringRes
    protected int messageResId = R.string.unexpected_error;

    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected Cause cause;

    public ErrorInfo(Throwable throwable) {
        if (throwable instanceof ValidateException) {
            ValidateException validateException = (ValidateException) throwable;
            ValidateError validateError = validateException.getValidateErrors().get(0);
            ValidationErrorMessage message = validateError.getMessage();
            messageResId = message.getErrorMessageId();
            return;
        }
        if (throwable instanceof HttpException) {
            ErrorResponse errorResponse = ErrorResponse.fromHttpException((HttpException) throwable);
            if (errorResponse != null) {
                List<ErrorDetail> details = errorResponse.getErrors();
                if (details != null && !details.isEmpty()) {
                    ErrorDetail detail = details.get(0);
                    message = detail.getField() + ": " + detail.getCode();
                } else {
                    message = errorResponse.getMessage();
                }
                return;
            }
            messageResId = R.string.unexpected_server_error_message;
            return;
        }
        if (throwable instanceof PermissionException) {
            messageResId = R.string.dont_have_permission;
            return;
        }
        if (throwable instanceof UnknownHostException) {
            messageResId = R.string.server_connection_find_error;
            return;
        }
        if (throwable instanceof SocketTimeoutException) {
            messageResId = R.string.server_timeout_error;
            return;
        }
        if (throwable instanceof NullPointerException) {
            throwable.printStackTrace();
            messageResId = R.string.internal_app_error;
            return;
        }
        if (throwable instanceof FakeException) {
            messageResId = R.string.fake_error;
            return;
        }
        throwable.printStackTrace();
        messageResId = R.string.unexpected_error;
    }

    public ErrorInfo(@Nullable String message) {
        this.message = message;
    }

    public ErrorInfo(@StringRes int messageResId) {
        this.messageResId = messageResId;
    }

    public ErrorInfo(@Nullable String message, @Nullable Cause cause) {
        this.message = message;
        this.cause = cause;
    }

    @Nullable
    public Cause getCause() {
        return cause;
    }

    public String getMessage(Context ctx) {
        if (TextUtils.isEmpty(message)) {
            return ctx.getResources().getString(messageResId);
        }
        return message;
    }
}
