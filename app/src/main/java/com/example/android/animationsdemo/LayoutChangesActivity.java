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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.animationsdemo.Objects.GridDataModel;
import com.example.android.animationsdemo.Adapters.GridRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * This sample demonstrates how to use system-provided, automatic layout transitions. Layout
 * transitions are animations that occur when views are added to, removed from, or changed within
 * a {@link ViewGroup}.
 *
 * <p>In this sample, the user can add rows to and remove rows from a vertical
 * {@link android.widget.LinearLayout}.</p>
 */
public class LayoutChangesActivity extends AppCompatActivity implements
        GridRecyclerViewAdapter.ItemListener {
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */
    //private ViewGroup mContainerView;
    RecyclerView gridRecyclerView;
    ArrayList<GridDataModel> arrayList;
    GridRecyclerViewAdapter gridRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);

        //mContainerView = (ViewGroup) findViewById(R.id.container);

        gridRecyclerView = (RecyclerView)findViewById(R.id.gridRecyclerView);
        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        gridRecyclerView.setLayoutManager(manager);

        gridRecyclerViewAdapter = new GridRecyclerViewAdapter
                (this, arrayList, this);
        gridRecyclerView.setAdapter(gridRecyclerViewAdapter);

        //Add items to the grid recycler view
        AddDataToGridRecyclerView();

    }

    public void AddDataToGridRecyclerView(){
        arrayList = new ArrayList<GridDataModel>();
        arrayList.add(new GridDataModel("Item 1", R.drawable.ic_action_info, "#673BB7"));
        arrayList.add(new GridDataModel("Item 2", R.drawable.ic_action_new, "#673BB7"));
        arrayList.add(new GridDataModel("Item 3", R.drawable.ic_action_photo, "#673BB7"));
        arrayList.add(new GridDataModel("Item 4", R.drawable.ic_add_black_24dp, "#673BB7"));
        arrayList.add(new GridDataModel("Item 5", R.drawable.ic_launcher, "#673BB7"));
        arrayList.add(new GridDataModel("Item 6", R.drawable.ic_list_remove, "#673BB7"));
        gridRecyclerViewAdapter.setData(arrayList);

    }

    @Override
    public void onItemClick(GridDataModel item) {

        Toast.makeText(getApplicationContext(), " is clicked", Toast.LENGTH_SHORT).show();

    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_layout_changes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                return true;

            case R.id.action_add_item:
                // Hide the "empty" view since there is now at least one item in the list.
                findViewById(android.R.id.empty).setVisibility(View.GONE);
                addItem();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addItem() {
        // Instantiate a new "row" view.
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.list_item_example, mContainerView, false);

        // Set the text in the new row to a random country.
        ((TextView) newView.findViewById(android.R.id.text1)).setText(
                COUNTRIES[(int) (Math.random() * COUNTRIES.length)]);

        // Set a click listener for the "X" button in the row that will remove the row.
        newView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remove the row from its parent (the container view).
                // Because mContainerView has android:animateLayoutChanges set to true,
                // this removal is automatically animated.
                mContainerView.removeView(newView);

                // If there are no rows remaining, show the empty view.
                if (mContainerView.getChildCount() == 0) {
                    findViewById(android.R.id.empty).setVisibility(View.VISIBLE);
                }
            }
        });

        // Because mContainerView has android:animateLayoutChanges set to true,
        // adding this view is automatically animated.
        mContainerView.addView(newView, 0);
    }

*/
}
