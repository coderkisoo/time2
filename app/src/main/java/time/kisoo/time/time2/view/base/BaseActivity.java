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
import android.widget.TextView;

import time.kisoo.time.time2.R;

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
        bindView();
        initModelWithDagger2();
    }

    /**
     * bind the layout with dataBindingUtil
     */
    private void bindView() {
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
     * @param title
     * @param disPlay
     */
    public void initToolbar(Toolbar toolbar, String title, boolean disPlay) {
        toolbar.setTitle("");
        TextView tv_title= (TextView) toolbar.findViewById(R.id.tv_title);
        tv_title.setText(title);
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
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
