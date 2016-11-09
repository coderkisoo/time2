package time.kisoo.time.time2.dagger2.module;

import android.content.Context;
import android.text.SpannableStringBuilder;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;
import time.kisoo.time.time2.viewmodel.WriteNoteActivityVM;

/**
 * Created by KiSoo on 2016/11/8.
 */

@Module
public class WriteNoteActivityModule {
    private WriteNoteActivity context;
    private SpannableStringBuilder builder;

    public WriteNoteActivityModule(WriteNoteActivity context,SpannableStringBuilder builder) {
        this.context = context;
        this.builder = builder;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    WriteNoteActivityVM provideViewModel() {
        return new WriteNoteActivityVM(context,builder);
    }
}
