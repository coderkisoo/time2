package time.kisoo.time.time2.view.service;

import android.app.IntentService;
import android.content.Intent;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.model.bean.TextFont;
import time.kisoo.time.time2.util.FileUtil;

/**
 * Created by KiSoo on 2017/1/24.
 */

public class DownloadService extends IntentService {



    public DownloadService() {
        super("downloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        TextFont font = (TextFont) intent.getSerializableExtra(Constant.KEY_FONT);
        font.getFontFile()
                .downloadObservable(FileUtil.getFile(font.getFontName()), (integer, l) -> {

                })
                .doOnNext(path -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
