package time.kisoo.time.time2.viewmodel.fragment;

import android.content.Intent;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import javax.inject.Inject;

import time.kisoo.time.time2.model.DateInfo;
import time.kisoo.time.time2.model.Message;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;
import time.kisoo.time.time2.view.adapter.MainPageAdapter;
import time.kisoo.time.time2.view.fragment.MainFragment;
import time.kisoo.time.time2.viewmodel.BaseViewModel;
import time.kisoo.time.time2.viewmodel.DateItems;

/**
 * Created by KiSoo on 2016/11/9.
 */

public class MainFragmentVM extends BaseViewModel {

    private MainActivity context;
    private MainFragment mainFragment;
    public DateItems items = new DateItems();
    @Bindable
    public DefaultItemAnimator animator = new DefaultItemAnimator();
    @Bindable
    public RecyclerView.Adapter adapter;
    @Bindable
    public RecyclerView.LayoutManager manager;

    @Bindable
    public RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING) {
                mainFragment.showFab(dy > 0);
            }
        }
    };

    @Inject
    public MainFragmentVM(MainActivity context, MainFragment mainFragment) {
        this.context = context;
        this.mainFragment = mainFragment;
        this.adapter = new MainPageAdapter(items.dates);
        this.manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        initTestData();
    }



    public void note(View view) {
        mainFragment.startActivity(new Intent(context, WriteNoteActivity.class));
    }


    public void clock(View view) {

    }

    public void closeFab(View view) {
        mainFragment.closeFab(view);
    }


    private void initTestData() {
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例1", "内容\n\n\n\n\nwsafsaf", new ObservableArrayList<String>())));
        items.dates.add(new DateInfo(new ObservableBoolean(false), new Message("示例2", "内容", new ObservableArrayList<>())));
    }

}
