/****************************************************************
 * Tai įvadinė klasė žengiant į įvykiais valdomą programavimą.
 * Event-driven programming: tai plati tema- pradedame nuo paprastų pavyzdžių
 * DAUG KLAUSIMŲ APIE JAVĄ GALIMA IŠSIAIŠKINTI, ATLIEKANT
 * SAVARANKIŠKUS BANDYMUS, TYRIMUS IR ANALIZĘ :)
 * 
 * Visos demonstracinės klasės turi main metodą ir vykdomos Run File (Shift+F6)
 * 
 * Pradžioje vykdykite kodą ir stebėkite atliekamus veiksmus
 * Užduotis: Peržiūrėkite ir išsiaiškinkite pateiktas klases,
 * pakeiskite programinį kodą, stebėkite gautus rezultatus.
 * Gynimo metu atlikite dėstytojo nurodytas užduotis naujų metodų pagalba.
 *
 * @author Eimutis Karčiauskas, KTU programų inžinerijos katedra 2019 08 05
 **************************************************************************/
package demos.console;

import extendsFX.BaseConsole;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import javafx.stage.Stage;

public class Demo0_Hello extends BaseConsole{
    int clicks = 0;
    // demo pavyzdys: skaičiuojame x^2, x^3 ir fact(x)
    // nustatykite nuo kurios x reikšmės faktorialas blogai skaičiuojamas //Kai < 0
    void calculate(){
        int x = readLastInt();
        int fact = 1;
        for(int k = 2; k <= x; k++)
            fact *= k;
        print(" x="+ x +" x^2="+ x*x +" x^3="+ x*x*x);
        printLn(" fact=" + fact);
    }
    
    
    
    
// UŽDUOTIS: sudarykite naują metodą funkcijų sin, cos ir tan skaičiavimui, 
//           kai duotas kampas yra nurodomas laipsniais
    
    //TODO: PApildyti TS
    void calculateSinCosTan(){
        
        double x = readDouble();
        printLn("x = " + x);
        if(x == 0){ printLn("Netinkama įvestis!"); }  
        else{
            double a = Math.toRadians(x);
            a = (double)Math.round(a * 100) / 100;
            print("x to radians: " + a);
            print(" sin(x) = "+ Math.sin(a) +";\n cos(x) = "+ Math.cos(a) +
                ";\n tan(x) = " + Math.tan(a) + "\n");
        }
    }
    @Override
    public void createControls() {
        super.createControls();    // sukuriame bazinius mygtukus
        addButton("Hello1", e -> ta1.appendText("Hello World!!! " +nL));
        addButton("Hello2", e -> ta2.appendText("Hello World!!! " 
                                 + "I can count clicks: " + ++clicks +nL));
        addButton("calc",   e -> calculate());
        addButton("calcSinCosTan",   e -> calculateSinCosTan());
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World (KTU IF)");
//         išbandykite skirtingus ekranų nustatytumus 
//        setTextAreas("green", "red", 200, 400);
//        setTextAreas("green", null, 300, 400);
//        setTextAreas(null, "red", 350, 400);
        super.start(stage);  
    }
    public static void main(String[] args) {
        launch();
    }
}