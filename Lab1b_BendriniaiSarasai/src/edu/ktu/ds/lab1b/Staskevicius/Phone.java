/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Staskevicius;

import edu.ktu.ds.lab1b.util.Ks;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import edu.ktu.ds.lab1b.util.Parsable;

/**
 *
 * @author Tomas
 */
public class Phone implements Parsable<Phone>{
    
    
    // bendri duomenys visiems telefonams (visai klasei)
    final static private int minYear = 2016;

    final static private double minPrice = 50.0;
    final static private double maxPrice = 2000;
    
    
    // kiekvieno telefono individualūs duomenys
    private String brand;
    private String model;
    private int year;
    private double screenSize;
    private double price;
    
    public Phone(){
    
    }
    
    public Phone(String brand, String model,
            int year, double screenSize, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.screenSize = screenSize;
        this.price = price;
    }
    
    
    public Phone(String data) {
        parse(data);
    }
    
    @Override
    public final void parse(String data) {
        try {   // ed - tai elementarūs duomenys, atskirti tarpais
            Scanner ed = new Scanner(data);
            brand = ed.next();
            model = ed.next();
            year = ed.nextInt();
            screenSize = ed.nextInt();
            setPrice(ed.nextDouble());
        } catch (InputMismatchException e) {
            Ks.ern("Blogas duomenų formatas apie telefoną -> " + data);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie telefoną -> " + data);
        }
    }
   
     // keisti bus galima tik kainą - kiti parametrai pastovūs
    public void setPrice(double price) {
        this.price = price;
    }
    
   public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getScreenSize() {
        return this.screenSize;
    }

    public double getPrice() {
        return price;
    }
    
    
    
    
    @Override
    public int compareTo(Phone p) {
        
        double otherPrice = p.getPrice();
        if (price < otherPrice) {
            return -1;
        }
        if (price > otherPrice) {
            return +1;
        }
        return 0;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public final static Comparator<Phone> byBrandAndModel
            = (Phone phone1, Phone phone2) -> {
                // pradžioje pagal markes, o po to pagal modelius
                int cmp = phone1.getBrand().compareTo(phone2.getBrand());
                if (cmp != 0) {
                    return cmp;
                }
                return phone1.getModel().compareTo(phone2.getModel());
    };
    
    public final static Comparator byPrice = (Comparator) (Object obj1, Object obj2) -> {
        double price1 = ((Phone) obj1).getPrice();
        double price2 = ((Phone) obj2).getPrice();
        // didėjanti tvarka, pradedant nuo mažiausios
        if (price1 < price2) {
            return -1;
        }
        if (price1 > price2) {
            return 1;
        }
        return 0;
    }; // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
    
    
    public final static Comparator byYearAndPrice = (Comparator) (Object obj1, Object obj2) -> {
        Phone c1 = (Phone) obj1;
        Phone c2 = (Phone) obj2;
        // metai mažėjančia tvarka, esant vienodiems lyginama price
        if (c1.getYear() < c2.getYear()) {
            return 1;
        }
        if (c1.getYear() > c2.getYear()) {
            return -1;
        }
        if (c1.getPrice() < c2.getPrice()) {
            return 1;
        }
        if (c1.getPrice() > c2.getPrice()) {
            return -1;
        }
        return 0;
    } // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
    ;

    // metodas main = tiesiog paprastas pirminis telefonų išbandymas
    public static void main(String... args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        Phone a1 = new Phone("Iphone", "X", 2018, 6.0, 1799.99);
        Phone a2 = new Phone("Samsung", "Galaxy S10", 2017, 7.0, 1499.99);
        Phone a3 = new Phone();
        Phone a4 = new Phone();
        Phone a5 = new Phone("LG", "L70", 2015, 4.5, 80.31);
        a3.parse("Redmi Node5 2017 5.8 181.11");
        a4.parse("Nokia 3310 2001 1.5  50.0");
        Ks.oun(a1);
        Ks.oun(a2);
        Ks.oun(a3);
        Ks.oun(a4);
        Ks.oun(a5);
    }

    
}
