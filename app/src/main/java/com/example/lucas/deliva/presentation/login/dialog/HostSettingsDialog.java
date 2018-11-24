package com.example.lucas.deliva.presentation.login.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lucas.deliva.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HostSettingsDialog extends Dialog {

    @BindView(R.id.confirm)
    protected TextView mButtonOk;

    @BindView(R.id.host)
    protected EditText mHost;

    private DialogListener mListener;


    public HostSettingsDialog(@NonNull final Context context, @NonNull final DialogListener listener) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_host_settings);
        ButterKnife.bind(this);

        mListener = listener;
        mButtonOk.setOnClickListener(new ConfirmClickListener());
    }

    private class ConfirmClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String host = mHost.getText().toString().trim();
            mListener.onConfirmClickListener(host);
        }
    }

    public interface DialogListener {
        void onConfirmClickListener(String host);
    }

}
