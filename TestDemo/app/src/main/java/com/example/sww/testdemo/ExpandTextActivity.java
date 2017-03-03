package com.example.sww.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpandTextActivity extends AppCompatActivity {

    @Bind(R.id.expandable_text)
    TextView expandableText;
    @Bind(R.id.expand_collapse)
    TextView expandCollapse;
    @Bind(R.id.expand_text_view)
    ExpandableTextView expandTextView;
    @Bind(R.id.activity_expand_text)
    LinearLayout activityExpandText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_text);
        ButterKnife.bind(this);

        expandTextView.setText("习近平向智利人民致以诚挚问候和良好祝愿。习近平指出，智利是拉美重要国家。作为第一个同新中国建交的南美国家，智利在发展对华关系方面创造了多项“第一”。建交46年来，两国政治互信不断深化，各领域交流合作成果丰硕。当前，中智两国合作面临更加广阔的发展前景。我这次访问的目的是增进传统友谊、深化互利合作、促进共同发展。我期待着在这次访问期间，同智利领导人共同描绘中智关系未来发展蓝图。相信这次访问一定能够推动中智关系迈上新台阶，为两国人民带来更多福祉。");
        expandTextView.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
//                if (isExpanded)
//                {
                textView.setEllipsize(TextUtils.TruncateAt.END);

//                }
            }
        });
    }
}
