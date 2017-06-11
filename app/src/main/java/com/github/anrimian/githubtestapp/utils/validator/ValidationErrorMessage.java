package com.github.anrimian.githubtestapp.utils.validator;


import com.github.anrimian.githubtestapp.R;

/**
 * Created on 23.03.2017.
 */

public enum ValidationErrorMessage {
    EMPTY_LOGIN {
        @Override
        public int getErrorMessageId() {
            return R.string.empty_login_error;
        }
    },
    EMPTY_PASSWORD {
        @Override
        public int getErrorMessageId() {
            return R.string.empty_password_error;
        }
    };

    public abstract int getErrorMessageId();

}
