package time.kisoo.time.time2.dagger2.module.activity;

import android.content.Context;
import android.text.SpannableStringBuilder;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;
import time.kisoo.time.time2.viewmodel.activity.WriteNoteActivityVM;

/**
 * Created by KiSoo on 2016/11/8.
 */

@Module
public class WriteNoteActivityModule extends BaseActivityModule<WriteNoteActivity>{
    private SpannableStringBuilder builder;

    public WriteNoteActivityModule(WriteNoteActivity context,SpannableStringBuilder builder) {
        super(context);
        this.builder = builder;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    WriteNoteActivityVM provideViewModel() {
        return new WriteNoteActivityVM(mContext,builder);
    }
}
