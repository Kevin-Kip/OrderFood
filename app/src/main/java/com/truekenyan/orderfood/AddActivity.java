package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    @BindView (R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick ({R.id.android_pay, R.id.credit_pay, R.id.close_button, R.id.confirm_button})
    public void onViewClicked (View view) {
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
