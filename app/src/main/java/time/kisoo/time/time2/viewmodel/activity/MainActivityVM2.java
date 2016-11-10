package time.kisoo.time.time2.viewmodel.activity;

import android.databinding.ObservableField;
import android.support.design.widget.NavigationView;
import android.view.Gravity;

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
@Deprecated
public class MainActivityVM2 extends BaseViewModel {

    public MainActivity context;

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<NavigationView.OnNavigationItemSelectedListener> listener = new ObservableField<>();

    @Inject
    public MainActivityVM2(MainActivity activity) {
        this.context = activity;
        this.title.set(context.getString(R.string.note_show));
        this.listener.set(item -> {
            item.setChecked(true);
            title.set((String) item.getTitle());
            context.chooseFragment(item.getItemId());
            context.binding.dlDrawer.closeDrawer(Gravity.LEFT);
            return true;
        });
    }

}
