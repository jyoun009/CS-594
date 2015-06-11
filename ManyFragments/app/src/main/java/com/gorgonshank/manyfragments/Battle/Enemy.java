package com.gorgonshank.manyfragments.Battle;

public class Enemy {
    private long hp;
    private long attack;
    private long defence;
    private long experience;
    private long loot;
    private long maxHP;

    public Enemy() {
        long minimum = 50;
        long maximum = 100;

        this.hp = 1000;
        this.maxHP = this.hp;
        this.attack = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
        this.defence = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
        this.experience = this.hp;

        minimum = 0;
        maximum = 51;

        this.loot = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
    }

    public Enemy(int modifier) {
        long minimum = 50 * modifier;
        long maximum = 100 * modifier;

        this.hp = 1000 * modifier;
        this.maxHP = this.hp;
        this.attack = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
        this.defence = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
        this.experience = this.hp;

        minimum = 0;
        maximum = 51;

        this.loot = minimum + (int)(Math.random() * ((maximum - minimum) + 1));
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefence() {
        return defence;
    }

    public void setDefence(long defence) {
        this.defence = defence;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public long getLoot() {
        return loot;
    }

    public void setLoot(long loot) {
        this.loot = loot;
    }

    public long getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(long maxHP) {
        this.maxHP = maxHP;
    }
}
