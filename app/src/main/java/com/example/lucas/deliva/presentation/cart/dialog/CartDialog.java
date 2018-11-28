package com.example.lucas.deliva.presentation.cart.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.lucas.deliva.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartDialog extends Dialog {

    private DialogListener mListener;

    @BindView(R.id.confirm)
    protected Button mConfirm;
    @BindView(R.id.cancel)
    protected Button mCancel;


    public CartDialog(@NonNull final Context context, @NonNull final DialogListener listener) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_country_selector);
        ButterKnife.bind(this);

        mListener = listener;
        mConfirm.setOnClickListener(new ConfirmClickListener());
        mCancel.setOnClickListener(new ConfirmClickListener());
    }

    private class ConfirmClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.confirm:
                    mListener.onConfirmClickListener();
                    break;
                case R.id.cancel:
                    mListener.onCancelClickListener();
                    break;
            }
        }
    }

    public interface DialogListener {
        void onConfirmClickListener();

        void onCancelClickListener();
    }

}
