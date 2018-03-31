package com.example.android.animationsdemo.databinding;
import com.example.android.animationsdemo.R;
import com.example.android.animationsdemo.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar, 1);
        sViewsWithIds.put(R.id.toolbar_layout, 2);
        sViewsWithIds.put(R.id.scroll, 3);
        sViewsWithIds.put(R.id.linearLayoutRecView12, 4);
        sViewsWithIds.put(R.id.tvMixedSamples, 5);
        sViewsWithIds.put(R.id.recyclerView1, 6);
        sViewsWithIds.put(R.id.tvFurtherFakers, 7);
        sViewsWithIds.put(R.id.recyclerView2, 8);
        sViewsWithIds.put(R.id.material_design_android_floating_action_menu, 9);
        sViewsWithIds.put(R.id.material_design_floating_action_menu_item1, 10);
        sViewsWithIds.put(R.id.material_design_floating_action_menu_item2, 11);
        sViewsWithIds.put(R.id.material_design_floating_action_menu_item3, 12);
    }
    // views
    @NonNull
    public final android.support.design.widget.AppBarLayout appBar;
    @NonNull
    public final android.support.design.widget.CoordinatorLayout coordinator;
    @NonNull
    public final android.widget.LinearLayout linearLayoutRecView12;
    @NonNull
    public final com.github.clans.fab.FloatingActionMenu materialDesignAndroidFloatingActionMenu;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton materialDesignFloatingActionMenuItem1;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton materialDesignFloatingActionMenuItem2;
    @NonNull
    public final com.github.clans.fab.FloatingActionButton materialDesignFloatingActionMenuItem3;
    @NonNull
    public final android.support.v7.widget.RecyclerView recyclerView1;
    @NonNull
    public final android.support.v7.widget.RecyclerView recyclerView2;
    @NonNull
    public final android.support.v4.widget.NestedScrollView scroll;
    @NonNull
    public final android.support.design.widget.CollapsingToolbarLayout toolbarLayout;
    @NonNull
    public final android.widget.TextView tvFurtherFakers;
    @NonNull
    public final android.widget.TextView tvMixedSamples;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.appBar = (android.support.design.widget.AppBarLayout) bindings[1];
        this.coordinator = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.coordinator.setTag(null);
        this.linearLayoutRecView12 = (android.widget.LinearLayout) bindings[4];
        this.materialDesignAndroidFloatingActionMenu = (com.github.clans.fab.FloatingActionMenu) bindings[9];
        this.materialDesignFloatingActionMenuItem1 = (com.github.clans.fab.FloatingActionButton) bindings[10];
        this.materialDesignFloatingActionMenuItem2 = (com.github.clans.fab.FloatingActionButton) bindings[11];
        this.materialDesignFloatingActionMenuItem3 = (com.github.clans.fab.FloatingActionButton) bindings[12];
        this.recyclerView1 = (android.support.v7.widget.RecyclerView) bindings[6];
        this.recyclerView2 = (android.support.v7.widget.RecyclerView) bindings[8];
        this.scroll = (android.support.v4.widget.NestedScrollView) bindings[3];
        this.toolbarLayout = (android.support.design.widget.CollapsingToolbarLayout) bindings[2];
        this.tvFurtherFakers = (android.widget.TextView) bindings[7];
        this.tvMixedSamples = (android.widget.TextView) bindings[5];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.example.android.animationsdemo.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.animationsdemo.R.layout.activity_main, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}