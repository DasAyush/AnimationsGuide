package com.example.android.animationsdemo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class MoveViewAnim extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_details);

        //back button in toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.animationsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("Just checking");
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
