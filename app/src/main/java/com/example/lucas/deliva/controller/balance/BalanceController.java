package com.example.lucas.deliva.controller.balance;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.balance.BalanceBO;
import com.example.lucas.deliva.controller.BaseAsyncTask;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.data.model.Balance;

import java.util.List;

public class BalanceController {

    private static final String TAG = BalanceController.class.getName();

    private final BalanceBO mBalanceBO;

    public BalanceController() {
        mBalanceBO = new BalanceBO();
    }

    public void getUserBalance(@NonNull String idResident,
                               @NonNull final ControllerListener<List<Balance>> callback) {
        Log.d(TAG, "Request to getUserBalance");

        try {
            GetUserBalanceListAsyncTask asyncTask = new GetUserBalanceListAsyncTask(idResident, callback);
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception ex) {
            //TODO - Insert Firebase crash analytics
            Log.e(TAG, "Error executing: authenticate", ex);
            callback.onError(new BusinessException(BusinessErrorCode.GENERIC_ERROR));
        }
    }

    private class GetUserBalanceListAsyncTask extends BaseAsyncTask<Object, Object, List<Balance>> {

        private String mIdResident;

        public GetUserBalanceListAsyncTask(@NonNull String idResident,
                                           @NonNull ControllerListener callback) {
            super(callback);
            this.mIdResident = idResident;
        }

        @Override
        protected List<Balance> onBackground() {
            return mBalanceBO.getUserBalance(mIdResident);
        }
    }

}
