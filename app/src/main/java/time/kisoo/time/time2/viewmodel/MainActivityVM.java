package time.kisoo.time.time2.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.design.widget.NavigationView;

import javax.inject.Inject;

import time.kisoo.time.time2.view.activity.MainActivity;

/**
 * Created by KiSoo on 2016/11/7.
 */


/**
 * mainActivity - viewModel
 */
public class MainActivityVM extends BaseObservable {

    public MainActivity context;

    @Inject
    public MainActivityVM(MainActivity activity) {
        this.context = activity;
    }

    @Bindable
    private NavigationView.OnNavigationItemSelectedListener listener = item -> {
        item.setCheckable(true);
        item.setChecked(true);
        return true;
    };

    @Bindable
    public NavigationView.OnNavigationItemSelectedListener getListener() {
        return listener;
    }

}
