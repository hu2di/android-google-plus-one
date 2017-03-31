package com.blogspot.hu2di.googleplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.plus.PlusOneButton;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://play.google.com/store/apps/developer?id=Hu2Di";
    private static final int REQUEST_CODE = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshPlusOne();
    }

    public void refreshPlusOne() {
        PlusOneButton plusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);
        plusOneButton.initialize(URL, new PlusOneButton.OnPlusOneClickListener() {
            public void onPlusOneClick(Intent intent) {
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            refreshPlusOne();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
