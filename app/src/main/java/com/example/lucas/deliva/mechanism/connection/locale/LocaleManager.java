package com.example.lucas.deliva.mechanism.connection.locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import com.example.lucas.deliva.business.session.SessionBO;

import java.util.Locale;

public class LocaleManager {

    private static final String LANGUAGE_PORTUGUESE = "pt";
    private static final String LOCALE_BRAZIL = "BR";

    public static Context setLocale(Context context) {
        return updateResources(context, getLanguage(), getLocale());
    }

    public static Context setNewLocale(Context context, String language, String locale) {
        persistLanguage(language, locale);
        return updateResources(context, language, locale);
    }

    public static String getLanguage() {
        return new SessionBO().getLanguage();
    }

    public static String getLocale() {
        return new SessionBO().getLocale();
    }

    public static Locale getCurrentLocaleObject() {
        return new Locale(getLanguage(), getLocale());
    }

    @SuppressLint("ApplySharedPref")
    public static void persistLanguage(String language, String locale) {
        SessionBO sessionBO = new SessionBO();
        sessionBO.setLanguage(language);
        sessionBO.setLocale(locale);
    }

    private static Context updateResources(Context context, String language, String localeString) {
        if (language.isEmpty() || localeString.isEmpty()) {
            language = LANGUAGE_PORTUGUESE;
            localeString = LOCALE_BRAZIL;
        }
        Locale locale = new Locale(language, localeString);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }

}
