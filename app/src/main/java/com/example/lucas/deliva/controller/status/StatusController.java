package com.example.lucas.deliva.controller.status;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.status.StatusBO;
import com.example.lucas.deliva.controller.BaseAsyncTask;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.data.model.Balance;

import java.util.List;

public class StatusController {

    private static final String TAG = StatusController.class.getName();

    private final StatusBO mStatusBo;

    public StatusController() {
        mStatusBo = new StatusBO();
    }

    public void getOrderStatus(@NonNull String idResident,
                               @NonNull String idRoom,
                               @NonNull final ControllerListener<List<Balance>> callback) {
        Log.d(TAG, "Request to getOrderStatus");

        try {
            GetOrderStatusAsyncTask asyncTask = new GetOrderStatusAsyncTask(idResident, idRoom, callback);
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception ex) {
            //TODO - Insert Firebase crash analytics
            Log.e(TAG, "Error executing: getOrderStatus", ex);
            callback.onError(new BusinessException(BusinessErrorCode.GENERIC_ERROR));
        }
    }

    private class GetOrderStatusAsyncTask extends BaseAsyncTask<Object, Object, List<Balance>> {

        private String mIdResident;
        private String mIdRoom;

        public GetOrderStatusAsyncTask(@NonNull String idResident,
                                       @NonNull String idRoom,
                                       @NonNull ControllerListener callback) {
            super(callback);
            this.mIdResident = idResident;
            this.mIdRoom = idRoom;
        }

        @Override
        protected List<Balance> onBackground() {
            return mStatusBo.getOrderStatus(mIdResident, mIdRoom);
        }
    }

}
