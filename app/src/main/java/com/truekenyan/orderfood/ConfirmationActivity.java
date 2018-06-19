package com.truekenyan.orderfood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmationActivity extends AppCompatActivity {

    @BindView (R.id.toolbar)
    Toolbar toolbar;
    @BindView (R.id.adress_button)
    Button adressButton;
    @BindView (R.id.adress_button_two)
    Button adressButtonTwo;

    private boolean addressSelected = false;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick (R.id.button_pay)
    public void onViewClicked () {
        if (addressSelected) {
            startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
        } else {
            Toast.makeText(getApplicationContext(), "Please select an address", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick ({R.id.adress_button, R.id.adress_button_two})
    public void onViewClicked (View view) {
        switch (view.getId()) {
            case R.id.adress_button:
                adressButton.setBackgroundResource(R.drawable.button_background);
                adressButton.setTextColor(Color.WHITE);
                adressButtonTwo.setBackgroundResource(R.drawable.button_background_outline);
                adressButtonTwo.setTextColor(Color.BLACK);
                addressSelected = true;
                break;
            case R.id.adress_button_two:
                adressButtonTwo.setBackgroundResource(R.drawable.button_background);
                adressButtonTwo.setTextColor(Color.WHITE);
                adressButton.setBackgroundResource(R.drawable.button_background_outline);
                adressButton.setTextColor(Color.BLACK);
                addressSelected = true;
                break;
        }
    }
}
