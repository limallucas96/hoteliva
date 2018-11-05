package com.example.lucas.deliva.data.dao.menu;

import com.example.lucas.deliva.data.dao.PersistenceException;
import com.example.lucas.deliva.data.model.Menu;
import com.example.lucas.deliva.data.remote.WebService;
import com.example.lucas.deliva.data.remote.WebServiceClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MenuDAO {
    private static final String TAG = MenuDAO.class.getName();

    private final WebService mWebService;

    public MenuDAO() {
        mWebService = new WebServiceClient().getService();
    }

    public List<Menu> getMenuList() throws PersistenceException {
        try {
            WebService webService = new WebServiceClient().getService();
            Call<List<Menu>> wsCall = webService.getMenuList();
            Response<List<Menu>> response = wsCall.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorMessage = "Webservice Error";
                throw new PersistenceException(errorMessage);
            }

        } catch (IOException e) {
            String errorMessage = "IOException could not login " + e.getMessage();
            throw new PersistenceException(errorMessage);
        }
    }
}
