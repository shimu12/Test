package com.example.sww.testdemo.ui;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.sww.testdemo.R;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.CustomGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DetailPlayer extends AppCompatActivity {

    @Bind(R.id.post_detail_nested_scroll)
    NestedScrollView postDetailNestedScroll;
    @Bind(R.id.video_player)
    CustomGSYVideoPlayer detailPlayer;
    @Bind(R.id.activity_detail_player)
    RelativeLayout activityDetailPlayer;

    private boolean isPlay;
    private boolean isPause;

    private OrientationUtils orientationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_player);
        ButterKnife.bind(this);

        String url = "http://baobab.wdjcdn.com/14564977406580.mp4";
        //String url = "https://d131x7vzzf85jg.cloudfront.net/upload/documents/paper/b2/61/00/00/20160420_115018_b544.mp4";
        detailPlayer.setUp(url, true, null, "测试视频");

        //增加封面
//        ImageView imageView = new ImageView(this);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageResource(R.mipmap.xxx1);
//        detailPlayer.setThumbImageView(imageView);

        resolveNormalVideoUI();

        orientationUtils = new OrientationUtils(this, detailPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);

        detailPlayer.setIsTouchWiget(true);
        //打开自动旋转
        detailPlayer.setRotateViewAuto(true);
        detailPlayer.setLockLand(false);
        detailPlayer.setShowFullAnimation(false);

        detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                detailPlayer.startWindowFullscreen(DetailPlayer.this, true, true);
            }
        });

        detailPlayer.setStandardVideoAllCallBack(new VideoImpl() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                //开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onAutoComplete(String url, Object... objects) {
                super.onAutoComplete(url, objects);
            }

            @Override
            public void onClickStartError(String url, Object... objects) {
                super.onClickStartError(url, objects);
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }
        });

//        detailPlayer.setBottomProgressBarDrawable(getResources().getDrawable(R.drawable.video_new_progress));
//        detailPlayer.setDialogVolumeProgressBar(getResources().getDrawable(R.drawable.video_new_volume_progress_bg));
//        detailPlayer.setDialogProgressBar(getResources().getDrawable(R.drawable.video_new_progress));
//        detailPlayer.setBottomShowProgressBarDrawable(getResources().getDrawable(R.drawable.video_new_seekbar_progress),
//        getResources().getDrawable(R.drawable.video_new_seekbar_thumb));
//        detailPlayer.setDialogProgressColor(getResources().getColor(R.color.colorAccent), -11);

    }

    @Override
    public void onBackPressed() {

        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }

        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!detailPlayer.isIfCurrentIsFullscreen()) {
                    detailPlayer.startWindowFullscreen(DetailPlayer.this, true, true);
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (detailPlayer.isIfCurrentIsFullscreen()) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
            }
        }
    }


    private void resolveNormalVideoUI() {
        //增加title
        detailPlayer.getTitleTextView().setVisibility(View.GONE);
        detailPlayer.getTitleTextView().setText("测试视频");
        detailPlayer.getBackButton().setVisibility(View.GONE);
    }

}
