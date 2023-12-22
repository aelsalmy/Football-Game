/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Game;

import finalproject.Model.Objects.ItemTypes;
import finalproject.Model.Objects.Shapes;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class CollectableHitObservable {

    private ArrayList<CollectableHitObservor> subscribers = new ArrayList();
        
    public void addSubscriber(CollectableHitObservor o){
        subscribers.add(o);
    }
    
    public void removeSubscriber(CollectableHitObservor o){
        subscribers.remove(o);
    }
    
    public void notifySubscribersLeft(ItemTypes i){
        for(CollectableHitObservor subs : subscribers)
            subs.updateCollectLeft(i);
    }
    
    public void notifySubscribersRight(ItemTypes i){
        for(CollectableHitObservor subs : subscribers)
            subs.updateCollectRight(i);
    }
}
