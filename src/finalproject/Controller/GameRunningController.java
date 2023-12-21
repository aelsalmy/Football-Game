/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
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
    private LivesController livesController;
    private CollectableHitObservable collectObs;
    private AvoidableHitObservable hitObs;
    private PlayerFactory pFactory;
    private Player player;
    private Game g;
    private static javax.swing.JFrame Mainmenu;

    private GameRunningController() {
        diffController = DifficultyController.getInstance();
        pFactory = new PlayerFactory();
        scoreController = new ScoresController();
        livesController = new LivesController();

        hitObs = AvoidableHitObservable.getInstance();
        hitObs.addSubscriber(scoreController);
        hitObs.addSubscriber(livesController);

        collectObs = CollectableHitObservable.getInstance();
        collectObs.addSubscriber(scoreController);

    }

    public static void setParentFrame(javax.swing.JFrame Parent) {
        Mainmenu = Parent;
    }

    public void setPlayer(PlayerNames pName) {
        this.player = pFactory.getPlayer(pName, collectObs);
    }

    public static GameRunningController getInstance() {
        return instance;
    }

    public void startGame() {

        g = new Game(player, scoreController, hitObs);

        collectObs.addSubscriber(g);
        hitObs.addSubscriber(g);

        //setup game menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.changeWorld(new Game(player, scoreController, hitObs));
            }
        });

        gameController = GameEngine.start("Football Game", g, menuBar, new Color(0, 153, 120));
    }

}
