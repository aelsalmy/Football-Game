/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author abdul
 */
public class ObjectFactory {
    private static ObjectFactory instance;

    private ObjectFactory() {

    }

    public static ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }
    
    public GameObject generateRandomAvoidable(int x, int y) {

        // Create and return a random object
        return switch ((int)(Math.random()*2)) {
            case 0 -> new Injury(x, y);
            case 1 -> new WaterBottle(x, y);
            default -> null;
        };
    }

    public GameObject generateRandomCollectable(int x, int y) {

        // Create and return a random object
        return switch ((int)(Math.random()* 2)) {
            case 0 -> new BallonDor(x, y);
            case 1 -> new Ball(x , y ,(int)(Math.random() * 3));
            default -> null;
        };
    }
    
    
}
