package com.example.sww.testdemo;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.q42.android.scrollingimageview.ScrollingImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BackScrollActivity extends AppCompatActivity {

    //    @Bind(R.id.back_views)
//    ScrollingImageView backViews;
//    @Bind(R.id.activity_back_scroll)
//    RelativeLayout activityBackScroll;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_back_scroll);
        setContentView(R.layout.image_move_layout);
        ButterKnife.bind(this);
//        initAnima();
        init();
    }

    private void initAnima() {
//        Animation animation = new TranslateAnimation(0,20, 0,0);
//        animation.setDuration(500);
//        animation.setRepeatMode(Animation.REVERSE);
//        animation.setRepeatCount(1);
//        animation.start();
//        backViews.startAnimation(animation);

//        backViews.start();

    }

    private void init() {
        img = (ImageView) this.findViewById(R.id.splash_bg);
        img.post(new Runnable() {
            @Override
            public void run() {
                //获得ImageView中Image的真实宽高，
                int dw = img.getDrawable().getBounds().width();
                int dh = img.getDrawable().getBounds().height();

                //获得ImageView中Image的变换矩阵
                Matrix m = img.getImageMatrix();
                float[] values = new float[10];
                m.getValues(values);

                //Image在绘制过程中的变换矩阵，从中获得x和y方向的缩放系数
                float sx = values[0];
                float sy = values[4];

                //计算Image在屏幕上实际绘制的宽高
                float cw = (dw * sx);
                float ch = (dh * sy);
                int height = img.getHeight();
                Matrix matrix = new Matrix(img.getImageMatrix());
                float s = height / ch;
//                Log.d("缩放系数是：" + s + "  宽高是：" + height + "   " + ch);
                // 因为scaleType="matrix"。图片在ImageView中不会放大也不会缩小。我们需要手动让图片放大并居中
                matrix.postScale(s, s);//按照比例放大，是图片高度等于控件高度
                matrix.postTranslate(cw - (cw * s), 0);//设置偏移，是图片居中（实际上不是正中间，不过不影响）
                img.setImageMatrix(matrix);        // 初始化ValueAnimator
                ValueAnimator animator = ValueAnimator.ofInt(0, 200);
                animator.addUpdateListener(
                        new MyAnimatorListener(img.getImageMatrix()));
                animator.setDuration(4000);
                animator.setInterpolator(new DecelerateInterpolator());
                animator.setStartDelay(0);
                animator.start();
            }
        });
    }



    class MyAnimatorListener implements ValueAnimator.AnimatorUpdateListener {
        private Matrix mMatrix;
        public MyAnimatorListener(Matrix matrix) {
            mMatrix = new Matrix(matrix);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            int dx = (Integer) animation.getAnimatedValue();
            Matrix matrix = new Matrix(mMatrix);
            matrix.postTranslate(dx, 0);
            img.setImageMatrix(matrix);
        }
    }
}
