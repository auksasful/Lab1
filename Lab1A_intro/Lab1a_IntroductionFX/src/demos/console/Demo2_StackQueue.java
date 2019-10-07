/****************************************************************
 * Šioje klasėje tiriame bazinių klasių Stack ir Queue metodus
 * 
 * Visos demonstracinės klasės turi main metodą ir vykdomos Run File (Shift+F6)
 * 
 * Pradžioje vykdykite kodą ir stebėkite atliekamus veiksmus
 * Užduotis atlikite sekdami nurodymus programinio kodo komentaruose
 * Gynimo metu atlikite dėstytojo nurodytas užduotis naujų metodų pagalba.
 *
 * @author Eimutis Karčiauskas, KTU programų inžinerijos katedra 2019 08 05
 **************************************************************************/
package demos.console;
import extendsFX.BaseConsole;
import java.util.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Demo2_StackQueue extends BaseConsole{
    String[] array = {};
    final Stack<String> stack = new Stack<>();
    final Queue<String> queue = new ArrayDeque<>();
    final List<String>  list  = new LinkedList<>();
    final HashSet<String> hash = new HashSet<String>(); 
    
    TextField elName = null;
    private int click;
    
    private void pushStack() {
        stack.push("e" + click++);
        printLn(stack.toString());
    }
    private void popStack() {
        try {  // gaudome tuščio steko exception
            String t = stack.pop();
            queue.add(t);
            printLn(stack.toString());
            ta1.appendText(queue.toString()+nL);
        } catch (EmptyStackException e){
            printLn("ERROR!!! Operacija pop() su tuščiu steku negalima");
        }
    }
    private void poolQueue() {
        queue.poll();
        ta1.appendText(queue.toString()+nL);
    }
    private void addToListMid() {
        list.add(list.size()/2, "e" + click++);
        ta1.appendText(list.toString()+nL);
    }
    
    private void addToArray(){
        array = addElement(array, "e" + click++);
        ta1.appendText(Arrays.toString(array) + nL);
    }
    
    private void addToHashSet(){
        hash.add("e" + click++);
        ta1.appendText(hash + nL);
    }
    
    private void removeFromHash(String el){
        if(hash.contains(el)){
            hash.remove(el);
            ta1.appendText(el + " Removed from hash!" + nL);
            ta1.appendText(hash + nL);
        }
        else{
             ta1.appendText("No element '" + el + "' in the hashSet!" + nL);
        }
    }
    
    @Override
    public void createControls() {
        super.createControls();
        
        addButton("push", action -> pushStack());       
        addButton("pop",  action -> popStack() );       
        addButton("pool", action -> poolQueue());       
        addButton("addToMid", action -> addToListMid()); 
        addButton("addToArray", action -> addToArray()); 
        addButton("addToHash", action -> addToHashSet()); 
        elName = addTextField("Elementas, kurį išimti iš Hash", "", 40);
        addButton("removeFromHash", action -> removeFromHash(elName.getText())); 
    }
// UŽDUOTIS: ištirkite kitų struktūrų metodus
// https://www.geeksforgeeks.org/introduction-to-data-structures-10-most-commonly-used-data-structures/    
    @Override
    public void start(Stage stage) throws Exception {
        setTextAreas("green", "red", 350, 400);
        stage.setTitle("Eksperimentai su Stack'u ir Queue (VirP)");
        super.start(stage);  
    }
    public static void main(String[] args) {
        launch();
    }
}
