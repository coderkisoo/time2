package time.kisoo.time.time2.view.fragment;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.databinding.MainFragmentBinding;
import time.kisoo.time.time2.model.DateInfo;
import time.kisoo.time.time2.model.Message;
import time.kisoo.time.time2.util.SnackbarUtil;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;
import time.kisoo.time.time2.view.adapter.MainPageAdapter;
import time.kisoo.time.time2.view.base.BaseFragment;
import time.kisoo.time.time2.view.iview.IMainFragment;
import time.kisoo.time.time2.viewmodel.DateItems;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class MainFragment extends BaseFragment<MainFragmentBinding> implements IMainFragment {

    DateItems items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        binding.setFragmentView(this);
        items = new DateItems();
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
        binding.rvContent.addOnScrollListener(onScrollListener);
        binding.rvContent.setAdapter(new MainPageAdapter(items.dates));
        binding.rvContent.setItemAnimator(new DefaultItemAnimator());
        binding.rvContent.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING) {
                if (dy > 0) {
                    binding.rlFab.famMenu.hideMenu(true);
                } else {
                    binding.rlFab.famMenu.showMenu(true);
                }
            }
        }
    };

    @Override
    public void more(View button) {
        SnackbarUtil.ShortSnackbar(binding.getRoot(), "" +
                "" +
                "", SnackbarUtil.Info).show();
    }

    @Override
    public void note(View view) {
        startActivity(new Intent(context, WriteNoteActivity.class));
    }

    @Override
    public void clock(View view) {

    }

    @Override
    public void closeFab(View view) {
        binding.rlFab.famMenu.close(true);
    }

    @Override
    public RecyclerView.OnScrollListener getListener() {
        return onScrollListener;
    }

    @Override
    protected int bindContentView() {
        return R.layout.fragment_main;
    }

}
