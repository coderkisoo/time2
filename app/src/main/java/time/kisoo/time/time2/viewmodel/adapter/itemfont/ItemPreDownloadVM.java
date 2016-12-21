package time.kisoo.time.time2.viewmodel.adapter.itemfont;

import android.databinding.Bindable;
import android.view.View;

import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.util.ToastUtil;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class ItemPreDownloadVM extends BaseItemSettingVM {

    @Bindable
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ToastUtil.shortMessage("choose this");

        }
    };

    public ItemPreDownloadVM() {
        this.type = Constant.TYPE_PREDOWNLOAD;
    }

    public void onClickText(View view){
        ToastUtil.shortMessage("choose this");
    }
}
