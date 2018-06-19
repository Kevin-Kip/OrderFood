package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddActivity extends AppCompatActivity {

    @BindView (R.id.credit_card_name)
    EditText creditCardName;
    @BindView (R.id.credit_card_expiry)
    EditText creditCardExpiry;
    @BindView (R.id.credit_card_number)
    EditText creditCardNumberInput;
    @BindView (R.id.credit_card_ccv)
    EditText creditCardCcvInput;

    private String cardHolderName;
    private int creditCardExpiryDate;
    private int creditCardNumber;
    private int creditCardCcv;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick ({R.id.android_pay, R.id.credit_pay, R.id.close_button, R.id.confirm_button})
    public void onViewClicked (View view) {

        cardHolderName = creditCardName.getText().toString();
        creditCardExpiryDate = Integer.parseInt(creditCardExpiry.getText().toString());
        creditCardNumber = Integer.parseInt(creditCardNumberInput.getText().toString());
        creditCardCcv = Integer.parseInt(creditCardCcvInput.getText().toString());

        switch (view.getId()) {
            case R.id.android_pay:
                break;
            case R.id.credit_pay:
                break;
            case R.id.close_button:
                creditCardName.clearComposingText();
                break;
            case R.id.confirm_button:
                startActivity(new Intent(getApplicationContext(), SuccessActivity.class));
                break;
        }
    }
}
