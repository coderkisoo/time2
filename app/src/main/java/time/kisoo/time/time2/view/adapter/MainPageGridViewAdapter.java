package time.kisoo.time.time2.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.databinding.ImageItemBinding;

/**
 * Created by KiSoo on 2016/11/7.
 */

public class MainPageGridViewAdapter extends BaseAdapter {

    private ObservableArrayList<String> imgs;
    private LayoutInflater inflater;

    /**
     * 最多展示4个
     *
     * @param imags
     * @param context
     */
    public MainPageGridViewAdapter(ObservableArrayList<String> imags, Context context) {
        this.imgs = imags;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imgs.size() > 4 ? 4 : imgs.size();
    }

    @Override
    public Object getItem(int position) {
        return imgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ImageItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_grid_view, parent, false);
            binding.setPath(imgs.get(position));
            convertView = binding.getRoot();
        }
        return convertView;
    }

}
