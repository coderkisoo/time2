package time.kisoo.time.time2.dagger2.component.activity;

import dagger.Component;
import time.kisoo.time.time2.dagger2.component.AppComponent;
import time.kisoo.time.time2.dagger2.component.ScopeActivity;
import time.kisoo.time.time2.dagger2.module.activity.WriteNoteActivityModule;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;

/**
 * Created by KiSoo on 2016/11/8.
 */

@Component(
        dependencies = AppComponent.class,
        modules = WriteNoteActivityModule.class
)
@ScopeActivity
public interface WriteNodeActivityComponent {
    void inject(WriteNoteActivity activity);
}
