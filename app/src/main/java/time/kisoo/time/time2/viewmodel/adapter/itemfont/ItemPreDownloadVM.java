package time.kisoo.time.time2.viewmodel.adapter.itemfont;

import android.databinding.Bindable;
import android.view.View;

import cn.bmob.v3.datatype.BmobFile;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.util.ToastUtil;
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
    public View.OnClickListener listener = v -> ToastUtil.shortMessage("choose this");

    public ItemPreDownloadVM() {
        this.type = Constant.TYPE_PREDOWNLOAD;

    }

    public void onClickText(View view){
        ToastUtil.shortMessage("choose this");
    }
}
