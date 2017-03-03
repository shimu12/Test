package com.example.sww.testdemo.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.sww.testdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 设置textinput的颜色
 * 注意通过改变colorAccent的值可以改变TextInputLayout的颜色。
 */
public class TextInputLayoutActivity extends AppCompatActivity {

//    @Bind(R.id.ed_username)
//    TextInputEditText edUsername;
    @Bind(R.id.activity_text_input_layout)
    TextInputLayout activityTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);
    }
}
