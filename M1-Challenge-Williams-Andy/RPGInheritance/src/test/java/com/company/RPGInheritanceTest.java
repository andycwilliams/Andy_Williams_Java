package com.company;

import com.company.inheritance.Constable;
import com.company.inheritance.Farmer;
import com.company.inheritance.Warrior;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

public class RPGInheritanceTest {

    Constable newConstable;
    Farmer newFarmer;
    Warrior newWarrior;

    private static HashMap<String, String> test1;
    @Before
    public void setUp() {
//        Constable newConstable = new Constable();
        // calc = new Calculator()
        newConstable = new Constable();
        newFarmer = new Farmer();
        newWarrior = new Warrior();

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

//        System.out.println(newConstable);
//        System.out.println(newFarmer);
//        System.out.println(newWarrior);
    }

    @Test
    public void shouldshouldReturnConstableName() throws Exception {
        assertEquals("Constable Guy", newConstable.getName());

    }

    @Test
    public void shouldshouldReturnFarmerHealth() throws Exception {
        assertEquals(100, newFarmer.getHealth());

    }

    @Test
    public void shouldshouldReturnWarriorAttackPower() throws Exception {
        assertEquals(10, newWarrior.getAttackPower());

    }
}

//        assertArrayEquals(new int[] {2,5,8,11}, tester.averageArrays(testArr1));
//        assertArrayEquals(new int[] {8,46}, tester.averageArrays(testArr2));
//        assertArrayEquals(new int[] {1,4,0}, tester.averageArrays(testArr3));

//    @Test
//    public void shouldPrintKeysAndValues() throws Exception {
//        Scanner scan = new Scanner(getOutput("keysAndValues", 1));
//
//        tester.printKeysAndValues(test1);
//        String output = systemOutRule.getLog();
//
//        while(scan.hasNext()) {
//            String failMessage = "Expected to output all keys and values";
//            assertTrue(failMessage, output.contains(scan.nextLine()));
//        }
//
//        systemOutRule.clearLog();
//
//        scan = new Scanner(getOutput("keysAndValues", 2));
//
//        tester.printKeysAndValues(test2);
//        output = systemOutRule.getLog();
//
//        while(scan.hasNext()) {
//            String failMessage = "Expected to output all keys and values";
//            assertTrue(failMessage, output.contains(scan.nextLine()));
//        }
//
//        systemOutRule.clearLog();
//
//        scan = new Scanner(getOutput("keysAndValues", 3));
//
//        tester.printKeysAndValues(test3);
//        output = systemOutRule.getLog();
//
//        while(scan.hasNext()) {
//            String failMessage = "Expected to output all keys and values";
//            assertTrue(failMessage, output.contains(scan.nextLine()));
//        }
//
//        systemOutRule.clearLog();
//    }