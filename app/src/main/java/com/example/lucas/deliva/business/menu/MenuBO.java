package com.example.lucas.deliva.business.menu;

import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.data.dao.menu.MenuDAO;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.UserReturn;

import java.util.List;

public class MenuBO {

    private static final String TAG = MenuBO.class.getName();

    private final MenuDAO mMenuDAO;
    private final ConnectionBO mConnectionBO;

    public MenuBO() {
        mMenuDAO = new MenuDAO();
        mConnectionBO = new ConnectionBO();
    }

    public List<Menu> getMenuList() throws BusinessException {
        mConnectionBO.assertInternetConnection();
        try {
            List<Menu> gson = mMenuDAO.getMenuList();
            if (gson != null) {
                return gson;
            } else {
                throw new BusinessException(BusinessErrorCode.GENERIC_ERROR);
            }
        } catch (Exception exception) {
            String errorMessage = "Generic login error " + exception.getMessage();
            Log.e(TAG, errorMessage);
            throw new BusinessException(errorMessage, BusinessErrorCode.GENERIC_ERROR);
        }
    }


}
