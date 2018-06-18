package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.button_view)
    public void onViewClicked () {
        startActivity(new Intent(getApplicationContext(), InfoActivity.class));
//        TODO add more functionality and animation
    }
}
