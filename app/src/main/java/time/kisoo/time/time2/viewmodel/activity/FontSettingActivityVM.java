package time.kisoo.time.time2.viewmodel.activity;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.view.adapter.FontSettingAdapter;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.itemfont.ItemPreDownloadVM;

/**
 * Created by KiSoo on 2016/11/8.
 */

public class FontSettingActivityVM extends BaseObservable {

    private FontSettingActivity context;

    @Bindable
    public String title;
    @Bindable
    public FontSettingAdapter adapter;

    private List<BaseItemSettingVM> list;

    @Inject
    public FontSettingActivityVM(Context context) {
        this.context = (FontSettingActivity) context;
        this.title = context.getString(R.string.item_font);
        this.list = new ArrayList<>();
        initList();
        this.adapter = new FontSettingAdapter(list);
    }

    private void initList() {
        list.add(new ItemPreDownloadVM());
    }
}
