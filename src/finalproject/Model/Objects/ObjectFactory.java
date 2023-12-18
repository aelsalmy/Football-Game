/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Random;


/**
 *
 * @author abdul
 */
public class ObjectFactory {
    private static ObjectFactory instance;
    private final Random random;

    private ObjectFactory() {
        random = new Random();
    }

    public static ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }
    
    public GameObject generateRandomAvoidable(int x, int y) {
        // Use random logic to choose the type of avoidable object
        int randomType = random.nextInt(2);

        // Create and return the corresponding object
        return switch (randomType) {
            case 0 -> new Injury(x, y);
            case 1 -> new WaterBottle(x, y);
            default -> null;
        };
    }

    public GameObject generateRandomCollectable(int x, int y) {
        // Use random logic to choose the type of collectable object
        int randomType = random.nextInt(3); 

        // Create and return the corresponding object
        return switch (randomType) {
            case 0 -> new BallonDor(x, y);
            case 1 -> new Ball(x, y,BallTypes.Jabulani);
            case 2 -> new Ball(x,y, BallTypes.Rihla);
            default -> null;
        };
    }
}
