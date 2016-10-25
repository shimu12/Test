package com.example.sww.testdemo;

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

import com.example.sww.testdemo.factory.SendFactory;
import com.example.sww.testdemo.server.Sender;

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

        handler.sendEmptyMessage(1);
//        initData();
        above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                testFactory();
            }
        });
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
