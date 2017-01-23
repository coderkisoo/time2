package time.kisoo.time.time2.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;
import time.kisoo.time.time2.dagger2.component.activity.DaggerFontSettingActivityComponent;
import time.kisoo.time.time2.dagger2.module.activity.FontSettingActivityModule;
import time.kisoo.time.time2.dagger2.module.view.FontListLayoutModule;
import time.kisoo.time.time2.databinding.FontListLayoutBinding;
import time.kisoo.time.time2.databinding.FontSettingActivityBinding;
import time.kisoo.time.time2.view.base.BaseActivity;
import time.kisoo.time.time2.viewmodel.activity.FontSettingActivityVM;
import time.kisoo.time.time2.viewmodel.view.FontListLayoutVM;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class FontSettingActivity extends BaseActivity<FontSettingActivityBinding> {

    @Inject
    FontSettingActivityVM viewModel;
    @Inject
    FontListLayoutVM fontListLayoutVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar(binding.rlToolbar.tbMain, true);
    }

    @Override
    protected void initModelWithDagger2() {
        DaggerFontSettingActivityComponent
                .builder()
                .appComponent(((App) getApplication()).component())
                .fontSettingActivityModule(new FontSettingActivityModule(this))
                .fontListLayoutModule(new FontListLayoutModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void bindView() {
        super.bindView();
        binding.setViewModel(viewModel);
        binding.vsLoading.setOnInflateListener((viewStub, view) -> {
            FontListLayoutBinding fontListLayoutBinding = DataBindingUtil.bind(view);
            fontListLayoutBinding.setViewModel(fontListLayoutVM);
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_font_setting;
    }
}
