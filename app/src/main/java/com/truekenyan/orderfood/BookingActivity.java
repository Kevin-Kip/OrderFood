package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingActivity extends AppCompatActivity {

    @BindView (R.id.toolbar)
    Toolbar toolbar;
    @BindView (R.id.juice_amount)
    TextView juiceAmount;

    private int juiceNumber = 1;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        juiceAmount.setText(String.format(Locale.getDefault(),"%d %s", juiceNumber, getResources().getString(R.string.juice_number)));
    }

    @OnClick ({R.id.reduce_juice, R.id.increase_juice, R.id.button_confirm_delivery})
    public void onViewClicked (View view) {
        switch (view.getId()) {
            case R.id.reduce_juice:
                if ((juiceNumber > 1)){
                    juiceNumber -= 1;
                    setJuiceNumber(juiceNumber);
                } else {
                    Toast.makeText(getApplicationContext(), "Minimum is one", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.increase_juice:
                juiceNumber += 1;
                setJuiceNumber(juiceNumber);
                break;
            case R.id.button_confirm_delivery:
                startActivity(new Intent(getApplicationContext(), ConfirmationActivity.class));
//                TODO add more functionality
                break;
        }
    }

    private void setJuiceNumber(int number){
        juiceAmount.setText(String.format(Locale.getDefault(),"%d %s", number, getResources().getString(R.string.juice_number)));

    }
}
