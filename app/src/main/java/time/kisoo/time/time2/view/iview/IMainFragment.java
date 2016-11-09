package time.kisoo.time.time2.view.iview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by KiSoo on 2016/11/2.
 */

public interface IMainFragment {

    void more(View button);

    void note(View view);

    void clock(View view);

    void closeFab(View view);

    RecyclerView.OnScrollListener getListener();


}
