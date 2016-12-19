package time.kisoo.time.time2.util;

import cn.mycommons.androidsizeutil.AndroidSizeUtil;
import cn.mycommons.androidsizeutil.DimenUtil;

/**
 * Created by KiSoo on 2016/11/7.
 */

public final class ScreenPixelUtil {
    private static DimenUtil dimenUtil;

    public static DimenUtil getInstance() {
        if (dimenUtil == null)
            dimenUtil = AndroidSizeUtil.newDimenUtil();
        return dimenUtil;
    }

    public static int getScreenWidth() {
        return getInstance().getScreenWidth();
    }

    /**
     * get the times divided by photo width
     * @param width
     * @return
     */
    public static int getScreenWidthTimes(int width) {
        int times = 3*width/getInstance().getScreenWidth();
        if (getInstance().getScreenWidth() % width != 0)
            times++;
        return times;
    }

    /**
     * get the times divided by photo height
     * @param height
     * @return
     */
    public static int getScreenHeightTimes(int height){
        int times = 3*height/getInstance().getScreenHeight();
        if (getInstance().getScreenHeight() % height != 0)
            times++;
        return times;
    }

    public static int getScreenHeight() {
        return getInstance().getScreenHeight();
    }

}
