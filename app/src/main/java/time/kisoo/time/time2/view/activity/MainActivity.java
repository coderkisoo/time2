package time.kisoo.time.time2.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;
import time.kisoo.time.time2.dagger2.component.activity.DaggerMainActivityComponent;
import time.kisoo.time.time2.dagger2.component.activity.MainActivityComponent;
import time.kisoo.time.time2.dagger2.module.activity.MainActivityModule;
import time.kisoo.time.time2.databinding.MainActivityBinding;
import time.kisoo.time.time2.view.base.BaseActivity;
import time.kisoo.time.time2.view.fragment.MainFragment;
import time.kisoo.time.time2.view.fragment.SettingFragment;
import time.kisoo.time.time2.viewmodel.activity.MainActivityVM;


public class MainActivity extends BaseActivity<MainActivityBinding> {

    @Inject
    MainActivityVM activityVM;

    public MainActivityComponent component;
    private List<Fragment> fragments;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
        initFragments();
        chooseFragment(R.id.menu_item_1);
    }

    /**
     * 每次onCreate重新init
     */
    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new SettingFragment());
    }

    @Override
    public void home() {
        super.home();
        binding.dlDrawer.openDrawer(Gravity.LEFT);
    }

    /**
     * 选择fragment
     *
     * @param itemId
     */
    public void chooseFragment(int itemId) {
        Observable
                .create((Observable.OnSubscribe<Integer>) subscriber -> subscriber.onNext(itemId))
                .map(this::chooseFragmentWithId)
                .map(this::structTransaction)
                .doOnNext(fragmentTransaction -> binding.dlDrawer.closeDrawer(Gravity.LEFT))
                .subscribe(FragmentTransaction::commitAllowingStateLoss);
    }


    /**
     * 构造fragmentTransaction
     *
     * @param fragment
     * @return
     */
    private FragmentTransaction structTransaction(android.support.v4.app.Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment == this.currentFragment)
            return transaction;
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.fl_content, fragment);
        }
        if (currentFragment != null)
            transaction.hide(currentFragment);
        this.currentFragment = fragment;
        return transaction;
    }

    /**
     * 选取fragment
     *
     * @param id
     * @return
     */
    private android.support.v4.app.Fragment chooseFragmentWithId(Integer id) {
        switch (id) {
            case R.id.menu_item_1:
                return fragments.get(0);
            case R.id.menu_item_setting:
                return fragments.get(1);
            default:
                return fragments.get(0);
        }
    }

    @Override
    protected void bindView() {
        super.bindView();
        binding.setViewModel(activityVM);
    }

    @Override
    protected void initModelWithDagger2() {
        component = DaggerMainActivityComponent.builder()
                .appComponent(((App) getApplication()).component())
                .mainActivityModule(new MainActivityModule(this))
                .build();
        component.injectActivity(this);
    }


    private void initToolbar() {
        initToolbar(binding.rlTitle.tbMain, true);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

}
