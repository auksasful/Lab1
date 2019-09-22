/****************************************************************
 * Šioje klasėje pateikamas įvadas į JavaFX grafiką
 * 
 * Pradžioje vykdykite kodą ir stebėkite atliekamus veiksmus
 * Užduotis atlikite sekdami nurodymus programinio kodo komentaruose
 * Gynimo metu atlikite dėstytojo nurodytas užduotis naujų metodų pagalba.
 *
 * @author Eimutis Karčiauskas, KTU programų inžinerijos katedra 2019 08 05
 **************************************************************************/
package demos.graphics;

import extendsFX.BaseGraphics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Demo0_Basic extends BaseGraphics {
        
    // pradžioje brėšime horizontalias ir vertikalias linijas per centrą
    private void drawHVtoCenter() {  
        gc.setLineWidth(3);       // brėžimo linijos plotis
        gc.setStroke(Color.RED);  // ir tos linijos spalva
        gc.strokeLine(0, canvasH / 2, canvasW, canvasH / 2);
        gc.strokeLine(canvasW / 2, 0, canvasW / 2, canvasH);
    }
    // po to brėšime įstrižaines per centrą
    private void drawXtoCenter() {
        gc.setLineWidth(4);         // brėžimo linijos plotis
        gc.setStroke(Color.GREEN);  // ir tos linijos spalva
        gc.strokeLine(0, 0, canvasW, canvasH);
        gc.strokeLine(0, canvasH, canvasW, 0);
    }  
// UŽDUOTIS_1: plonomis linijomis su žingsniu step=50 nubrėžkite tinklelį
    private void drawGrid1() { 
        double step = 50;
        gc.setLineWidth(0.3);         // linijos plotis galimai mažesnis
        for(double u = step; u < Math.max(canvasW, canvasH); u += step) {
            gc.setStroke(u%100==0? Color.GREY: Color.GREY.brighter());  
            gc.strokeLine(0, u, canvasW, u);   // horizontalios linijos
            gc.strokeLine(u, 0, u, canvasH);   // vertikalios linijos
        }
    }
// https://examples.javacodegeeks.com/desktop-java/javafx/javafx-canvas-example/    
    private void drawExamples1() {
        double lw = 3.0;
        gc.setLineWidth(lw);        // brėžimo linijos plotis
        gc.setStroke(Color.BLUE);   // ir tos linijos spalva
        gc.setFill(Color.RED);      // dažymo spalva figūroms
        int x=10, y=10, w=80, h=50, 
            d=20, ax=10, ay=20; // d-tarpas tarp elementų, ax,ay-apvalinimai
        gc.strokeRoundRect(x, y, w, h, ax, ay);
        x+=w+d; // sekantis į dešinę
        gc.fillRoundRect(  x, y, w, h, ax, ay);
        gc.setLineWidth(0.5);
        gc.strokeText("Wolf and Bear", x, y+h);
        //-------------------
        gc.setLineWidth(2*lw);    // dvigubai pastoriname liniją      
        gc.setFill(Color.YELLOW);
        x = 10;    // grįžtame horizontaliai
        y += h+d;  // ir pereiname žemyn
        gc.strokeOval(x, y, w, h);
        x += w+d; // sekantis į dešinę
        gc.fillOval( x, y, h, w);
        x = 10;     // grįžtame horizontaliai
        y += h+2*d; // ir pereiname žemyn ir brėžiame lankus
        gc.strokeArc  (x, y, w, w, 30,  90, ArcType.ROUND);
        gc.fillArc(x+w+d, y, w, w, 45, 180, ArcType.OPEN);
    }  
    private void drawUnicode(){
        // išbandykite ir kitus simbolius
        // https://en.wikipedia.org/wiki/List_of_Unicode  skyrius 31
        StringBuilder sb = new StringBuilder();
        for(char ch = '\u2654'; ch <= '\u265F'; ch++)
            sb.append(ch);
        gc.setFont(Font.font("Lucida Console", 36));
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.strokeText(sb.toString(), 50, 350);
    }
// UŽDUOTIS_2: nubrėžkite polilinijas ir poligonus   
// https://www.tutorialspoint.com/javafx/2dshapes_polygon    
    private void drawExamples2() { 
        Stage stage = new Stage();
         Polygon polygon = new Polygon();  
       
      //Adding coordinates to the polygon 
      polygon.getPoints().addAll(new Double[]{ 
         300.0, 50.0, 
         450.0, 150.0, 
         300.0, 250.0, 
         150.0, 150.0, 
      }); 
          
      //Creating a Group object  
      Group root = new Group(polygon); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Drawing a Polygon"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
      
      //Displaying the contents of the stage 
      stage.show(); 

    }
// UŽDUOTIS_3: nubrėžkite taisyklingus 3, 4, 5, ..., 9-kampius  
    private void drawExamples3() {    
        // Nurodymas: parašykite funkciją, kuri paskaičiuoja skaičių masyvus
        // kuriuose surašomos taisyklingo daugiakampio koordinatės
        
         Stage stage =  new Stage();
         Polygon polygon = new Polygon();  
       
      //Adding coordinates to the polygon 
      polygon.getPoints().addAll(new Double[]{  
         450.0, 150.0, 
         300.0, 50.0, 
         150.0, 150.0, 
      }); 
          
      //Creating a Group object  
      Group root = new Group(polygon); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Daugiakampis"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
      
      //Displaying the contents of the stage 
      stage.show(); 
        
        
        
    }
    
    
    
    private Double[] Coordinates(double startCoord, int corners){
        Double[] polygon = new Double[corners * 2];
        for(int i = 0; i < corners; i += 2){
            polygon[i] = startCoord ;
        }
        return polygon;
        
    }
// UŽDUOTIS_4: nubrėžkite žiedus https://en.wikipedia.org/wiki/Olympic_symbols
    private void drawOlympicRings() {  
        double lw = 6.0;
        gc.setLineWidth(lw);        // brėžimo linijos plotis
        gc.setStroke(Color.BLUE);   // ir tos linijos spalva
            // dažymo spalva figūroms
        int x=10, y=10, w=80, h=80, d=20; // d-tarpas tarp elementų

        x = 10;    // grįžtame horizontaliai
        y += h+d;  // ir pereiname žemyn
        gc.strokeOval(x, y, w, h);
        
        x += (w/2) + 5; // sekantis į dešinę
        y += (h/2) + 5;
        gc.setStroke(Color.YELLOW);  
        gc.strokeOval( x, y, h, w);
        
        x += (w/2) + 5; // sekantis į dešinę
        y -= (h/2) + 5;
        gc.setStroke(Color.BLACK);  
        gc.strokeOval( x, y, h, w);
        
        x += (w/2) + 5; // sekantis į dešinę
        y += (h/2) + 5;
        gc.setStroke(Color.GREEN);  
        gc.strokeOval( x, y, h, w);
        
        x += (w/2) + 5; // sekantis į dešinę
        y -= (h/2) + 5;
        gc.setStroke(Color.RED);  
        gc.strokeOval( x, y, h, w);
    }
    
    
// UŽDUOTIS_5: pasirinktinai nubrėžkite savo tematiką:
// kelių valstybių sudėtingesnes vėliavas http://flagpedia.net/index
// pvz: Pietų Afrikos, Makedonijos, Norvegijos, Graikijos, Britanijos, ...
// arba futbolo, krepšinio ar ledo ritulio aikštes su žaidėjų pozicijomis  
    private void drawFreeThema() {   
        
         double lw = 2.0;
        gc.setLineWidth(lw);        // brėžimo linijos plotis
        gc.setStroke(Color.BLACK);   // ir tos linijos spalva
        gc.setFill(Color.WHITE);
            // dažymo spalva figūroms
        int x=10, y=10, w=120, h=80, d=20; // d-tarpas tarp elementų

        x = 300;    // grįžtame horizontaliai
        y += h+d;  // ir pereiname žemyn
        gc.strokeRect(x, y, w, h);
        gc.fillRect(x, y, w, h);
        
        w = 30;
        h = 30;
        gc.setFill(Color.RED);
        gc.fillRect(x, y, w, h);
        
        y += 50;
        gc.fillRect(x, y, w, h);
        
        x += 50;
        w = 70;
        gc.fillRect(x, y, w, h);
        
        y -= 50;
        gc.fillRect(x, y, w, h);
        x -= 50;
        
        gc.setFill(Color.BLUE);
        y += 35;
        h = 10;
        w = 120;
        gc.fillRect(x, y, w, h);
        
        y -= 35;
        x += 35;
        w = 10;
        h = 80;
        gc.fillRect(x, y, w, h);
    }    
// kontrolinės užduotys gynimo metu:
// įvairios vėliavos, tiesiog tokios sudėtinės figūros kaip namukas,
// medis, eglė, sniego senio siluetas :-) ir t.t.    
    @Override
    public void createControls(){
        addButton("clear", e -> clearCanvas()); 
        addButton("grid",  e -> baseGrid());
        addButton("thin grid",  e -> drawGrid1());
        addButton("HVC",   e -> drawHVtoCenter());
        addButton("XC",    e -> drawXtoCenter());
        addButton("pvz1",  e -> drawExamples1());
        addButton("pvz2",  e -> drawExamples2());
        addButton("pvz3",  e -> drawExamples3());
        addButton("Olympic rings",  e -> drawOlympicRings());
        addButton("Norway Flag",  e -> drawFreeThema());
        addButton("UniCode",  e -> drawUnicode());
        addNewHBox();
    }
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Braižymai Canvas lauke (KTU IF)");        
        setCanvas(Color.CYAN.brighter(), 600, 400);
        super.start(stage);
    }       
    public static void main(String[] args) {
        launch(args);
    }    
}
