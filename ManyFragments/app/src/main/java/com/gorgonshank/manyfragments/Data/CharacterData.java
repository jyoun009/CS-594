package com.gorgonshank.manyfragments.Data;


public class CharacterData {

    public static long myHitPoints = 1000;

    public static long myMaxHitPoints = 1000;

    public static long attack = 200;

    public static long defense = 50;

    public static long experience = 0;

    public static long getAttack() {
        return attack;
    }

    public static void setAttack(long attack) {
        CharacterData.attack = attack;
    }

    public static long getDefense() {
        return defense;
    }

    public static void setDefense(long defense) {
        CharacterData.defense = defense;
    }

    public static long getExperience() {
        return experience;
    }

    public static void setExperience(long experience) {
        CharacterData.experience = experience;
    }

    public static long getMyHitPoints() {
        return myHitPoints;
    }

    public static void setMyHitPoints(long myHitPoints) {
        CharacterData.myHitPoints = myHitPoints;
    }


    public static long getMyMaxHitPoints() {
        return myMaxHitPoints;
    }

    public static void setMyMaxHitPoints(long myMaxHitPoints) {
        CharacterData.myMaxHitPoints = myMaxHitPoints;
    }






}
