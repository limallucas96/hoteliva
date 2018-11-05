package com.example.lucas.deliva.controller.menu;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.menu.MenuBO;
import com.example.lucas.deliva.controller.BaseAsyncTask;
import com.example.lucas.deliva.controller.ControllerListener;
import com.example.lucas.deliva.data.model.Menu;

import java.util.List;

public class MenuController {

    private static final String TAG = MenuController.class.getName();

    private final MenuBO mMenuBO;

    public MenuController() {
        mMenuBO = new MenuBO();
    }

    public void getMenuList(@NonNull final ControllerListener<List<Menu>> callback) {
        Log.d(TAG, "Request to authenticate");

        try {
            GetMenuListAsyncTask asyncTask = new GetMenuListAsyncTask(callback);
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception ex) {
            //TODO - Insert Firebase crash analytics
            Log.e(TAG, "Error executing: authenticate", ex);
            callback.onError(new BusinessException(BusinessErrorCode.GENERIC_ERROR));
        }
    }

    private class GetMenuListAsyncTask extends BaseAsyncTask<Object, Object, List<Menu>> {

        public GetMenuListAsyncTask(@NonNull ControllerListener callback) {
            super(callback);
        }

        @Override
        protected List<Menu> onBackground() {
            return mMenuBO.getMenuList();
        }
    }

}
