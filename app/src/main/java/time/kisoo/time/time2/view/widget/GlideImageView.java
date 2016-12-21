package time.kisoo.time.time2.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by KiSoo on 2016/11/7.
 */

public class GlideImageView extends ImageView {
    public GlideImageView(Context context) {
        super(context);
    }

    public GlideImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSrc(String path){
        Glide.with(getContext()).load(path).into(this);
    }

}
