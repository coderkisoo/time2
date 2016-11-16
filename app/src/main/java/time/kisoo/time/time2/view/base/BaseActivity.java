package time.kisoo.time.time2.view.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by KiSoo on 2016/11/1.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    public T binding;
    public final String TAG = this.getClass().getName();
    public Activity context;


    /**
     * build view-data-binding
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initModelWithDagger2();
        bindView();
    }

    /**
     * bind the layout with dataBindingUtil
     */
    protected void bindView() {
        binding = DataBindingUtil.setContentView(this, layoutId());//bind the activity to view
    }

    /**
     * 依赖注入
     */
    protected abstract void initModelWithDagger2();

    /**
     * get the id of contentView
     * @return
     */
    protected abstract int layoutId();

    /**
     * init toolbar
     * ex:title、toolbar_background、title_text_color
     * @param toolbar
     * @param disPlay
     */
    public void initToolbar(Toolbar toolbar,  boolean disPlay) {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(disPlay);
    }

    public void disPlayMenu(Menu menu,int id){
        getMenuInflater().inflate(id,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                home();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void home(){

    }


}
