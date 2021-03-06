package time.kisoo.time.time2.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.databinding.EmptyViewBinding;
import time.kisoo.time.time2.databinding.ItemClickBinding;
import time.kisoo.time.time2.databinding.ItemSlidinggBinding;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemClick;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemEmpty;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemSlide;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BaseItemSettingVM> list;

    public SettingAdapter(ArrayList<BaseItemSettingVM> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Constant.TYPE_SLIDE:
                return ViewHolder.<EmptyViewBinding>getInstance(parent, R.layout.item_slide);
            case Constant.TYPE_EMPTY:
                return ViewHolder.<EmptyViewBinding>getInstance(parent, R.layout.item_empty);
            case Constant.TYPE_CLICK:
                return ViewHolder.<EmptyViewBinding>getInstance(parent, R.layout.item_click);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Constant.TYPE_EMPTY:
                ((ViewHolder<EmptyViewBinding>) holder).binding.setViewModel((BaseItemEmpty) list.get(position));
                break;
            case Constant.TYPE_CLICK:
                ((ViewHolder<ItemClickBinding>) holder).binding.setViewModel((BaseItemClick) list.get(position));
                break;
            case Constant.TYPE_SLIDE:
                ((ViewHolder<ItemSlidinggBinding>) holder).binding.setViewModel((BaseItemSlide) list.get(position));
                break;
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
