package com.gorgonshank.manyfragments.Sprite;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Armor extends Sprite {

    public int defense;

    public Armor(Resources resources, Drawable temp, String name, int width, int height) {
        super(resources, temp, name, width, height);
    }

    public int getDefense(){
        return defense;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public String toString(){
        String superToString = super.toString();
        return superToString + "\nDefense is: " + defense;
    }
}
