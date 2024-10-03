/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenrayaapp.modelo;



/**
 *
 * @author yoli
 */
public class Jugador {
    private String nickName;
    private String color;
    
    
    public Jugador(String nickName, String color){
        this.nickName=nickName;
        this.color = color;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    public Ficha getFicha(){
        return new Ficha(this);
    }
}
