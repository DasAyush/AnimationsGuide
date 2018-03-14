package com.example.android.animationsdemo;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ayush on 26/2/18.
 */

public class MovingFloatingActionButton extends FloatingActionButton implements View.OnTouchListener {

    private final static float CLICK_DRAG_TOLERANCE = 10;
    private float downRawX, downRawY;
    private float dx, dy;

    public MovingFloatingActionButton(Context context) {
        super(context);init();
    }

    public MovingFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MovingFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        int action = motionEvent.getAction();

        if (action == MotionEvent.ACTION_DOWN){
            downRawX = motionEvent.getRawX();
            downRawY = motionEvent.getRawY();

            dx = view.getX() - downRawX -200;
            dy = view.getY() - downRawY -200;

            return true; //consumed
        }

        else if (action == MotionEvent.ACTION_MOVE) {

            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();

            View viewParent = (View)view.getParent();
            int parentWidth = viewParent.getWidth();
            int parentHeight = viewParent.getHeight();

            float newX = motionEvent.getRawX() + dx +200;
            newX = Math.max(0, newX); // Don't allow the FAB past the left hand side of the parent
            newX = Math.min(parentWidth - viewWidth, newX); // Don't allow the FAB past the right hand side of the parent

            float newY = motionEvent.getRawY() + dy +200;
            newY = Math.max(0, newY); // Don't allow the FAB past the top of the parent
            newY = Math.min(parentHeight - viewHeight, newY); // Don't allow the FAB past the bottom of the parent

            view.animate()
                    .x(newX)
                    .y(newY)
                    .setDuration(0)
                    .start();

            return true; // Consumed

        }
        else if (action == MotionEvent.ACTION_UP) {

            float upRawX = motionEvent.getRawX();
            float upRawY = motionEvent.getRawY();

            float upDX = upRawX - downRawX + 200;
            float upDY = upRawY - downRawY + 200;

            if (Math.abs(upDX) < CLICK_DRAG_TOLERANCE && Math.abs(upDY) < CLICK_DRAG_TOLERANCE) { // A click
                return performClick();
            }
            else { // A drag
                return true; // Consumed
            }

        }

        else {
            return super.onTouchEvent(motionEvent);
        }
    }



}
