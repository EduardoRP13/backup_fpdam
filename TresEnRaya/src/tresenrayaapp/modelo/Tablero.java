/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenrayaapp.modelo;

/**
 *
 * @author yoli
 */
public class Tablero {
    
        
    Ficha[][] tablero;
    int size;
    int numMovimientos;
    public Tablero(int size){
        this.size=size;
        this.numMovimientos=0;
        generarTablero();
    }
    private void generarTablero(){
        this.tablero = new Ficha[size][size];
    }
    public boolean colocarFicha(Ficha ficha, int columna, int fila){
        // comprobar si el tablero ya tiene una ficha y si no petardazo
        // comprobar si la columna y fila no existe --> petardazo
        boolean result=false;
        if(columna>=0 && columna<size && fila>=0 && fila<size && tablero[columna][fila]==null ){
            tablero[columna][fila]=ficha;
            result=true;
        }

        if(result) numMovimientos++;    
        return result;
    }
    public int getTamanoTablero(){
        return size;
    }
    public int getEstadoJuego(Jugador jugador){ 
        boolean lineaCompletada = false;
        int result= TresEnRaya.EN_PROGRESO;
        for(int i=0; i<size; i++){
            if(checkRow(jugador, i)||checkColumn(jugador, i)) lineaCompletada=true;
        }
        if(checkDiagonalSuperior(jugador)||checkDiagonalInferior(jugador)) lineaCompletada=true;
        if(lineaCompletada) result=TresEnRaya.FINALIZADO_GANADO;
        else{
            if(isTableroCompletado()) result=TresEnRaya.FINALIZADO_EMPATADO;
        }
        return result;
        
    }
    private boolean isTableroCompletado(){
        return (numMovimientos==size*size);
    }
    private boolean checkRow(Jugador jugador, int fila){

        for(int col=0;col<size; col++){
            if(!tieneFichaJugador(jugador, col, fila)) return false;
        }    
        return true;
    }

    private boolean checkColumn(Jugador jugador, int col){
        
        for(int fila=0;fila<size; fila++){
            if(!tieneFichaJugador(jugador, col, fila)) return false;
        }    
        return true;
        
    }

    private boolean checkDiagonalInferior(Jugador jugador){
    
        for(int pos=0;pos<size; pos++){
            if(!tieneFichaJugador(jugador, pos, pos)) return false;
        }    
        return true;
        
    }
   
    private boolean checkDiagonalSuperior(Jugador jugador){
    
        for(int pos=0;pos<size; pos++){
            if(!tieneFichaJugador(jugador, pos, size-pos-1)) return false;
        }    
        return true;
        
    }
    private boolean tieneFichaJugador(Jugador jugador, int col, int fila){
        return tablero[col][fila]!=null && tablero[col][fila].getJugador().equals(jugador);
    }
    
        
}
