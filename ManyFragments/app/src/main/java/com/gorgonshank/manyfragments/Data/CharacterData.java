package com.gorgonshank.manyfragments.Data;


public class CharacterData {

    public static long hit_points = 1000;

    public static long max_hit_points = 1000;

    public static long attack = 200;

    public static long defense = 50;

    public static long experience = 0;

    public static long skill_points = 10;

    public static long max_skill_points = 20;

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

    public static long getHit_points() {
        return hit_points;
    }

    public static void setHit_points(long hit_points) {
        CharacterData.hit_points = hit_points;
    }

    public static long getMax_hit_points() {
        return max_hit_points;
    }

    public static void setMax_hit_points(long max_hit_points) {
        CharacterData.max_hit_points = max_hit_points;
    }

    public static long getSkill_points() {
        return skill_points;
    }

    public static void setSkill_points(long skill_points) {
        CharacterData.skill_points = skill_points;
    }


    public static long getMax_skill_points() {
        return max_skill_points;
    }

    public static void setMax_skill_points(long max_skill_points) {
        CharacterData.max_skill_points = max_skill_points;
    }








}
