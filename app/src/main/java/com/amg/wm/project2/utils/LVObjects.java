package com.amg.wm.project2.utils;

public class LVObjects {
    private String lvtitle;
    private int drawableImageID;

    public LVObjects(String lvtitle, int drawableImageID) {
        this.lvtitle = lvtitle;
        this.drawableImageID = drawableImageID;
    }

    public String getTitle() {
        return lvtitle;
    }

    public void setTitle(String lvtitle) {
        this.lvtitle = lvtitle;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }
}