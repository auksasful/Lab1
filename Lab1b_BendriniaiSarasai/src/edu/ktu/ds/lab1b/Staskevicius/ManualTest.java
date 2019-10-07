/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Staskevicius;

import edu.ktu.ds.lab1b.demo.Car;
import edu.ktu.ds.lab1b.util.Ks;
import edu.ktu.ds.lab1b.util.LinkedList;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Tomas
 */
public class ManualTest {
    
    PhoneList phones = new PhoneList();

    void execute() throws CloneNotSupportedException {
        createPhones();
        createPhoneList();
//        countRenault();
        appendPhoneList();
//        checkCarMarketFilters();
//        checkCarMarketSorting();
    }

    void createPhones() {
        Phone p1 = new Phone("Samsung", "Galaxy S8", 2016, 5.3, 700);
        Phone p2 = new Phone("Iphone", "X", 2018, 6.0, 1799.99);
        Phone p3 = new Phone("Samsung", "Galaxy S10", 2017, 7.0, 1499.99);
        Phone p4 = new Phone();
        Phone p5 = new Phone();
        Phone p6 = new Phone();
        p4.parse("Redmi Node5 2017 5,8 181,11");
        p5.parse("Nokia 3310 2001 1,5  50,0");
        p6.parse("LG L70 2015 4,5 80,31");

        Ks.oun(p1);
        Ks.oun(p2);
        Ks.oun(p3);
        Ks.oun("Pirmų 3 telefonų ekrano dydžio vidurkis = "
                + (p1.getScreenSize() + p2.getScreenSize() + p3.getScreenSize()) / 3);
        Ks.oun(p4);
        Ks.oun(p5);
        Ks.oun(p6);
        Ks.oun("Kitų 3 telefonų kainų suma= "
                + (p4.getPrice() + p5.getPrice() + p6.getPrice()));
    }

    void createPhoneList() throws CloneNotSupportedException {
        Phone p1 = new Phone("Samsung", "Galaxy S8", 2016, 5.3, 700);
        Phone p2 = new Phone("Iphone", "X", 2018, 6.0, 1799.99);
        Phone p3 = new Phone("Samsung", "Galaxy S10", 2017, 7.0, 1499.99);
       phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        //phones.println("Pirmi 3 telefonai");
        phones.add("Redmi Node5 2017 5,8 181,11");
        phones.add("Nokia 3310 2001 1,5  50,0");
        phones.add("LG L70 2015 4,5 80,31");
/*
        phones.println("Visi 6 telefonai");
        phones.forEach(System.out::println);
        Ks.oun("Pirmų 3 telefonų ekranų dydžių vidurkis= "
                + (phones.get(0).getScreenSize() + phones.get(1).getScreenSize()
                + phones.get(3).getScreenSize()) / 3);

        Ks.oun("Kitų 3 telefonų kainų suma= "
                + (phones.get(3).getPrice() + phones.get(4).getPrice()
                + phones.get(5).getPrice()));
        
        
        
        
        Ks.oun("Kitų 3 telefonų kainų suma= "
                + (phones.get(3).getPrice() + phones.get(4).getPrice()
                + phones.get(5).getPrice()));
        
        
        */
        

        

        phones.println("Pradiniai duomenys");
        phones.forEach(System.out::println);
        
       // LinkedList<int> d = new LinkedList<>();
        PhoneList phones2 = new PhoneList();
        Phone p7 = new Phone("Vodafone", "X", 2010, 3.2, 320);
        Phone p8 = new Phone("Siemens", "M55", 2004, 1.5, 300);
        phones2.add(p7);
        phones2.add(p8);
        
        
        
        phones.addAll(2, phones2);   
        phones.println("Iterpti duomenys");
        phones.forEach(System.out::println);
        
        
        
        PhoneList phones3 = new PhoneList();
        phones3.addAll(0, phones2);  
        phones3.println("Iterpti duomenys i tuscia");
        phones3.forEach(System.out::println);
        
        
        
       
        
        
        
        
        ///////////////////----Privalomi metodai--------------------------------------------
        /*Phone addP = new Phone("Samsung", "Corby", 2010, 3.5, 200);
        phones.add(4, addP);
        phones.println("Visi telefonai su pridėtu 4 indekse");
        phones.forEach(System.out::println);*/
        
        
        
       /* phones.remove(4);
        phones.println("Visi telefonai su panaikintu 4 indekse");
        phones.forEach(System.out::println);*/
        
        /*Phone setP = new Phone("LG", "L90", 2017, 5.5, 320);
        phones.set(2, setP);
        phones.println("Visi telefonai su pakeistu 2 indekse");
        phones.forEach(System.out::println);*/
        
        /*Phone addL = new Phone("Iphone", "5", 2015, 4.8, 450);
        phones.addLast(addL);
        phones.println("Visi telefonai su pridetu gale");
        phones.forEach(System.out::println);*/
        
        
       /* phones.add(1, p3);
        phones.add(3, p3);
        phones.add(5, p3);
        phones.println("Visi telefonai su pridėtais trim vienodais prieš pašalinimą");
        phones.forEach(System.out::println);
        
        
        phones.removeLastOccurrence(p3);
        phones.println("Visi telefonai su pašalintu paskutiniu konkrečiu objektu");
        phones.forEach(System.out::println);*/
        
        /*List<Phone> subL = */
        phones.subList(2,5);
        phones.println("Visų telefonų subList nuo 2 iki 5 indekso");
        //LinkedList subPhones =  (LinkedList) phones.subList(2, 4);
        phones.forEach(System.out::println);

        ///////////////////----Privalomi metodai--------------------------------------------
        
        
        
        
        
        
        
        
        
        
        // palaipsniui atidenkite sekančias eilutes ir išbandykite
//        cars.add(0, new Car("Mazda","6",2007,50000,27000));
//        cars.add(6, new Car("Hyundai","Lantra",1998,9500,777));
//        cars.set(4, c3);
//        cars.println("Po įterpimų");
//        cars.remove(7);
//        cars.remove(0);
//        cars.println("Po išmetimų");
//        cars.remove(0); cars.remove(0); cars.remove(0);
//        cars.remove(0); cars.remove(0); cars.remove(0);
//        cars.println("Po visų išmetimų");
//        cars.remove(0);
//        cars.println("Po visų išmetimų");
    }

    void countSamsung() {
        int sk = 0;
        for (Phone p : phones) {
            if (p.getBrand().compareTo("Samsung") == 0) {
                sk++;
            }
        }
        Ks.oun("Samsung telefonų yra = " + sk);
    }

    void appendPhoneList() {
        for (int i = 0; i < 8; i++) {
            phones.add(new Phone("Samsung", "Galaxy J" + (i + 1),
                    2011 + i, 6.0 - i / 10, 130 + i * 20)); 
        }
        phones.add("Honor 8X  2019 6,3 269,0");
        phones.add("Nokia 2.2 2018 5,0 98,0");
        phones.add("Xiaomi Redmi 7A 2017 5,3 112,30");
        phones.add("Motorola Moto Z 2018 4,9 299,99");
        phones.println("Testuojamų telefonų sąrašas");
        phones.save("telSarasas.txt");
    }
    
    void checkCarMarketFilters() {
        PhoneShop shop = new PhoneShop();

        shop.allPhones.load("ban.txt");
        shop.allPhones.println("Bandomasis rinkinys");

        phones = shop.getNewerPhones(2018);
        phones.println("Pradedant nuo 2018");

        phones = shop.getByPrice(100, 400);
        phones.println("Kaina tarp 100 ir 400");

        phones = shop.getHighestScreenSizePhones();
        phones.println("Didžiausiais Ekranais");

        phones = shop.getByBrandAndModel("I");
        phones.println("Turi būti tik Iphone");

        phones = shop.getByBrandAndModel("Samsung G");

        phones.println("Turi būti tik Samsung Galaxy");
        int n = 0;
        for (Phone p : phones) {
            n++;    // testuojame ciklo veikimą
        }
        Ks.oun("Samsung galaxy kiekis = " + n);
    }

    // išbandykite veikimą, o po to pakeiskite į Lambda stiliaus komparatorius.
    void checkCarMarketSorting() {
       PhoneShop shop = new PhoneShop();

        shop.allPhones.load("ban.txt");
        Ks.oun("========" + shop.allPhones.get(0));
        shop.allPhones.println("Bandomasis rinkinys");
        shop.allPhones.sortBuble(Phone.byBrandAndModel);
        shop.allPhones.println("Rūšiavimas pagal Gamintoją ir Modelį");
        shop.allPhones.sortBuble(Car.byPrice);
        shop.allPhones.println("Rūšiavimas pagal kainą");
        shop.allPhones.sortBuble(Car.byYearAndPrice);
        shop.allPhones.println("Rūšiavimas pagal Metus ir Kainą");
        shop.allPhones.sortBuble(byMileage);
        shop.allPhones.sortBuble((a, b) -> Double.compare(a.getScreenSize(), b.getScreenSize()));
        shop.allPhones.println("Rūšiavimas pagal Ekrano dydį");
        shop.allPhones.sortBuble();
        shop.allPhones.println("Rūšiavimas pagal compareTo - Kainą");
    }

    static Comparator byMileage = new Comparator() {
        @Override
        public int compare(Object obj1, Object obj2) {
            int m1 = ((Car) obj1).getMileage();
            int m2 = ((Car) obj2).getMileage();
            // rida atvirkščia mažėjančia tvarka, pradedant nuo didžiausios
            if (m1 < m2) {
                return 1;
            }
            if (m1 > m2) {
                return -1;
            }
            return 0;
        }
    };

    public static void main(String... args) throws CloneNotSupportedException {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        new edu.ktu.ds.lab1b.Staskevicius.ManualTest().execute();
    }
    
    
    
    
    
    
    
    
    
}
