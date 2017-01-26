package time.kisoo.time.time2.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.dagger2.component.activity.DaggerFontDetailActivityComponent;
import time.kisoo.time.time2.dagger2.module.activity.FontDetailActivityModule;
import time.kisoo.time.time2.databinding.FontDetailActivityBinding;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.view.base.BaseActivity;
import time.kisoo.time.time2.viewmodel.activity.FontDetailActivityVM;

/**
 * Created by KiSoo on 2017/1/24.
 */

public class FontDetailActivity extends BaseActivity<FontDetailActivityBinding> {

    @Inject
    FontDetailActivityVM viewModel;

    private TextFont font;

    @Override
    protected void initModelWithDagger2() {
        DaggerFontDetailActivityComponent.builder()
                .appComponent(((App) getApplication())
                .component())
                .fontDetailActivityModule(new FontDetailActivityModule((FontDetailActivity) context,font))
                .build()
                .inject((FontDetailActivity) context);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_font_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        font = (TextFont) getIntent().getSerializableExtra(Constant.KEY_FONT);
        super.onCreate(savedInstanceState);
        initToolbar(binding.rlToolbar.tbMain, true);
    }

    @Override
    protected void bindView() {
        super.bindView();
        binding.setViewModel(viewModel);
    }


}
