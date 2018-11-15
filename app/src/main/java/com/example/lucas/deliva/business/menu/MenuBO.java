package com.example.lucas.deliva.business.menu;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.lucas.deliva.business.BusinessErrorCode;
import com.example.lucas.deliva.business.BusinessException;
import com.example.lucas.deliva.business.connection.ConnectionBO;
import com.example.lucas.deliva.data.dao.menu.MenuDAO;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.model.MenuReturn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        List<Menu> menu = new ArrayList<>();
        try {
            HashMap<String, MenuReturn> gson = mMenuDAO.getMenuList();
            if (gson != null && !gson.isEmpty()) {
                for (Map.Entry<String, MenuReturn> menuReturn : gson.entrySet()) {
                    String id = menuReturn.getKey();
                    menu.add(new Menu(
                            id,
                            menuReturn.getValue().getName(),
                            menuReturn.getValue().getDescription(),
                            menuReturn.getValue().getValue(),
                            menuReturn.getValue().getImg()));
                }
                return menu;
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
