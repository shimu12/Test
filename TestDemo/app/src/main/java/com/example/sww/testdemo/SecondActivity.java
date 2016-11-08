package com.example.sww.testdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.sww.testdemo.scroll.RecyclingPagerAdapter;
import com.example.sww.testdemo.scroll.ScalePageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_second)
    RelativeLayout activitySecond;
    List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        initData();

        viewPager.setPageTransformer(true, new ScalePageTransformer());
        viewPager.setOffscreenPageLimit(5);
//        viewPager.setAdapter(new MyAdapter(this, list));
        viewPager.setAdapter(new TestAdapter(this, list));

        activitySecond.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
    }

    private void initData()
    {
        list = new ArrayList<>();
        list.add(R.mipmap.style_dny);
        list.add(R.mipmap.style_dzh);
        list.add(R.mipmap.style_jianyue);
        list.add(R.mipmap.style_meishi);
        list.add(R.mipmap.style_oushi);
        list.add(R.mipmap.style_rishi);


    }


    class TestAdapter extends PagerAdapter{

        Context context;
        List<Integer> list;

        public TestAdapter(Context context,List<Integer> list)
        {

            this.context = context;
            this.list = list;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView view = new ImageView(context);
            view.setImageResource(list.get(position));

//            RelativeLayout view= (RelativeLayout) getLayoutInflater().inflate(R.layout.image_item, null);
//            ImageView imageView = (ImageView) view.findViewById(R.id.image);
//            imageView.setImageResource(list.get(position));

            view.setTag(position);
            container.addView(view);
            return view;
//            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
//            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }



    class MyAdapter extends RecyclingPagerAdapter{

        List<Integer> list;
        Context context;

        public MyAdapter(Context context, List<Integer> list)
        {
            this.list = list;
            this.context = context;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {

//            ViewHolder holder;


//            imageView = new ImageView(context);

//            if (convertView == null) {
//
//                holder = new ViewHolder();
//                convertView= getLayoutInflater().inflate(R.layout.image_item, container,false);
//                holder.imageView = (ImageView) convertView;
//                convertView.setTag(holder);
//            } else {
//
//                holder = (ViewHolder) convertView.getTag();
//            }


//            holder.imageView.setImageResource(list.get(position));
//            return convertView;

            ImageView imageView = null;
            if (convertView == null) {
                imageView = new ImageView(context);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setTag(position);
            imageView.setImageResource(list.get(position));
            return imageView;

        }

        @Override
        public int getCount() {
            return list.size();
        }

//        class ViewHolder
//        {
//            ImageView imageView;
//        }
    }


}
