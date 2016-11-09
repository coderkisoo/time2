package time.kisoo.time.time2.viewmodel.activity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.design.widget.NavigationView;
import android.view.Gravity;

import javax.inject.Inject;

import time.kisoo.time.time2.BR;
import time.kisoo.time.time2.R;
import time.kisoo.time.time2.view.activity.MainActivity;

/**
 * Created by KiSoo on 2016/11/7.
 */


/**
 * mainActivity - viewModel
 */
public class MainActivityVM extends BaseObservable {

    public MainActivity context;

    @Bindable
    private String title;

    @Inject
    public MainActivityVM(MainActivity activity) {
        this.context = activity;
        this.title = context.getString(R.string.note_show);
    }

    @Bindable
    private NavigationView.OnNavigationItemSelectedListener listener = item -> {
        item.setChecked(true);
        setTitle((String) item.getTitle());
        context.chooseFragment(item.getItemId());
        context.binding.dlDrawer.closeDrawer(Gravity.LEFT);
        return true;
    };

    @Bindable
    public NavigationView.OnNavigationItemSelectedListener getListener() {
        return listener;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
//        notifyChange();
    }

}
