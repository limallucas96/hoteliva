package com.example.lucas.deliva.presentation.base.view;

import android.app.Activity;
import android.support.annotation.NonNull;

public interface AdapterAwareFragment<T extends Activity> {

    void onAdapterChangedToThisFragment(@NonNull final T activity);
}
