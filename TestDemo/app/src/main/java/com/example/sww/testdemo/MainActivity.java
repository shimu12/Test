package com.example.sww.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.test)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        testRunMain();
    }

    private void testRunMain()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                test.setText("a little test");
            }
        });
    }


}
