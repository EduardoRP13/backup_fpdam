/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tresenrayaapp.vista;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import tresenrayaapp.modelo.TresEnRaya;
import tresenrayaapp.modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author yoli
 */
public class TresEnRayaFXMLController /*implements Initializable*/{

    //paneles
    @FXML
    private GridPane pnlContenedorTablero;
    //componentes
    @FXML
    private TextField txtNombreJugador1;
    @FXML
    private TextField txtNombreJugador2;
    @FXML
    private Label lblxtErrorNombreJugador1;
    @FXML
    private Label lblxtErrorNombreJugador2;
    @FXML
    private RadioButton rbJugador1Rojo;
    @FXML
    private RadioButton rbJugador1Azul;
    @FXML
    private RadioButton rbJugador2Rojo;
    @FXML
    private RadioButton rbJugador2Azul;
    @FXML
    private ComboBox cbTamanoTablero;
    @FXML
    private Button btnJugar;
    @FXML
    private Button btnAbandonar;
    @FXML
    private Label lblTurno;
    
    
    
    private Button tablero[][];
    private GridPane pnlTablero;
    private TresEnRaya juego;
    
    
    //private Parent root;
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
    protected void initialize() {
        juego=new TresEnRaya(3);
       initComponents();
        initDefaultValues();
    }    
/*
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene= new Scene(root);
        stage.setTitle("Tres En Raya JavaFX");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
*/
    
    
    /*@Override*/
   /* public void initialize(URL url, ResourceBundle rb) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        initialize();
    }*/

    
    private void initComponents(){
        //valores del combobox
        cbTamanoTablero.getItems().add("3 x 3");
        cbTamanoTablero.getItems().add("4 x 4");
        cbTamanoTablero.getItems().add("5 x 5");
        //nos apuntamos como escuchador el cambio de propiedad "selected" en los radiobuttons
        rbJugador1Rojo.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldVal, Boolean newVal) {
                ejecutarAccionCambioEstadoRbJugador1Rojo(newVal);
            }
        });
        rbJugador2Rojo.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldVal, Boolean newVal) {
                ejecutarAccionCambioEstadoRbJugador2Rojo(newVal);
            }
        }
        );
        
    }
    private void initDefaultValues(){
        System.out.println("Estoy aquí - initDefaultValues");
        
       
        
        Jugador jugador=juego.getJugador(0);
        setSelectColor(jugador.getColor(),rbJugador1Rojo, rbJugador1Azul);
        jugador=juego.getJugador(1);
        setSelectColor(jugador.getColor(),rbJugador2Rojo, rbJugador2Azul);
        
        
        setSelectTamanoTablero(juego.getTamanhoTablero());
        
        initTablero(juego.getTamanhoTablero());
        limpiarTurno();

        btnAbandonar.setDisable(true);
        setEnabledTablero(false);
               

    } 
    
     private int getSelectTamanoTablero(){
      return cbTamanoTablero.getSelectionModel().getSelectedIndex()+3;
    }    
    private void setSelectTamanoTablero(int size){
        cbTamanoTablero.getSelectionModel().select(size-3);
    }
    private String getSelectColor(RadioButton rbRojoJugador){
        return (rbRojoJugador.isSelected())?TresEnRaya.COLOR_ROJO:TresEnRaya.COLOR_AZUL;
    }
    
    private void setSelectColor(String color, RadioButton rbRojo, RadioButton rbAzul) {
        if(color==TresEnRaya.COLOR_AZUL){
            rbAzul.setSelected(true);
        }else{
            rbRojo.setSelected(true);
        }

    }
    
    private void initTablero(int size){
        if(pnlTablero!=null){
            pnlContenedorTablero.getChildren().remove(pnlTablero);
        }
        pnlTablero = new GridPane(); 
//        pnlTablero.setGridLinesVisible(true);
        
        
        tablero = new Button [size][size];
        Button boton;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                boton=new Button();
                boton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                tablero[i][j]= boton;
                tablero[i][j].setOnAction(new CeldaTableroAdapter(i, j));
                pnlTablero.add(tablero[i][j], i, j);
                GridPane.setHgrow(boton, Priority.ALWAYS);
                GridPane.setVgrow(boton, Priority.ALWAYS);
            }
        }

        pnlContenedorTablero.add(pnlTablero,0,0);
        
        //pnlContenedorTablero.revalidate();
              
    }
    
    
    private void setEnabledPnlConfig(boolean enabled){
        txtNombreJugador1.setDisable(!enabled);
        txtNombreJugador2.setDisable(!enabled);
        rbJugador1Rojo.setDisable(!enabled);
        rbJugador1Azul.setDisable(!enabled);
        rbJugador2Rojo.setDisable(!enabled);
        rbJugador2Azul.setDisable(!enabled);
        cbTamanoTablero.setDisable(!enabled);
    }
    private void setEnabledTablero(boolean enabled){
        for(Node c:pnlTablero.getChildren()){
            c.setDisable(!enabled);
        }
    }
    
    private void establecerTurno(){
         Jugador jugador=juego.getJugadorTurno();
         lblTurno.setText(jugador.getNickName());
         lblTurno.setTextFill(javafx.scene.paint.Color.web(getHexColor(jugador.getColor())));
    }    
    private void limpiarTurno(){
        lblTurno.setText("");
    }
    
    
    private void ejecutarAccionCambioEstadoRbJugador1Rojo(Boolean jugador1RojoIsSelected) {                                                          
        if(jugador1RojoIsSelected){
            rbJugador2Azul.setSelected(true);
        }else{
            rbJugador2Rojo.setSelected(true);
        }
    }                                                         
    
    
    private void ejecutarAccionCambioEstadoRbJugador2Rojo(Boolean jugador2RojoIsSelected) {                                                          
         if(jugador2RojoIsSelected){
            rbJugador1Azul.setSelected(true);
        }else{
            rbJugador1Rojo.setSelected(true);
        }
    }    
    
    @FXML
    private void ejecutarAccionBtnJugar(ActionEvent evt) {                                         
        juego.inicializarJuego(getSelectTamanoTablero(),txtNombreJugador1.getText(), getSelectColor(rbJugador1Rojo), txtNombreJugador2.getText(), getSelectColor(rbJugador1Azul));
        initTablero(juego.getTamanhoTablero());
        
        establecerTurno();
        
        btnAbandonar.setDisable(false);
        btnJugar.setDisable(true);
        
        setEnabledPnlConfig(false);
        setEnabledTablero(true);
    } 
    
    @FXML
    private void ejecutarAccionBtnAbandonar(ActionEvent evt) {                                            
        finalizarJuego();
    }  
    
    private void ejecutarAccionBtnCeldaTablero(ActionEvent evt, int columna, int fila) {                                         
        Alert alert;
    
        System.out.println("Presionado el botón columna: "+columna+" fila: "+fila );
        Jugador jugador=juego.getJugadorTurno();
        Button boton=tablero[columna][fila];
        
        int estado=juego.realizarJugada(jugador,columna, fila);
        if(estado!=TresEnRaya.MOV_INVALIDO){
        //boton.setEnabled(false);
            boton.setStyle(String.format("-fx-background-color: %s;",getHexColor(jugador.getColor())));
            switch(estado){
                case TresEnRaya.EN_PROGRESO:
                    establecerTurno();
                    break;
                case TresEnRaya.FINALIZADO_GANADO:
                    alert = new Alert (AlertType.INFORMATION,String.format("¡Enhorabuena %s!\nHas ganado la partida.",jugador.getNickName()), ButtonType.OK);
                    alert.showAndWait();

                    finalizarJuego();
                    break;
                case TresEnRaya.FINALIZADO_EMPATADO:

                    alert = new Alert (AlertType.INFORMATION,"¡EMPATE!\nNo hay más movimientos posibles.", ButtonType.OK);
                    alert.showAndWait();
                    finalizarJuego();
                    break;
            }
            
        }else{
            //cualquier cosa que se quiera hacer para avisar al usuario
        }
        
        
      
    }
    
     
    private void finalizarJuego(){
        
       // initTablero(juego.getTamanhoTablero());
        limpiarTurno();
        
        btnAbandonar.setDisable(true);
        btnJugar.setDisable(false);
        
        setEnabledPnlConfig(true);
        setEnabledTablero(false);
     }
    
      
      
    public String getHexColor(String color){
        
        if(color.equals(TresEnRaya.COLOR_ROJO)){
            return "#FF0000";
        }else{
            return "#0000FF";
        } 

    }

    class CeldaTableroAdapter implements EventHandler<ActionEvent>{
        private int columna;
        private int fila;
        
        CeldaTableroAdapter(int columna, int fila){
            this.columna=columna;
            this.fila=fila;
        }

        @Override
        public void handle(ActionEvent t) {
           ejecutarAccionBtnCeldaTablero(t, columna, fila);
        }
        
        
    }

  
}
