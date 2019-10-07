/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ktu.ds.lab1b.Staskevicius;

/**
 *
 * @author Tomas
 */
public class PhoneShop {
    
    public PhoneList allPhones = new PhoneList();

    // suformuojamas sąrašas automobilių, kurie pagaminti vėliau nei riba
    public PhoneList getNewerPhones(int fromYear) {
        PhoneList cars = new PhoneList();
        for (Phone p : allPhones) {
            if (p.getYear() >= fromYear) {
                cars.add(p);
            }
        }
        return cars;
    }

    // suformuojamas sąrašas automobilių, kurių kaina yra tarp ribų
    public PhoneList getByPrice(int fromPrice, int toPrice) {
        PhoneList phones = new PhoneList();
        for (Phone p : allPhones) {
            if (p.getPrice() >= fromPrice && p.getPrice() <= toPrice) {
                phones.add(p);
            }
        }
        return phones;
    }

    // suformuojamas sąrašas automobilių, turinčių didžiausią ridą
    public PhoneList getHighestScreenSizePhones() {
        PhoneList phones = new PhoneList();
        // formuojamas sąrašas su maksimalia reikšme vienos peržiūros metu
        double maxScreenSize = 0;
        for (Phone p : allPhones) {
            double screenSize = p.getScreenSize();
            if (screenSize >= maxScreenSize) {
                if (screenSize > maxScreenSize) {
                    phones.clear();
                    maxScreenSize = screenSize;
                }
                phones.add(p);
            }
        }
        return phones;
    }

    // suformuojams sąrašas automobilių, kurių modelio kodas atitinka nurodytą
    public PhoneList getByBrandAndModel(String brandAndModel) {
        PhoneList phones = new PhoneList();
        for (Phone p : allPhones) {
            String carMakeAndModel = p.getBrand() + " " + p.getModel();
            if (carMakeAndModel.startsWith(brandAndModel)) {
                phones.add(p);
            }
        }
        return phones;
    }
    // metodo main nėra -> demo bandymai klasėje AutomobiliuBandymai
    
    
    
}
