package com.company.inheritance;

import java.util.Objects;

public class BaseClass {

    protected String name;
    protected int health;
    protected int strength;
    protected int stamina;
    protected int attackPower;
    protected int speed;
    protected boolean running;
    protected boolean arrested;
    protected String abilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseClass baseClass = (BaseClass) o;
        return health == baseClass.health && strength == baseClass.strength && stamina == baseClass.stamina && attackPower == baseClass.attackPower && speed == baseClass.speed && running == baseClass.running && arrested == baseClass.arrested && Objects.equals(name, baseClass.name) && Objects.equals(abilities, baseClass.abilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, strength, stamina, attackPower, speed, running, arrested, abilities);
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", stamina=" + stamina +
                ", attackPower=" + attackPower +
                ", speed=" + speed +
                ", running=" + running +
                ", arrested=" + arrested +
                ", abilities='" + abilities + '\'' +
                '}';
    }
}

