package com.example.sww.testdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollActivity extends AppCompatActivity {

    @Bind(R.id.main_backdrop)
    ImageView backdrop;
    @Bind(R.id.main_toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ButterKnife.bind(this);
        initData();
    }

    private void initData()
    {
        stringList = new ArrayList<>();
        for (int i = 0; i < 50; i++)
        {
            stringList.add("测试" + i);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(stringList,this);
        recycle.setAdapter(adapter);

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoloder>
    {

        private List<String> list;
        private Context context;
        public MyAdapter(List<String> list, Context context)
        {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHoloder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = getLayoutInflater().inflate(R.layout.item_layout, null);


            return new ViewHoloder(view);
        }

        @Override
        public void onBindViewHolder(ViewHoloder holder, int position) {

            holder.text.setText(list.get(position));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHoloder extends RecyclerView.ViewHolder
        {

            TextView text;


            public ViewHoloder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);
            }
        }
    }

}
