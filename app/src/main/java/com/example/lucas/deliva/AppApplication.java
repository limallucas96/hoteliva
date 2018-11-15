package com.example.lucas.deliva;

import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.lucas.deliva.mechanism.connection.locale.LocaleManager;
import com.facebook.stetho.Stetho;

import java.lang.ref.WeakReference;

public class AppApplication extends MultiDexApplication {

    private static final String TAG = AppApplication.class.getSimpleName();

    private static WeakReference<Context> sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        // Hold application context reference
        Context context = getApplicationContext();
        sContext = new WeakReference<>(context);

        setupMultiDex();
//        setupFabric();
//        setupRemoteConfig();
//        setupRealm();
        setupStetho();
    }

    private void setupStetho() {
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }

    private void setupFabric() {
//        if (BuildConfig.ENABLE_CRASHLYTICS) {
//            Fabric.with(this, new Crashlytics());
//        }
    }

//    private void setupRealm() {
//        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .deleteRealmIfMigrationNeeded()
//                .name(BuildConfig.REALM_FILE_NAME)
//                .schemaVersion(BuildConfig.REALM_SCHEMA_VERSION)
//                .build();
//        Realm.setDefaultConfiguration(config);
//    }

    private void setupMultiDex() {
        MultiDex.install(this);
    }

//    private void setupRemoteConfig() {
//        // Firebase Remote config initialization
//        FirebaseApp.initializeApp(this);
//        RemoteConfig.initializeRemoteConfig();
//    }

    public static Context getAppContext() {
        return sContext.get();
    }

}
