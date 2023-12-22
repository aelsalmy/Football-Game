/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import finalproject.Model.DifficultyStrategies.Strategy;
import finalproject.Model.Game.AvoidableHitObservable;
import finalproject.Model.Game.CollectableHitObservable;
import finalproject.Model.Game.Game;
import finalproject.Model.Game.ScoresController;
import finalproject.Model.Players.Player;
import finalproject.Model.Players.PlayerFactory;
import finalproject.Model.Players.PlayerNames;
import finalproject.View.MainMenuView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private DifficultyController diffController;
    private ScoresController scoreController;
    private CollectableHitObservable collectObs;
    private AvoidableHitObservable hitObs;
    private PlayerFactory pFactory;
    private Player player;
    private Game g;

    private GameRunningController() {
        diffController = DifficultyController.getInstance();
        pFactory = new PlayerFactory();
        scoreController = new ScoresController();

        hitObs = AvoidableHitObservable.getInstance();
        hitObs.addSubscriber(scoreController);

        collectObs = CollectableHitObservable.getInstance();
        collectObs.addSubscriber(scoreController);
    }

    public void setPlayer(PlayerNames pName) {
        this.player = pFactory.getPlayer(pName, collectObs);
    }

    public void setDifficulty(Strategy s) {
        diffController.setDifficulty(s);
    }

    public static GameRunningController getInstance() {
        return instance;
    }
public void endGame()
{
    System.exit(0);
}
    public void startGame() {

        g = new Game(player, scoreController, hitObs);
        diffController.updateDifficulty(g);

        collectObs.addSubscriber(g);
        hitObs.addSubscriber(g);

        //setup game menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.addSeparator();
        menu.add(exitMenuItem);
        menuBar.add(menu);
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
       exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gameController.changeWorld(new Game(player, scoreController, hitObs));
            System.exit(0);
            }
        });
       newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MainMenuView mmv = new MainMenuView();
//                g.endGame();
//                mmv.setVisible(true);
                Game ng = new Game(player, scoreController, hitObs);
                 diffController.updateDifficulty(ng);

        collectObs.addSubscriber(ng);
        hitObs.addSubscriber(ng);
        gameController.changeWorld(ng);
                
            
            }
        });

        gameController = GameEngine.start("Football Game", g, menuBar, new Color(0, 153, 120));
    }
}
