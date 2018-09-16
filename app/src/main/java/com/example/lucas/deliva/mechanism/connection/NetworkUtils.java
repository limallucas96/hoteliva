package com.example.lucas.deliva.mechanism.connection;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Utilitary class for generally network used methods.
 */
public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    public static final String INTENT_ACTION_CONNECTION_DISABLED = "connection_disabled";

    /**
     * Checks if device is connected to the Internet.
     *
     * @param context Application context
     * @return true if connected, false if not
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnected()) {
                isConnected = true;
            }
        }

        Log.d(TAG, "isNetworkAvailable: " + isConnected);

        return isConnected;
    }

    public static void sendActionConnectionDisabled(Context context) {
        Intent broadcastIntent = new Intent(INTENT_ACTION_CONNECTION_DISABLED);
        context.sendOrderedBroadcast(broadcastIntent, null);
    }
}