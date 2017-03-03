package com.example.sww.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sww.testdemo.util.FullyLinearLayoutManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollRecycleActivity extends AppCompatActivity {

    @Bind(R.id.activity_scroll_recycle)
    LinearLayout activityScrollRecycle;
    @Bind(R.id.recycle_view)
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_recycle);
        ButterKnife.bind(this);
        initRecycleView();
    }

    private void initRecycleView()
    {
        FullyLinearLayoutManager layoutManager = new FullyLinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(new MyAdapter());
    }





    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = getLayoutInflater().inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class ViewHolder extends RecyclerView.ViewHolder
        {

            TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);

                textView = (TextView) itemView.findViewById(R.id.text);

            }
        }
    }

}
