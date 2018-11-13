package com.example.lucas.deliva.presentation.login.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.lucas.deliva.R;
import com.example.lucas.deliva.data.model.type.CountryType;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountrySelectorDialog extends Dialog {

    private DialogListener mListener;

    @BindView(R.id.brazil_container)
    protected LinearLayout mBrazilContainer;

    @BindView(R.id.united_states_container)
    protected LinearLayout mUSContainer;

    public CountrySelectorDialog(@NonNull final Context context, @NonNull final DialogListener listener) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_country_selector);
        ButterKnife.bind(this);

        mListener = listener;
        mBrazilContainer.setOnClickListener(new ConfirmClickListener());
        mUSContainer.setOnClickListener(new ConfirmClickListener());
    }

    private class ConfirmClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.brazil_container:
                    mListener.onConfirmClickListener(CountryType.BRAZIL);
                    break;
                case R.id.united_states_container:
                    mListener.onConfirmClickListener(CountryType.UNITED_STATES);
                    break;
            }
        }
    }

    public interface DialogListener {
        void onConfirmClickListener(CountryType countryType);
    }
}
