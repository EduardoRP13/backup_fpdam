/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenrayaapp.modelo;

/**
 *
 * @author yoli
 */
public class Ficha {
    private Jugador jugador;
    
    public Ficha(Jugador jugador){
        this.jugador= jugador;
    }
    public Jugador getJugador(){
        return jugador;
    }
    public void setJugador(Jugador jugador){
        this.jugador=jugador;
    }
}
