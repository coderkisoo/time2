package time.kisoo.time.time2.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.databinding.MainItemBinding;
import time.kisoo.time.time2.model.DateInfo;
import time.kisoo.time.time2.util.ScreenPixelUtil;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.BinderHolder> {

    private static final int TYPE_AUTO = 0;

    private ObservableArrayList<DateInfo> mDateInfo;
    private Context context;

    public MainPageAdapter(ObservableArrayList<DateInfo> mDateInfo) {
        this.mDateInfo = mDateInfo;
    }

    @Override
    public BinderHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (context == null)
            context = parent.getContext();
        switch (viewType) {
            case TYPE_AUTO:
                return new BinderHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_main_view, parent, false));
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_AUTO;
    }

    @Override
    public int getItemCount() {
        return mDateInfo.size();
    }

    @Override
    public void onBindViewHolder(BinderHolder holder, int position) {
        holder.binding.setDimen(ScreenPixelUtil.getInstance());
        holder.binding.setItem(mDateInfo.get(position));
        holder.binding.setController(this);
        holder.binding.gvPhotos.setAdapter(new MainPageGridViewAdapter(mDateInfo.get(position).getMessage().getImges(), context));
    }

    class BinderHolder extends RecyclerView.ViewHolder {

        private final MainItemBinding binding;

        BinderHolder(MainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

    }

    public void click(final DateInfo info, final View view) {
        PopupMenu menu = new PopupMenu(context, view);
        menu.getMenuInflater().inflate(R.menu.menu_item_more, menu.getMenu());
        menu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.menu_delete:
                            int position = mDateInfo.indexOf(info);
                            notifyItemRemoved(position);
                            mDateInfo.remove(position);
                            break;
                    }
                    return false;
                }
        );
        menu.show();
    }
}
