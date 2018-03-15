/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.animationsdemo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.support.v7.widget.SearchView;
import android.widget.LinearLayout;

import com.example.android.animationsdemo.Objects.CLickListener;
import com.example.android.animationsdemo.Objects.MainRecView;
import com.example.android.animationsdemo.Adapters.MainRecViewAdapter;
import com.example.android.animationsdemo.Objects.RecyclerItemTouchHelper;
import com.example.android.animationsdemo.Objects.Subject;
import com.example.android.animationsdemo.Adapters.SubjectListAdapter;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

/**
 * The launchpad activity for this sample project. This activity launches other activities that
 * demonstrate implementations of common animations.
 */
public class MainActivity extends AppCompatActivity implements CLickListener,
        RecyclerItemTouchHelper.RecyclerItemTouchHelperListener
{
    /**
     * This class describes an individual sample (the sample title, and the activity class that
     * demonstrates this sample).
     */
    private SubjectListAdapter mAdapter;

    public ArrayList<Subject> subjects;

    NestedScrollView nestedScrollView;

    CoordinatorLayout coordinatorLayout;
    RecyclerView recyclerView1, recyclerView2;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    MainRecViewAdapter recyclerViewHorizontalAdapter;
    LinearLayoutManager horizontalLayoutManager;
    ArrayList<MainRecView> icons;
    View childView;
    int recyclerViewItemPosition;
    com.github.clans.fab.FloatingActionButton fab1, fab2, fab3;
    MovingFloatingActionButton movingFloatingActionButton;
    FloatingActionMenu floatingActionMenu;
    GestureDetector gestureDetector;
    private int movingFabClickCount = 0;
    //FrameLayout.LayoutParams layoutParams_fab1, layoutParams_fab2, layoutParams_fab3;
    //Animation fab1_show,fab2_show,fab3_show,fab1_hide,fab2_hide,fab3_hide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Search for the animations
        final SearchView searchView = (SearchView) findViewById(R.id.search_product);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search for the animations");
        searchView.setBackgroundColor(Color.WHITE);
        searchView.onActionViewExpanded();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                searchView.clearFocus();
            }
        }, 300);
        //searchView.setIconified(true);
        //searchView.setIconifiedByDefault(true);

        //Setting the size of the text in the searchview
        LinearLayout linearLayout1 = (LinearLayout)searchView.getChildAt(0);
        LinearLayout linearLayout2 = (LinearLayout)linearLayout1.getChildAt(2);
        LinearLayout linearLayout3 = (LinearLayout)linearLayout2.getChildAt(1);
        AutoCompleteTextView autoCompleteTextView =
                (AutoCompleteTextView)linearLayout3.getChildAt(0);
        autoCompleteTextView.setTextSize(16);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        //Setting up the recycler view 1
        recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView1);
        //linear layout
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(recyclerViewLayoutManager);
        //Add items to the arraylist 1
        AddItemsToRecyclerViewArrayList1();
        recyclerViewHorizontalAdapter = new MainRecViewAdapter(MainActivity.this,icons);

        //horizontal layout
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        recyclerView1.setAdapter(recyclerViewHorizontalAdapter);

        new CountDownTimer(4000, 50) {

            public void onTick(long millisUntilFinished) {
                recyclerView1.scrollTo((int) (4000 - millisUntilFinished), 0);
            }

            public void onFinish() {

            }
        }.start();

        //Circular horizontal recycler view
        //horizontalLayoutManager.scrollToPosition(Integer.MAX_VALUE/2);


        //RecyclerView 2
        recyclerView2 = (RecyclerView)findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(recyclerViewLayoutManager);
        recyclerView2.setHasFixedSize(true);
        mAdapter = new SubjectListAdapter(getBaseContext(), subjects);
        recyclerView2.setAdapter(mAdapter);
        mAdapter.setcLickListener(this);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback =
                new RecyclerItemTouchHelper(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView2);


        //Add items to the arraylist 2
        AddSubjectsToRecyclerViewArrayList2();



        //SnapHelper snapHelper = new PagerSnapHelper();
        //snapHelper.attachToRecyclerView(recyclerView1);

        recyclerView1.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(MainActivity.this,
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return super.onSingleTapUp(e);
                        }
                    });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                childView = rv.findChildViewUnder(e.getX(),e.getY());

                if(childView!=null && gestureDetector.onTouchEvent(e)){
                    recyclerViewItemPosition = rv.getChildAdapterPosition(childView);
                    //Toast.makeText(MainActivity.this,icons.get(recyclerViewItemPosition),
                      //      Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        floatingActionMenu = (FloatingActionMenu) findViewById
                (R.id.material_design_android_floating_action_menu);
        fab1 = (com.github.clans.fab.FloatingActionButton) findViewById
                (R.id.material_design_floating_action_menu_item1);
        fab2 = (com.github.clans.fab.FloatingActionButton)findViewById
                (R.id.material_design_floating_action_menu_item2);
        fab3 = (com.github.clans.fab.FloatingActionButton)findViewById
                (R.id.material_design_floating_action_menu_item3);

        nestedScrollView = (NestedScrollView)findViewById(R.id.scroll);
        nestedScrollView.setSmoothScrollingEnabled(true);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX,
                                       int scrollY, int oldScrollX, int oldScrollY) {
                int changeY = scrollY - oldScrollY;
                int changeX = scrollX - oldScrollX;

                if((changeY>0 )&& floatingActionMenu.getVisibility() == View.VISIBLE)
                    floatingActionMenu.hideMenu(true);
                else if(changeY<=0 && floatingActionMenu.getVisibility() == View.INVISIBLE)
                    floatingActionMenu.showMenu(true);
            }
        });

        /*
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback
                = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT
                                                                    | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Row is swiped from recycler view
                // remove it from adapter
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                    int actionState, boolean isCurrentlyActive) {
                // view the background view
            }
        };

        // attaching the touch helper to recycler view
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView2);
        */


        //click on top fab
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        TransparentActivity.class);
                startActivity(intent);
            }
        });

        //collapsable toolbar
        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    //showOption(R.id.action_info);
                } else if (isShow) {
                    isShow = false;
                    //hideOption(R.id.action_info);
                }
            }
        });

        //Floating action buttons menu
        //movingFloatingActionButton = (MovingFloatingActionButton)
          //      findViewById(R.id.addAnimations);

    }


    private class SingleTapDetector extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof SubjectListAdapter.ViewHolder) {
            // get the removed item name to display it in snack bar
            String name = subjects.get(viewHolder.getAdapterPosition()).getTvCourseCode();

            // backup of removed item for undo purpose
            final Subject deletedSubject = subjects.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeSubject(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreSubject(deletedSubject, deletedIndex);
                    floatingActionMenu.showMenu(true);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
            floatingActionMenu.hideMenu(true);
        }

    }

    //move to another activity
    @Override
    public void itemClicked(View view, int position) {
        Intent intent = new Intent(this,ScrollingActivity.class);
        intent.putExtra("Item position",position);
        String transitionName = getString(R.string.transition);

        /*ActivityOptionsCompat activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view,
                        transitionName);
        ActivityCompat.startActivity(this,intent,activityOptionsCompat.toBundle());
        */
        startActivity(intent);
    }

    // function to add items in RecyclerView 1
    public void AddItemsToRecyclerViewArrayList1(){

        icons = new ArrayList<MainRecView>();
        icons.add(new MainRecView(R.mipmap.scrolling));
        icons.add(new MainRecView(R.mipmap.flipping));
        icons.add(new MainRecView(R.mipmap.sliding));
        icons.add(new MainRecView(R.mipmap.zooming));
        icons.add(new MainRecView(R.mipmap.grids));
    }

    // function to add items in RecyclerView 2
    public void AddSubjectsToRecyclerViewArrayList2() {

        subjects = new ArrayList<Subject>();
        subjects.add(new Subject("IT-302","Move a View with Animation"));

        subjects.add(new Subject("CS-309",
                "Move a View with Fling Animation"));

        subjects.add(new Subject("IT-301","Enlarge a view " +
                "with Zoom Animation"));

        subjects.add(new Subject("IT-303","Reveal or Hide a " +
                "View with Animation"));

        subjects.add(new Subject("CS-303","Property Animation"));

        subjects.add(new Subject("IT-304","Auto-Animate layout updates"));

        subjects.add(new Subject("IT-305","Animate layout changes " +
                "using a Transition"));

        mAdapter.setData(subjects);

    }


}
