/**
 * @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 23
 *
 * Tai pirmoji kompleksinės duomenų struktūros klasė, kuri leidžia apjungti
 * atskirus objektus į vieną visumą - sąrašą. Objektai, kurie bus dedami į
 * sąrašą, turi tenkinti interfeisą Comparable<E>.
 *
 * Užduotis: Peržiūrėkite ir išsiaiškinkite pateiktus metodus. Metodų algoritmai
 * yra aptarti paslaitos metu. Realizuokite nurodytus metodus.
 * ****************************************************************************
 */
package edu.ktu.ds.lab1b.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Koreguota 2015-09-18
 *
 * @author Aleksis
 * @param <E> Sąrašo elementų tipas (klasė)
 */
public class LinkedList<E extends Comparable<E>>
        implements List<E>, Iterable<E>, Cloneable {

    private Node<E> first;   // rodyklė į pirmą mazgą
    private Node<E> last;    // rodyklė į paskutinį mazgą
    private Node<E> current; // rodyklė į einamąjį mazgą, naudojama getNext
    private int size;        // sąrašo dydis, tuo pačiu elementų skaičius

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
    }

    /**
     * metodas add įdeda elementą į sąrašo pabaigą
     *
     * @param e - tai įdedamas elementas (jis negali būti null)
     * @return true, jei operacija atlikta sėkmingai
     */
    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;   // nuliniai objektai nepriimami
        }
        if (first == null) {
            first = new Node<>(e, first);
            last = first;
        } else {
            Node<E> e1 = new Node(e, null);
            last.next = e1;
            last = e1;
        }
        size++;
        return true;
    }
    

   public void addLast(E e){
        if (e == null) {
            throw new NullPointerException();
        }
        if (first == null) {
            first = new Node<>(e, first);
            last = first;
        } else {
            Node<E> e1 = new Node(e, null);
            last.next = e1;
            last = e1;
        }
        size++;
   
   }
   
   
   public boolean removeLastOccurrence(Object o){
       Node lastOccurence = null;
       for (Node curr = first;
      			curr != null; 
      			curr = curr.next) {
           if(curr.element == o){
                lastOccurence = curr;
           }
    }
       
       if(lastOccurence != null){  
           //delete last
           Node temp = lastOccurence.next;
            // jei del yra pirmas – keičiame first
            if (lastOccurence == first) first = temp; 
            else { // reikia rasti ankstesnį pred
                Node pred = first;
                while (pred.next != lastOccurence) 
                    pred = pred.next;
                    pred.next = temp;  // pašalinimas !!!
                }
           size--;
           return true;
       }
       else{
           return false;
       }
       
   }
   
   
   public List<E> subList(int fromIndex, int toIndex) throws CloneNotSupportedException{
       if(fromIndex < 0 || toIndex > size || toIndex <= fromIndex){
           return null;
       }
       
    LinkedList<E> n = (LinkedList<E>) super.clone();
    
    Node<E> startNode = n.first;
    int counter=0;
    int removedCounter = 0;
    while(startNode!=null){
        
         if(counter<fromIndex || counter>toIndex - 1){
               remove(counter - removedCounter);
               removedCounter++;
         }
         startNode=startNode.next;
         counter++;
    }
    return n;
   }
   
   
 
    /**
     * Įterpia elementą prieš k-ąją poziciją
     *
     * @param k pozicija
     * @param e įterpiamasis elementas
     * @return jei k yra blogas, grąžina null
     */
    @Override
    public boolean add(int k, E e) {
        if (e == null) {
            return false;
        }
        if (k < 0 || k >= size) {
            return false;
        }
        addM(k, e);
        return true;        
    }
    
    /**
     *
     * @param k
     * @param e
     * Metodas add, kuri reikia prideti
     */
    private void addM(int k, E e) {
          Node<E> newNode = new Node(e, null);
 
        // insert as the new head?
        if (k == 0) {
            // The 1st case.
            newNode.next = first;
            first = newNode;
        } else {
            // The 2nd case.
            // start from the head:
            Node<E> node = first;
            // find position just before the expected one:
            while (--k > 0) {
                node = node.next;
            }
            // insert the new node:
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
      
    }
    
    
      

    /**
     *
     * @return sąrašo dydis (elementų kiekis)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * patikrina ar sąrašas yra tuščias
     *
     * @return true, jei tuščias
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Išvalo sąrašą
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
        current = null;
    }

    /**
     * Grąžina elementą pagal jo indeksą (pradinis indeksas 0)
     *
     * @param k indeksas
     * @return k-ojo elemento reikšmę; jei k yra blogas, gąžina null
     */
    @Override
    public E get(int k) {
        if (k < 0 || k >= size) {
            return null;
        }
        current = first.findNode(k);
        return current.element;
    }

    /**
     * Pakeičia k-ojo elemento reikšmę
     *
     * @param k keičiamo elemento indeksas
     * @param e nauja elemento reikšmė
     * @return senoji reikšmė
     */
    @Override
    public E set(int k, E e) {
        
        //Node<E> temp = null;
        int counter = 0;
       for (Node curr = first;
      			curr != null; 
      			curr = curr.next) {
           if(counter == k){
               curr.element = e;
           }
            counter++;
        }
        //current.next = (Node<E>) e;
        
        return e;
        //throw new UnsupportedOperationException("Studentams reikia realizuoti set(int k, E e)");
    }

    /**
     * pereina prie kitos reikšmės ir ją grąžina
     *
     * @return kita reikšmė
     */
    @Override
    public E getNext() {
        if (current == null) {
            return null;
        }
        current = current.next;
        if (current == null) {
            return null;
        }
        return current.element;
    }

    /**
     * Šalina elementą pagal indeksą
     *
     * @param k šalinamojo indeksas
     * @return pašalintas elementas
     */
    @Override
    public E remove(int k) {
         current = first;
         Node parent = null;
         int index = 0;
    
        while (current != null && index < k) {
            parent = current;
            current = current.next;

            index++;
        }

        if (current != null && parent == null) {
            // Delete head.
            if (current.next != null) {
                // Move head to next value.
                first = current.next;
            }
            else {
                // Just set the head to null.
                first = null;
            }
        }
        else if (current != null) {
            // Delete current, link parent to child..
            if(parent.next != null)
            parent.next = current.next;
        }
        size--;
        return first.element;
    }
    
    
  
    public boolean addAll(int index, LinkedList<?extends E> c){
        
        if(c.size == 0 || index > size || c == null)
            return false;
        
        boolean last;
        if(index != size - 1){
            last = false;
        }
        else{
            last = true;
        }
        
        if(size > 0){
       int counter = 0;
            for (Node curr = first;
                             curr != null; 
                             curr = curr.next) {
                if(counter == index){
                     for (Node curr1 = c.first;
                             curr1 != null; 
                             curr1 = curr1.next) {
                         if(!last){
                            add(counter, (E) curr1.element);
                            counter++;
                         }
                         else{
                          addLast((E) curr1.element);
                         }
                     }
                     break;
                }
                 counter++;
             }
        }
        else{
            for (Node curr1 = c.first;
                             curr1 != null; 
                             curr1 = curr1.next) {
                         addLast((E) curr1.element);
                     }
        }
        
        return true;
    }
    
    
    
    
    /**
     *
     * @return sąrašo kopiją
     */
    @Override
    public LinkedList<E> clone() {
        LinkedList<E> cl = null;
        try {
            cl = (LinkedList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            Ks.ern("Blogai veikia ListKTU klasės protėvio metodas clone()");
            System.exit(1);
        }
        if (first == null) {
            return cl;
        }
        cl.first = new Node<>(this.first.element, null);
        Node<E> e2 = cl.first;
        for (Node<E> e1 = first.next; e1 != null; e1 = e1.next) {
            e2.next = new Node<>(e2.element, null);
            e2 = e2.next;
            e2.element = e1.element;
        }
        cl.last = e2.next;
        cl.size = this.size;
        return cl;
    }
    //  !

    /**
     * Formuojamas Object masyvas (E tipo masyvo negalima sukurti) ir surašomi
     * sąrašo elementai
     *
     * @return sąrašo elementų masyvas
     */
    public Object[] toArray() {
        Object[] a = new Object[size];
        int i = 0;
        for (Node<E> e1 = first; e1 != null; e1 = e1.next) {
            a[i++] = e1.element;
        }
        return a;
    }

    /**
     * Masyvo rikiavimas Arrays klasės metodu sort
     */
    public void sortSystem() {
        Object[] a = this.toArray();
        Arrays.sort(a);
        int i = 0;
        for (Node<E> e1 = first; e1 != null; e1 = e1.next) {
            e1.element = (E) a[i++];
        }
    }
    
    
  

    /**
     * Rikiavimas Arrays klasės metodu sort pagal komparatorių
     *
     * @param c komparatorius
     */
    public void sortSystem(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        int i = 0;
        for (Node<E> e1 = first; e1 != null; e1 = e1.next) {
            e1.element = (E) a[i++];
        }
    }

    /**
     * Sąrašo rikiavimas burbuliuko metodu
     */
    public void sortBuble() {
        if (first == null) {
            return;
        }
        for (;;) {
            boolean jauGerai = true;
            Node<E> e1 = first;
            for (Node<E> e2 = first.next; e2 != null; e2 = e2.next) {
                if (e1.element.compareTo(e2.element) > 0) {
                    E t = e1.element;
                    e1.element = e2.element;
                    e2.element = t;
                    jauGerai = false;
                }
                e1 = e2;
            }
            if (jauGerai) {
                return;
            }
        }
    }

    /**
     * Sąrašo rikiavimas burbuliuko metodu pagal komparatorių
     *
     * @param c komparatorius
     */
    public void sortBuble(Comparator<? super E> c) {
        if (first == null) {
            return;
        }
        for (;;) {
            boolean jauGerai = true;
            Node<E> e1 = first;
            for (Node<E> e2 = first.next; e2 != null; e2 = e2.next) {
                if (c.compare(e1.element, e2.element) > 0) {
                    E t = e1.element;
                    e1.element = e2.element;
                    e2.element = t;
                    jauGerai = false;
                }
                e1 = e2;
            }
            if (jauGerai) {
                return;
            }
        }
    }

    /**
     * Sukuria iteratoriaus objektą sąrašo elementų peržiūrai
     *
     * @return iteratoriaus objektą
     */
    @Override
    public java.util.Iterator<E> iterator() {
        return new Iterator();
    }

    /**
     * Iteratoriaus metodų klasė
     */
    class Iterator implements java.util.Iterator<E> {

        private Node<E> iterPosition;

        Iterator() {
            iterPosition = first;
        }

        @Override
        public boolean hasNext() {
            return iterPosition != null;
        }

        @Override
        public E next() {
            E d = iterPosition.element;
            iterPosition = iterPosition.next;
            return d;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Studentams reikia realizuoti remove()");
        }
    }

    /**
     * Vidinė mazgo klasė
     *
     * @param <E> mazgo duomenų tipas
     */
    private static class Node<E> {

        private E element;    // ji nematoma už klasės ListKTU ribų
        private Node<E> next; // next - kaip įprasta - nuoroda į kitą mazgą

        Node(E data, Node<E> next) { //mazgo konstruktorius
            this.element = data;
            this.next = next;
        }

        /**
         * Suranda sąraše k-ąjį mazgą
         *
         * @param k ieškomo mazgo indeksas (prasideda nuo 0)
         * @return surastas mazgas
         */
        public Node<E> findNode(int k) {
            Node<E> e = this;
            for (int i = 0; i < k; i++) {
                e = e.next;
            }
            return e;
        }
        
        
    } // klasės Node pabaiga
    
    
    
}
