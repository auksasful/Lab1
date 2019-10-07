/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Staskevicius;


import edu.ktu.ds.lab1b.util.ParsableList;
import java.util.Random;

/**
 *
 * @author Tomas
 */
public class PhoneList extends ParsableList<Phone>{
    
    
    public PhoneList(){
    
    }
    
    public PhoneList(int count) {
        super();
        String[][] brandsAndModels = {
            {"Iphone", "11", "X", "8", "9"},
            {"Samsung", "Galaxy J3", "Galaxy S10", "Note 10+", "Galaxy A70", "Mondeo"},
            {"Sony", "Xperia 2", "Xperia 10"},
            {"Xiaomi", "Redmi Go", "Redmi Note 7", "Mi 9T"},
            {"CAT", "S41", "B25", "B30", "S31"},
            {"Huawei", "P30", "P20", "Y5"}
        };
        
        
         Random rnd = new Random();
        rnd.setSeed(2017);
    
        for (int i = 0; i < count; i++) {
            int brandIndex = rnd.nextInt(brandsAndModels.length);
            int modelIndex = rnd.nextInt(brandsAndModels[brandIndex].length - 1) + 1;
            add(new Phone(brandsAndModels[brandIndex][0], brandsAndModels[brandIndex][modelIndex],
                    1994 + rnd.nextInt(20),
                    6000 + rnd.nextInt(222_000),
                    1000 + rnd.nextDouble() * 100_000));
        }
        
        
    }
    
   
       
    
@Override
    protected Phone createElement(String data) {
        return new Phone(data);
        }
    }


    

