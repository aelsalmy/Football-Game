/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import finalproject.Model.Game.Game;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author abdul
 */
public class GameRunningController {
    
    private static GameRunningController instance = new GameRunningController();
    private GameController gameController;
    
    private GameRunningController(){
        
    }
    
    public static GameRunningController getInstance(){
        return instance;
    }
    
    public void startGame(){
        Game g = new Game();
        
        //setup game menu
        JMenuBar  menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem pauseMenuItem = new JMenuItem("Pause");
	JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
	menu.addSeparator();
	menu.add(pauseMenuItem);
	menu.add(resumeMenuItem);
	menuBar.add(menu);
        
        gameController = GameEngine.start("Football Game" , g , menuBar , new Color(0,153,120));
    }
}
