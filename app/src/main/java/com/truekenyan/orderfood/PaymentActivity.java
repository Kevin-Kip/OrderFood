package com.truekenyan.orderfood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity {

    @BindView (R.id.credit_card_name)
    EditText creditCardName;
    @BindView (R.id.credit_card_expiry)
    EditText creditCardExpiry;
    @BindView (R.id.credit_card_number)
    EditText creditCardNumberInput;
    @BindView (R.id.credit_card_ccv)
    EditText creditCardCcvInput;
    @BindView (R.id.toolbar)
    Toolbar toolbar;

    private boolean paymentMethodSelected = false;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick ({R.id.android_pay, R.id.credit_pay, R.id.close_button, R.id.confirm_button})
    public void onViewClicked (View view) {
        switch (view.getId()) {
            case R.id.android_pay:
                Toast.makeText(getApplicationContext(), "Coming soon. Proceed with credit card", Toast.LENGTH_SHORT).show();
                paymentMethodSelected = false;
                break;
            case R.id.credit_pay:
                paymentMethodSelected = true;
                break;
            case R.id.close_button:
                paymentMethodSelected = false;
                break;
            case R.id.confirm_button:
                if (paymentMethodSelected) {
                    startActivity(new Intent(getApplicationContext(), SuccessActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a payment method", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
