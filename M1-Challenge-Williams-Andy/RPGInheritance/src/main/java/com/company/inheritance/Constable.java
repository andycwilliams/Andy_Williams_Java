package com.company.inheritance;

import java.util.Objects;

public class Constable extends BaseClass{

    private boolean jurisdiction;

    public boolean isJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(boolean jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Constable constable = (Constable) o;
        return jurisdiction == constable.jurisdiction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jurisdiction);
    }

    @Override
    public String toString() {
        return "Constable{" +
                "jurisdiction=" + jurisdiction +
                ", name='" + name + '\'' +
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
