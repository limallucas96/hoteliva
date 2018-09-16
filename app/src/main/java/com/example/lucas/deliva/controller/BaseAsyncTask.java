package com.example.lucas.deliva.controller;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.lucas.deliva.business.BusinessException;

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private BusinessException mErrorCode = null;
    private ControllerListener mControllerListener = null;

    public BaseAsyncTask(@NonNull final ControllerListener callback) {
        mControllerListener = callback;
    }

    protected abstract Result onBackground();

    @SafeVarargs
    @Override
    protected final Result doInBackground(Params... params) {
        try {
            return onBackground();
        } catch (BusinessException b) {
            mErrorCode = b;
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onPostExecute(Object result) {
        if (mControllerListener != null) {
            if (mErrorCode == null) {
                mControllerListener.onSuccess(result);
            } else {
                mControllerListener.onError(mErrorCode);
            }
        }
    }
}
