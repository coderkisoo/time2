package time.kisoo.time.time2.dagger2.module.activity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.view.activity.FontDetailActivity;
import time.kisoo.time.time2.viewmodel.activity.FontDetailActivityVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

@Module
public class FontDetailActivityModule extends BaseActivityModule<FontDetailActivity> {

    private TextFont mFont;

    public FontDetailActivityModule(FontDetailActivity mContext, TextFont font) {
        super(mContext);
        this.mFont = font;
    }

    @Provides
    Context getContext() {
        return mContext;
    }

    @Provides
    FontDetailActivityVM provideViewModel() {
        return new FontDetailActivityVM(mContext,mFont);
    }

}
