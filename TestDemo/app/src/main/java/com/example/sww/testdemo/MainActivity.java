package com.example.sww.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sww.testdemo.View.SlowMoveActivity;
import com.example.sww.testdemo.View.TestViewActivity;
import com.example.sww.testdemo.callback.MyButton;
import com.example.sww.testdemo.factory.SendFactory;
import com.example.sww.testdemo.factory.SendMailFactory;
import com.example.sww.testdemo.server.MyClickListener;
import com.example.sww.testdemo.server.Provider;
import com.example.sww.testdemo.server.Sender;
import com.example.sww.testdemo.ui.DetailPlayer;
import com.example.sww.testdemo.ui.TextInputLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.test)
    TextView test;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    test.setText("2222");
                    break;
            }
        }
    };
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.list_item1)
    TextView listItem1;
    @Bind(R.id.above)
    LinearLayout above;
    @Bind(R.id.below)
    LinearLayout below;
    @Bind(R.id.activity_main)
    ScrollView activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        testRunMain();

//        handler.sendEmptyMessage(1);
//        initData();
        above.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {

//                testFactory();
//                testExpandText();
//                testBanner();
//                testCustomView();
                testScrollView();
//                testInput();
//                testBottomView();
//                testBackMove();
//                    testSlowMove();
//                ScrollOrRecycle();

            }
        });

        MyButton myButton = new MyButton();

        myButton.setOnClickListener(new MyClickListener() {
            @Override
            public void onClick(String s) {

                test.setText(s);

            }
        });

        myButton.doClick();
    }

    private void ScrollOrRecycle()
    {
//        Intent intent = new Intent(this, ScrollRecycleActivity.class);
        Intent intent = new Intent(this, DetailPlayer.class);

        startActivity(intent);
    }

    private void testExpandText()
    {
        Intent intent = new Intent(this, CustomExpandTextActivity.class);
        startActivity(intent);
    }

    private void testSlowMove()
    {
        Intent intent = new Intent(this, SlowMoveActivity.class);
        startActivity(intent);
    }

    private void testBanner()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * 测试输入提示语
     */
    private void testInput(){

        Intent intent = new Intent(this, TextInputLayoutActivity.class);
        startActivity(intent);
    }

    private void testBottomView()
    {
        Intent intent = new Intent(this, BottomActivity.class);
        startActivity(intent);
    }

    /**
     * 测试背景移动
     */
    private void testBackMove()
    {
        Intent intent = new Intent(this, BackScrollActivity.class);
        startActivity(intent);
    }



    /**
     * 测试自定义View
     */
    private void testCustomView()
    {
        Intent intent = new Intent(this, TestViewActivity.class);
        startActivity(intent);
    }

    /**
     * 测试联动布局
     */

    private void testScrollView()
    {
        Intent intent = new Intent(this,ScrollActivity.class);
        startActivity(intent);
    }


    /**
     *
     * 简易工厂模式测试
     */
    private void testFactory()
    {
        Sender sender = SendFactory.produceMail();
        sender.Sender();

        Sender sender1 = SendFactory.produceSms();
        sender1.Sender();
    }

    /**
     * 抽象工厂模式
     */

    private void testAbstractFactory()
    {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Sender();
    }

    private void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(layoutManager);

        List<String> dataList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            dataList.add("测试" + i);
        }

        MyAdapter adapter = new MyAdapter(dataList);
        recycle.setAdapter(adapter);
    }

    /**
     * 用runOnUiThread()来代替Thread + Handler
     */
    private void testRunMain() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                test.setText("a little test");
            }
        });


    }

    private void testRun() {


    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        List<String> data = new ArrayList<>();

        public MyAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_layout, parent);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.test.setText(data.get(position));

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView image;
            TextView test;

            public ViewHolder(View itemView) {
                super(itemView);
                image = (ImageView) findViewById(R.id.image);
                test = (TextView) findViewById(R.id.text);
            }
        }
    }


}
