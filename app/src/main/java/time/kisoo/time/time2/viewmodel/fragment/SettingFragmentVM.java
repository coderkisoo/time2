package time.kisoo.time.time2.viewmodel.fragment;

import javax.inject.Inject;

import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.fragment.SettingFragment;
import time.kisoo.time.time2.viewmodel.BaseViewModel;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingFragmentVM extends BaseViewModel {
    private MainActivity context;
    private SettingFragment fragment;

    @Inject
    public SettingFragmentVM(MainActivity context, SettingFragment fragment) {
        this.context = context;
        this.fragment = fragment;
    }
}
