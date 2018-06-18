package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.button_buy)
    public void onViewClicked () {
        startActivity(new Intent(getApplicationContext(), BookingActivity.class));
    }
}
