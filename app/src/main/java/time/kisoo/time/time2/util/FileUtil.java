package time.kisoo.time.time2.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by KiSoo on 2017/1/24.
 */

public class FileUtil {
    public static File getFile(String name){
        return new File(Environment.getExternalStorageDirectory().getPath()+"/"+name+".ttf");
    }
}
