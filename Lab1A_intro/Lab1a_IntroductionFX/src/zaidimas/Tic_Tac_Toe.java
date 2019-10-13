/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaidimas;

//import demos.graphics.Ball;
import extendsFX.BaseGraphics;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Application.launch;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tomas
 */
public class Tic_Tac_Toe extends BaseGraphics {
    
     boolean xTurn = true;
     List<Integer> balls = new ArrayList<>(); // saugomi kilnojami Ball objektai
     char values[][] = new char[3][3];
    
    
    private void drawSquare(double x, double y, int line, int row){

        //MouseButton mouseBtn = e.getButton();
        Shape shape =  new Rectangle(x,y,50,50);
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
        nodes.add(shape);
        
          shape.setOnMouseClicked((MouseEvent ev) -> { // atidenkite šį kodą naujam bandymui
                Shape sh = ((Shape)ev.getSource());
               // sh.setFill(randomColor());    //duoda random spalva dragable lines figurai
               if(!xTurn){
                  
                    Shape circle1 = new Circle(x + 25,y + 25,20);
                    circle1.setFill(Color.BLACK);
                    nodes.add(circle1);
                    
                     Shape circle2 = new Circle(x + 25,y + 25,13);
                    circle2.setFill(Color.WHITE);
                    nodes.add(circle2);
                    xTurn = true;
                    values[line][row] = 'o';
                    if(checkWin('o')){
                         nodes.add(new Text(300, 300, "O won!"));
                    }
               }
               else{
                    Shape cross1 = new Rectangle(x + 5,y + 20, 45, 10);
                    //cross1.rotateProperty();
                    cross1.setRotate(45);
                    cross1.setFill(Color.BLACK);
                    nodes.add(cross1);

                     Shape cross2 = new Rectangle(x + 5,y + 20, 45, 10);
                    //cross1.rotateProperty();
                    cross2.setRotate(-45);
                    cross2.setFill(Color.BLACK);
                    nodes.add(cross2);
                    xTurn = false;
                    values[line][row] = 'x';
                    
                    if(checkWin('x')){
                         nodes.add(new Text(300, 300, "X won!"));
                    }
                    else if(checkDraw()){
                         nodes.add(new Text(300, 300, "Match draw!"));
                    }
                    
               }
                
       });
    }
    
    
    
    private void setScene(){
        double startX = 100.0;
        double startY = 100.0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                drawSquare(startX + (50.0 * i), startY + (50.0 * j), i, j);
                //System.out.println(values[i][j]);
            }
        }
        
    }
    
    
    boolean checkWin(char simb){
        for(int i = 0; i < 3; i++){
        if(values[i][0] == simb && values[i][1] == simb  &&
                values[i][2] == simb){
            return true;
        }
        
        if(values[0][i] == simb && values[1][i] == simb  &&
                values[2][i] == simb){
            return true;
        } 
    }
        
         if(values[0][0] == simb && values[1][1] == simb  &&
                values[2][2] == simb){
            return true;
        }
         
        if(values[2][0] == simb && values[1][1] == simb  &&
                values[0][2] == simb){
            return true;
        }
        
        return false;
    }
    
    
    boolean checkDraw(){
         for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(values[i][j] != 'o' && values[i][j] != 'x'){
                    return false;
                }
            
            }}
         
         return true;
        
        
    }
    
    
     public void start(Stage stage) throws Exception {
        setCanvas(Color.CYAN.brighter(), 600, 600);
       // super.start(stage);
       super.start(stage);
        baseGrid();
        setScene();
      //  canvas.setOnMouseClicked(clickInfo);     
       // gc.setStroke(Color.BLACK);
       // gc.setFont(Font.font(20));
       // gc.strokeText("Spragsėkite įvairiais pelės mygtukais", 20, 20);
       // gc.strokeText("Stenkitės pataikyti į grido susikirtimus", 20, 40);
      //  gc.setFont(Font.font(14));
      //  gc.strokeText("Kurdami poligonus išbandykite susikirtimus ir uždengimus", 20, 55);
       // gc.strokeText("Gaukite figūras kaip žvaigždės, eglutės, pilys, ... ", 20, 70);
    } 
    
    public static void main(String[] args) {
        launch(args);
    }    

    @Override
    public void createControls() {
         addButton("clear",  e -> {nodes.clear(); balls.clear(); }); 
         
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


