package time.kisoo.time.time2.viewmodel.activity;

import android.databinding.Bindable;
import android.support.design.widget.NavigationView;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.viewmodel.BaseViewModel;

/**
 * Created by KiSoo on 2016/11/7.
 */


/**
 * mainActivity - viewModel
 */
public class MainActivityVM extends BaseViewModel {

    public transient MainActivity context;

    @Bindable
    public String title;
    @Bindable
    public NavigationView.OnNavigationItemSelectedListener listener;

    @Inject
    public MainActivityVM(MainActivity activity) {
        this.context = activity;
        this.title = context.getString(R.string.note_show);
        this.listener = item -> {
            item.setCheckable(true);
            this.title = (String) item.getTitle();
            context.chooseFragment(item.getItemId());
            notifyChange();
            return true;
        };
    }


}
