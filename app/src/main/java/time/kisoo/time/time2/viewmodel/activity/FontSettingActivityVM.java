package time.kisoo.time.time2.viewmodel.activity;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.bmob.v3.BmobQuery;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import time.kisoo.time.time2.R;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.util.Log;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.view.adapter.FontSettingAdapter;
import time.kisoo.time.time2.viewmodel.BaseViewModel;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.itemfont.ItemPreDownloadVM;

/**
 * Created by KiSoo on 2016/11/8.
 */

public class FontSettingActivityVM extends BaseViewModel {

    private FontSettingActivity context;

    @Bindable
    public String title;

    @Inject
    public FontSettingActivityVM(Context context) {
        this.context = (FontSettingActivity) context;
        this.title = context.getString(R.string.item_font);
        this.list = new ArrayList<>();
        this.adapter = new FontSettingAdapter(list);
        this.manager = new LinearLayoutManager(context);
        this.onRefreshListener = () ->
                new BmobQuery<TextFont>()
                        .findObjectsObservable(TextFont.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<List<TextFont>>() {
                            @Override
                            public void onCompleted() {
                                adapter.notifyDataSetChanged();
                                isRefreshing.set(false);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                Log.e(FontSettingActivityVM.this.context.TAG, throwable.getMessage());
                                isRefreshing.set(false);
                            }

                            @Override
                            public void onNext(List<TextFont> textFonts) {
                                list.clear();
                                for (TextFont font : textFonts) {
                                    ItemPreDownloadVM vm = new ItemPreDownloadVM();
                                    vm.fileSize = font.getFileSize();
                                    vm.panelSrc = font.getSample();
                                    list.add(vm);
                                }
                            }
                        });
    }


    @Bindable
    public FontSettingAdapter adapter;

    @Bindable
    public RecyclerView.LayoutManager manager;

    @Bindable
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener;

    @Bindable
    public ObservableBoolean isRefreshing = new ObservableBoolean(false);

    private List<BaseItemSettingVM> list;


    public void refresh() {
        isRefreshing.set(true);
        onRefreshListener.onRefresh();
    }
}
