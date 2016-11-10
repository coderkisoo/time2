package time.kisoo.time.time2.view.fragment;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.dagger2.component.fragment.DaggerSettingFragmentComponent;
import time.kisoo.time.time2.dagger2.component.fragment.SettingFragmentComponent;
import time.kisoo.time.time2.dagger2.module.fragment.SettingFragmentModule;
import time.kisoo.time.time2.databinding.SettingFragmentBinding;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.base.BaseFragment;
import time.kisoo.time.time2.viewmodel.fragment.SettingFragmentVM;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingFragment extends BaseFragment<SettingFragmentBinding> {

    @Inject
    SettingFragmentVM viewModel;

    public SettingFragmentComponent component;


    @Override
    protected int layoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initModelWithDagger2() {
        component = DaggerSettingFragmentComponent.builder()
                .mainActivityComponent(((MainActivity) context).component)
                .settingFragmentModule(new SettingFragmentModule((MainActivity) context, this))
                .build();
        component.injectActivity((MainActivity) context);
        component.injectFragment(this);
    }

    @Override
    public void bindView() {
        binding.setViewModel(viewModel);
    }
}
