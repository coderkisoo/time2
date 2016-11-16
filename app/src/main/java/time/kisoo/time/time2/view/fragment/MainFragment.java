package time.kisoo.time.time2.view.fragment;

import android.view.View;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.dagger2.component.fragment.DaggerMainFragmentComponent;
import time.kisoo.time.time2.dagger2.component.fragment.MainFragmentComponent;
import time.kisoo.time.time2.dagger2.module.fragment.MainFragmentModule;
import time.kisoo.time.time2.databinding.MainFragmentBinding;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.base.BaseFragment;
import time.kisoo.time.time2.view.iview.IFragment;
import time.kisoo.time.time2.viewmodel.fragment.MainFragmentVM;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class MainFragment extends BaseFragment<MainFragmentBinding> implements IFragment {

    @Inject
    MainFragmentVM viewModel;

    MainFragmentComponent component;

    @Override
    public void bindView() {
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initModelWithDagger2() {
        this.component = DaggerMainFragmentComponent.builder()
                .mainActivityComponent(((MainActivity) context).component)
                .mainFragmentModule(new MainFragmentModule((MainActivity) context, this))
                .build();
        this.component.injectFragment(this);
        this.component.injectActivity((MainActivity) context);
    }

    /**
     * 是否展示floatActionMenu
     * @param show
     */
    public void showFab(boolean show) {
        if (show) {
            binding.rlFab.famMenu.hideMenu(true);
        } else {
            binding.rlFab.famMenu.showMenu(true);
        }
    }

    public void closeFab(View view) {
        binding.rlFab.famMenu.close(true);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_main;
    }

}
