package com.gorgonshank.manyfragments.Sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class Sprite {
    Drawable sprite;
    Bitmap bitmap;
    String name;
    String prefix;
    String suffix;

    public Sprite(Resources resources, Drawable temp, String name, int width, int height){
        this.bitmap = ((BitmapDrawable) temp).getBitmap();
        this.name = name;
        sprite = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, width, height, true));
    }

    public int getWidth(){
        return bitmap.getWidth();
    }

    public int getHeight(){
        return bitmap.getHeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Drawable getDrawable(){
        return sprite;
    }

    public void setWidth(Resources resources, int newWidth){
        sprite = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, newWidth, getHeight(), true));
        bitmap = ((BitmapDrawable) sprite).getBitmap();
    }

    public void setHeight(Resources resources, int newHeight){
        sprite = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, getWidth(), newHeight, true));
        bitmap = ((BitmapDrawable) sprite).getBitmap();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String toString(){
        return "Sprite name: " + prefix + " " + name + " " + suffix;
    }

}
