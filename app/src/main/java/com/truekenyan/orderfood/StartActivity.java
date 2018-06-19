package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {

    @BindView (R.id.letter_f)
    ImageView letterF;
    @BindView (R.id.letter_o_first)
    ImageView letterOFirst;
    @BindView (R.id.letter_o_second)
    ImageView letterOSecond;
    @BindView (R.id.letter_d)
    ImageView letterD;

    private final int TIME_INTERVAL = 2000;
    private long time_lapse;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.enter_button)
    public void onViewClicked () {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
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
