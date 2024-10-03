/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresenrayaapp.modelo;

import java.awt.Color;


/**
 *
 * @author yoli
 */
public class TresEnRaya {

    public static final int MOV_INVALIDO=-1;
    public static final int EN_PROGRESO=0;
    public static final int FINALIZADO_GANADO=1;
    public static final int FINALIZADO_EMPATADO=2;
    
    
    public static final String COLOR_AZUL="BLUE";
    public static final String COLOR_ROJO="RED";
    
    private Jugador[] jugadores;
    private Tablero tablero;
    private int turno;
    private int estado;
    public TresEnRaya(int size){
        jugadores=new Jugador[2];
        jugadores[0]=new Jugador("jugador1", COLOR_AZUL);
        jugadores[1]=new Jugador("jugador2", COLOR_ROJO);
        inicializarJuego(size);
   
    }
    public void inicializarJuego(int size, String nombreJugador1, String colorJugador1, String nombreJugador2, String colorJugador2){
        jugadores[0].setNickName(nombreJugador1);
        jugadores[0].setColor(colorJugador1);
        jugadores[1].setNickName(nombreJugador2);
        jugadores[1].setColor(colorJugador2);
        inicializarJuego(size);
        
    }
     public void inicializarJuego(int size){
        reiniciarTablero(size);
        turno=0;
        estado=EN_PROGRESO; 
        
    }
    public Jugador getJugadorTurno(){
        return jugadores[turno];
    }
    public int getTamanhoTablero(){
        return tablero.getTamanoTablero();
    }
    public void reiniciarTablero(int size){
        tablero=new Tablero(size);
    }
    public Jugador getJugador(int pos){
        return jugadores[pos];
    }
            
    public int realizarJugada(Jugador jugador, int columna, int fila){
        int result=MOV_INVALIDO;
        if(estado==EN_PROGRESO && tablero.colocarFicha(jugador.getFicha(), columna, fila)){
            turno= (turno+1)%2;
            System.out.println("Turno: posicion "+turno);
            estado=tablero.getEstadoJuego(jugador);
            result= estado;
        }
        return result;
    }
    
   
    
}
