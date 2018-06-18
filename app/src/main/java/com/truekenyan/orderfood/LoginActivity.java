package com.truekenyan.orderfood;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView (R.id.input_email)
    EditText inputEmail;
    @BindView (R.id.input_password)
    EditText inputPassword;
    @BindView (R.id.forgot_password)
    TextView forgotPassword;
    @BindView (R.id.login_button)
    Button loginButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.colorRedBackground));
        }
    }

    @OnClick ({R.id.forgot_password, R.id.login_button})
    public void onViewClicked (View view) {
        switch (view.getId()) {
            case R.id.forgot_password:
                break;
            case R.id.login_button:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }
    }
}
