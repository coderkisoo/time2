package time.kisoo.time.time2.viewmodel.fragment;

import javax.inject.Inject;

import time.kisoo.time.time2.view.fragment.MainFragment;

/**
 * Created by KiSoo on 2016/11/9.
 */

public class MainFragmentVM {

    private final MainFragment fragment;

    @Inject
    public MainFragmentVM(MainFragment fragment){
        this.fragment = fragment;
    }
}
