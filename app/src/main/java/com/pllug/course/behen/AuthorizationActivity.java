package com.pllug.course.behen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AuthorizationActivity extends AppCompatActivity {

    private Button confirmBtn;
    private EditText loginEt, passwordEt;
    private String warningMsg = "Поля логін і пароль не можуть бути порожніми!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initView();
    }

    private void initView() {
        confirmBtn = findViewById(R.id.confirm_btn);
        loginEt = findViewById(R.id.login_et);
        passwordEt = findViewById(R.id.password_et);
    }


    @Override
    protected void onResume() {
        super.onResume();
        initListener();
    }


    private void initListener() {
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(loginEt.getText()) || TextUtils.isEmpty(passwordEt.getText())) {

                    showToast();
                } else {
                    goToProfileScreen();
                }
            }
        });
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, warningMsg, Toast.LENGTH_LONG);
        toast.show();
    }

    private void goToProfileScreen() {
        Intent intent = new Intent(AuthorizationActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

