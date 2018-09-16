package com.example.lucas.deliva.controller.user;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.user.UserBO;
import com.example.lucas.deliva.controller.BaseAsyncTask;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.data.model.UserReturn;

public class UserController {

    private static final String TAG = UserController.class.getName();

    private final UserBO mUserBO;

    public UserController() {
        mUserBO = new UserBO();
    }

    public void login(@NonNull final String email,
                      @NonNull final String password,
                      @NonNull final ControllerListener<UserReturn> callback) {
        Log.d(TAG, "Request to authenticate");

        try {
            LoginControllerAsyncTask asyncTask = new LoginControllerAsyncTask(email, password, callback);
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }catch (Exception ex) {
            //TODO - Insert Firebase crash analytics
            Log.e(TAG, "Error executing: authenticate", ex);
            callback.onError(new BusinessException(BusinessErrorCode.GENERIC_ERROR));
        }

    }

    private class LoginControllerAsyncTask extends BaseAsyncTask<Object, Object, UserReturn> {

        private String mEmail;
        private String mPassword;

        public LoginControllerAsyncTask(@NonNull final String email,
                                        @NonNull final String password,
                                        @NonNull ControllerListener callback) {
            super(callback);
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected UserReturn onBackground() {
            return mUserBO.login(mEmail, mPassword);
        }
    }

}
