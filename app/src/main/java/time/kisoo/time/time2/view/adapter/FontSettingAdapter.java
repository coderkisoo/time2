package time.kisoo.time.time2.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.databinding.EmptyViewBinding;
import time.kisoo.time.time2.databinding.ItemDownLoadBinding;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.itemfont.ItemPreDownloadVM;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemEmpty;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class FontSettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<BaseItemSettingVM> list;

    public FontSettingAdapter(List<BaseItemSettingVM> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constant.TYPE_DOWNLOADED:
            case Constant.TYPE_PREDOWNLOAD:
            case Constant.TYPE_DOWNLOADING:
                return ViewHolder.<ItemDownLoadBinding>getInstance(parent, R.layout.item_download);
            case Constant.TYPE_EMPTY:
                return ViewHolder.<EmptyViewBinding>getInstance(parent, R.layout.item_empty);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Constant.TYPE_DOWNLOADED:
                ((ViewHolder<ItemDownLoadBinding>) holder).binding.setViewModel((ItemPreDownloadVM) list.get(position));
            case Constant.TYPE_EMPTY:
                ((ViewHolder<EmptyViewBinding>) holder).binding.setViewModel((BaseItemEmpty) list.get(position));

        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
