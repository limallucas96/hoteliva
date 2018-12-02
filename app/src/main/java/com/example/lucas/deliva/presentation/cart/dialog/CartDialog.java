package com.example.lucas.deliva.presentation.cart.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.lucas.deliva.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartDialog extends Dialog {

    @BindView(R.id.confirm)
    protected TextView mConfirm;
    @BindView(R.id.cancel)
    protected TextView mCancel;

    private DialogListener mListener;


    public CartDialog(@NonNull final Context context, @NonNull final DialogListener listener) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_cart);
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
