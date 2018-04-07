package com.example.android.animationsdemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoveViewAnim extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView titleTvPart1, titleTvPart2, titleTvPart3,
            tvPart1, tvPart2, tvPart3, tvPart4, cdPart1, cdPart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_details);

        titleTvPart1 = (TextView)findViewById(R.id.titleTvPart1);
        //titleTvPart1.setText(R.string);
        tvPart1 = (TextView)findViewById(R.id.tvPart1);
        tvPart1.setText(R.string.movetvPart1);
        titleTvPart2 = (TextView)findViewById(R.id.titleTvPart2);
        titleTvPart2.setText(R.string.movetitleTvPart2);
        tvPart2 = (TextView)findViewById(R.id.tvPart2);
        tvPart2.setText(R.string.movetvPart2);
        cdPart1 = (TextView)findViewById(R.id.cdPart1);
        cdPart1.setText(R.string.movecdPart1);
        titleTvPart3 = (TextView)findViewById(R.id.titleTvPart3);
        titleTvPart3.setText(R.string.movetitleTvPart3);
        tvPart3 = (TextView)findViewById(R.id.tvPart3);
        tvPart3.setText(R.string.movetvPart3);
        cdPart2 = (TextView)findViewById(R.id.cdPart2);
        cdPart2.setText(R.string.movecdPart2);
        tvPart4 = (TextView)findViewById(R.id.tvPart4);

        //back button in toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.animationsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Move A View With Animation");
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setExpandedTitleMarginStart(30);
        collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.LEFT);
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.BOTTOM);
        collapsingToolbarLayout.animate();
        collapsingToolbarLayout.canScrollVertically(View.FOCUS_UP);

        ImageView im = (ImageView)findViewById(R.id.collapseBg);
        im.setImageResource(R.mipmap.anim);
        //Intent intent = getIntent();
        //int position = intent.getIntExtra("Item position",-1);



    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {

        overridePendingTransition(R.anim.activity_fade_in,R.anim.activity_fade_out);
        //ActivityCompat.finishAfterTransition(this);
        super.onBackPressed();
    }
}
