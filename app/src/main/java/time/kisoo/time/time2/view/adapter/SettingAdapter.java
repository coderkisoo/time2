package time.kisoo.time.time2.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.databinding.EmptyViewBinding;
import time.kisoo.time.time2.databinding.ItemClickBinding;
import time.kisoo.time.time2.databinding.ItemSlidinggBinding;
import time.kisoo.time.time2.viewmodel.adapter.ItemClick;
import time.kisoo.time.time2.viewmodel.adapter.ItemEmpty;
import time.kisoo.time.time2.viewmodel.adapter.ItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.ItemSlide;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ItemSettingVM> list;
    public static final int TYPE_CLICK = 0;
    public static final int TYPE_SLIDE = 1;
    public static final int TYPE_EMPTY = 2;

    public SettingAdapter(ArrayList<ItemSettingVM> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_SLIDE:
                return new SlideViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_slide, parent, false));
            case TYPE_EMPTY:
                return new EmptyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_empty, parent, false));
            case TYPE_CLICK:
                return new ClickViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_click,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_EMPTY:
                ((EmptyViewHolder) holder).binding.setViewModel((ItemEmpty) list.get(position));
                break;
            case TYPE_CLICK:
                ((ClickViewHolder) holder).binding.setViewModel((ItemClick) list.get(position));
                break;
            case TYPE_SLIDE:
                ((SlideViewHolder) holder).binding.setViewModel((ItemSlide) list.get(position));
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

    private class SlideViewHolder extends RecyclerView.ViewHolder {

        private ItemSlidinggBinding binding;

        SlideViewHolder(ItemSlidinggBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    private class ClickViewHolder extends RecyclerView.ViewHolder {

        private ItemClickBinding binding;

        ClickViewHolder(ItemClickBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    private class EmptyViewHolder extends RecyclerView.ViewHolder {

        private EmptyViewBinding binding;

        EmptyViewHolder(EmptyViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
