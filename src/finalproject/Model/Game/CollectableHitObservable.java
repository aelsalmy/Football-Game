/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Game;

import finalproject.Model.Objects.Shapes;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class CollectableHitObservable {
    private static CollectableHitObservable instance = new CollectableHitObservable();
    private ArrayList<CollectableHitObservor> subscribers = new ArrayList();
    
    private CollectableHitObservable(){
        
    }
    
    public static CollectableHitObservable getInstance(){
        return instance;
    }
    
    public void addSubscriber(CollectableHitObservor o){
        subscribers.add(o);
    }
    
    public void removeSubscriber(CollectableHitObservor o){
        subscribers.remove(o);
    }
    
    public void notifySubscribers(Shapes s){
        for(CollectableHitObservor subs : subscribers)
            subs.updateCollect(s);
    }
}
