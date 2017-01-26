package time.kisoo.time.time2.viewmodel.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.view.View;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.util.DialogUtil;
import time.kisoo.time.time2.view.activity.FontDetailActivity;
import time.kisoo.time.time2.view.service.DownloadService;
import time.kisoo.time.time2.viewmodel.BaseViewModel;

/**
 * Created by KiSoo on 2017/1/24.
 */

public class FontDetailActivityVM extends BaseViewModel {

    private Context mContext;
    @Bindable
    public TextFont mFont;

    @Bindable
    public String title;

    @Bindable
    public String mSize;

    @Inject
    public FontDetailActivityVM(FontDetailActivity context, TextFont mFont) {
        this.mContext = context;
        this.mFont = mFont;
        this.title = mFont.getFontName();
        this.mSize = context.getResources().getString(R.string.size) + mFont.getFileSize();
    }

    @Bindable
    public void downLoad(View view) {
        DialogUtil.showDialog(mContext.getString(R.string.title),
                mContext.getString(R.string.if_download),
                (dialog, which) -> dialog.dismiss(),
                (dialog, which) -> {
                    dialog.dismiss();
                    Intent intent = new Intent(mContext, DownloadService.class);
                    intent.putExtra(Constant.KEY_FONT,mFont);
                    mContext.startService(intent);
                });
    }
}
