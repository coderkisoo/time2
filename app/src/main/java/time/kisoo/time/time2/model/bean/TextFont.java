package time.kisoo.time.time2.model.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class TextFont extends BmobObject {
    private BmobFile sample;
    private String fontName;//font name
    private BmobFile fontFile;//font file
    private String fileSize;//file size
    private int downloadTime;//time of download

    public String getFontName() {
        return fontName;
    }

    public BmobFile getSample() {
        return sample;
    }

    public void setSample(BmobFile sample) {
        this.sample = sample;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public BmobFile getFontFile() {
        return fontFile;
    }

    public void setFontFile(BmobFile fontFile) {
        this.fontFile = fontFile;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public int getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(int downloadTime) {
        this.downloadTime = downloadTime;
    }
}
