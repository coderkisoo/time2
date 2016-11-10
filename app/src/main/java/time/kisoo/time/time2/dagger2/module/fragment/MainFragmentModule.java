package time.kisoo.time.time2.dagger2.module.fragment;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.fragment.MainFragment;
import time.kisoo.time.time2.viewmodel.fragment.MainFragmentVM;

/**
 * Created by KiSoo on 2016/11/9.
 */

@Module
public class MainFragmentModule extends BaseFragmentModule<MainActivity,MainFragment>{

    public MainFragmentModule(MainActivity context, MainFragment mainFragment) {
        super(context, mainFragment);
    }


    @Provides
    MainFragmentVM provideViewModel() {
        return new MainFragmentVM(context,fragment);
    }

    @Provides
    MainActivity provideContext() {
        return context;
    }

    @Provides
    MainFragment provideFragment(){
        return fragment;
    }


}
