/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Staskevicius;

import edu.ktu.ds.lab1b.util.Ks;
import edu.ktu.ds.lab1b.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Tomas
 */
public class SimpleBenchmark {
     Phone[] phones;
    LinkedList<Phone> phoneSeries = new LinkedList<>();
    ArrayList<Integer> testList = new ArrayList<Integer>();
    Phone objToCheck = new Phone();
    Random rg = new Random();  // atsitiktinių generatorius
    int[] counts = {1_000_000, 2_000_000, 
        4_000_000 , 6_000_000, 8_000_000};
//    pabandykite, gal Jūsų kompiuteris įveiks šiuos eksperimentus
//    paieškokite ekstremalaus apkrovimo be burbuliuko metodo
//    static int[] counts = {10_000, 20_000, 40_000, 80_000};

    void generatePhones(int count) {
        String[][] brandsAndModels = { // galimų telefonų ir jų modelių masyvas
            {"Samsung", "Galaxy S8", "Galaxy J3", "Galaxy J1"},
            {"Iphone", "X", "10", "11", "8", "8 16 GB"},
            {"Xiaomi", "Redmi Go", "Redmi Note 7", "Mi 9T"},
            {"CAT", "S41", "B25", "B30", "S31"},
            {"Huawei", "P30", "P20", "Y5"},
            {"Sony", "Xperia 2", "Xperia 10"}
        };
        phones = new Phone[count];
        rg.setSeed(2017);
        for (int i = 0; i < count; i++) {
            int brandIndex = rg.nextInt(brandsAndModels.length);        // markės indeksas  0..
            int modelIndex = rg.nextInt(brandsAndModels[brandIndex].length - 1) + 1;// modelio indeksas 1..
           phones[i] = new Phone(brandsAndModels[brandIndex][0], brandsAndModels[brandIndex][modelIndex],
                        2010 + rg.nextInt(9), // metai tarp 2010 ir 2019
                        4.0 + rg.nextDouble(), // ekrano dydis
                        50 + rg.nextDouble() * 2_000); // kaina tarp 50 ir 2050
        }
        Collections.shuffle(Arrays.asList(phones));
        phoneSeries.clear();
        for (Phone p : phones) {
            phoneSeries.add(p);
        }
    }
    
    
    
     void generateTestArrayList(int count){
         testList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(i != 0 && i % 12569 == 0){
                testList.add(3);
            }
            else{
                int gen = 3;
                while(gen == 3)
                    gen = rg.nextInt(9999);
                
                testList.add(gen);
            }
        }
     }

    void generateAndExecute(int elementCount) {
// Paruošiamoji tyrimo dalis
        long t0 = System.nanoTime();
        generatePhones(elementCount);
        LinkedList<Phone> phoneSeries2 = phoneSeries.clone();
        LinkedList<Phone> phoneSeries3 = phoneSeries.clone();
        LinkedList<Phone> phoneSeries4 = phoneSeries.clone();
        long t1 = System.nanoTime();
        System.gc();
        System.gc();
        System.gc();
        long t2 = System.nanoTime();
//  Greitaveikos bandymai ir laiko matavimai
        phoneSeries.sortSystem();
        long t3 = System.nanoTime();
        phoneSeries2.sortSystem(Phone.byPrice);
        long t4 = System.nanoTime();
        phoneSeries3.sortBuble();
        long t5 = System.nanoTime();
        phoneSeries4.sortBuble(Phone.byPrice);
        long t6 = System.nanoTime();
        Ks.ouf("%7d %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f \n", elementCount,
                (t1 - t0) / 1e9, (t2 - t1) / 1e9, (t3 - t2) / 1e9,
                (t4 - t3) / 1e9, (t5 - t4) / 1e9, (t6 - t5) / 1e9);
    }

    //greitaveikos tyrimas 1
    void sqrtVScbrt(double x){
         long t0 = System.nanoTime();
         double sqrtRez = Math.sqrt(x);
         long t1 = System.nanoTime();
         double cbrtRez = Math.cbrt(x);
         long t2 = System.nanoTime();
         Ks.ouf("%-15s %-15s \n", "Metodas",
                 "Užtrukta laiko");
         Ks.ouf(" %-15s %7.4f \n %-15s %7.4f \n", "sqrt(x) ",
                 (t1 - t0) / 1e9, "cbrt(x) ", (t2 - t1) / 1e9);
    }
    
    
   
    
    
     //greitaveikos tyrimas 2
    void arrayListIndexOfVSlastIndexOf(int elementCount){

        generateTestArrayList(elementCount);
        long t0 = System.nanoTime();
  
        int id1 = testList.indexOf(3);
        long t1 = System.nanoTime();
        
        int id2 = testList.lastIndexOf(3);
        long t2 = System.nanoTime();
        Ks.ouf("%-10s %-30s %-30s %-20s %-20s %-20s\n", "Kiekis",
                "ArrayList.indexOf(Object o);", "ArrayList.lastIndexOf(Object o);",
                "indexOf rezultatas;",
                "lastIndexOf rezultatas;", "Kiekis - lastIndexOf");
        Ks.ouf("%7d %30.5f %30.5f %20d %20d %20d \n", elementCount,
                (t1 - t0) / 1e9, (t2 - t1) / 1e9, id1, id2, elementCount - id2);
    }
    
    
    void execute() {
        long memTotal = Runtime.getRuntime().totalMemory();
        Ks.oun("memTotal= " + memTotal);
        // Pasižiūrime kaip generuoja automobilius (20) vienetų)
        generatePhones(20);
        for (Phone p : phoneSeries) {
            Ks.oun(p);
        }
        Ks.oun("1 - Pasiruošimas tyrimui - duomenų generavimas");
        Ks.oun("2 - Pasiruošimas tyrimui - šiukšlių surinkimas");
        Ks.oun("3 - Rūšiavimas sisteminiu greitu būdu be Comparator");
        Ks.oun("4 - Rūšiavimas sisteminiu greitu būdu su Comparator");
        Ks.oun("5 - Rūšiavimas List burbuliuku be Comparator");
        Ks.oun("6 - Rūšiavimas List burbuliuku su Comparator");
        Ks.ouf("%6d %7d %7d %7d %7d %7d %7d \n", 0, 1, 2, 3, 4, 5, 6);
        //for (int n : counts) {
         //   generateAndExecute(n);
       // }
        
        
        sqrtVScbrt(27);
        
        for (int n : counts) {
            arrayListIndexOfVSlastIndexOf(n);
        }
        
        
    }

    public static void main(String[] args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        new edu.ktu.ds.lab1b.Staskevicius.SimpleBenchmark().execute();
    }
}
