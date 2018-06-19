package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final int TIME_INTERVAL = 2000;
    private long time_lapse;

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

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        if (TIME_INTERVAL + time_lapse > System.currentTimeMillis()){
            finishAffinity();
            System.exit(0);
        } else {
            Toast.makeText(getApplicationContext(), "Press again to EXIT", Toast.LENGTH_SHORT).show();
        }
        time_lapse = System.currentTimeMillis();
    }
}
