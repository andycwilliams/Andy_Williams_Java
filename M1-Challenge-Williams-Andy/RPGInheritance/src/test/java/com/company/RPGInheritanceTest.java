package com.company;

import com.company.inheritance.Constable;
import com.company.inheritance.Farmer;
import com.company.inheritance.Warrior;

public class RPGInheritanceTest {
    public static void main(String[] args) {
        Constable newConstable = new Constable();
        Farmer newFarmer = new Farmer();
        Warrior newWarrior = new Warrior();

        newConstable.setName("Constable Guy");
        newConstable.setStrength(60);
        newConstable.setStamina(60);
        newConstable.setSpeed(20);
        newConstable.setAttackPower(5);
        newConstable.setAbilities(newConstable.getAbilities() + "Arrest another character.");

        newFarmer.setName("Farmer Lady");
        newFarmer.setStrength(75);
        newFarmer.setStamina(75);
        newFarmer.setSpeed(10);
        newFarmer.setAttackPower(1);

        newWarrior.setName("Warrior Person");
        newWarrior.setStrength(75);
        newWarrior.setStamina(100);
        newWarrior.setSpeed(50);
        newWarrior.setAttackPower(10);
        newWarrior.setShieldStrength(100);

        System.out.println(newConstable);
        System.out.println(newFarmer);
        System.out.println(newWarrior);
    }
}