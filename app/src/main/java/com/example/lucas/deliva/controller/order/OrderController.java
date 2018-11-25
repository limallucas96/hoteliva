package com.example.lucas.deliva.controller.order;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.order.OrderBO;
import com.example.lucas.deliva.controller.BaseAsyncTask;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.data.model.mock.Order;

public class OrderController {

    private static final String TAG = OrderController.class.getName();

    private final OrderBO mOrderBO;

    public OrderController() {
        mOrderBO = new OrderBO();
    }

    public void createOrder(@NonNull Order order, @NonNull final ControllerListener<Boolean> callback) {
        Log.d(TAG, "Request to create order");

        try {
            CreateOrderAsyncTask asyncTask = new CreateOrderAsyncTask(order, callback);
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception ex) {
            //TODO - Insert Firebase crash analytics
            Log.e(TAG, "Error executing: create order", ex);
            callback.onError(new BusinessException(BusinessErrorCode.GENERIC_ERROR));
        }
    }

    private class CreateOrderAsyncTask extends BaseAsyncTask<Object, Object, Boolean> {

        private Order mOrder;

        public CreateOrderAsyncTask(@NonNull Order order, @NonNull ControllerListener callback) {
            super(callback);
            this.mOrder = order;
        }

        @Override
        protected Boolean onBackground() {
            return mOrderBO.createOrder(mOrder);
        }
    }


}
