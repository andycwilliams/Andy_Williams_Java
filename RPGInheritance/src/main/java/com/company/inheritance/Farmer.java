package com.company.inheritance;

import java.util.Objects;

public class Farmer extends BaseClass{

    protected boolean plowing;
    protected boolean harvesting;

    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Farmer farmer = (Farmer) o;
        return plowing == farmer.plowing && harvesting == farmer.harvesting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plowing, harvesting);
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "plowing=" + plowing +
                ", harvesting=" + harvesting +
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
