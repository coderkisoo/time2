package time.kisoo.time.time2.viewmodel.adapter.itemfont;

import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.view.View;

import cn.bmob.v3.datatype.BmobFile;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.util.ToastUtil;
import time.kisoo.time.time2.view.activity.FontDetailActivity;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class ItemPreDownloadVM extends BaseItemSettingVM {

    @Bindable
    public BmobFile panelSrc;
    @Bindable
    public String fileSize;
    @Bindable
    public BmobFile fontFile;

    private TextFont mFont;

    private Context mContext;

    public String fontName;

    public ItemPreDownloadVM(Context context) {
        this.type = Constant.TYPE_PREDOWNLOAD;
        this.mContext = context;
    }

    public void onClickText(View view) {
        ToastUtil.shortMessage("choose this");
        Intent intent = new Intent(mContext, FontDetailActivity.class);
        intent.putExtra(Constant.KEY_FONT, mFont);
        mContext.startActivity(intent);
    }



    public void setFont(TextFont textFont) {
        this.mFont = textFont;
        this.fileSize = mFont.getFileSize();
        this.panelSrc = mFont.getSample();
        this.fontFile = mFont.getFontFile();
        this.fontName = mFont.getFontName();
    }
}
