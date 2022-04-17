/*
    Author_1: <Nezar Sheikhi>
*/
package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private MainPanel panel;

    private int width= 1200;
    private int height = 700;

    public MainFrame(Controller controller){

        frame = new JFrame("© Nezar Sheikhi");
        frame.setSize(width,height);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setBounds(10,10,width,height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150,150);

        panel = new MainPanel(width,height,controller);

        frame.setContentPane(panel);
        frame.getContentPane().setPreferredSize(new Dimension(width,height));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }
    public int getNumOfHit() {
        return panel.getNumOfHit();
    }

    public void updateNameList(String[] name) {
        panel.updateNameList(name);
    }
    public void updateScoreList(String[] name) {
        panel.updateScoreList(name);
    }

    public void gameFinished() {
        panel.gameFinished();
    }

    public int getCounter() {
        return panel.getCounter();
    }

    public void setCounter(int counter) {
        panel.setCounter(counter);
    }

    public void setNumOfHit(int i) {
        panel.setNumOfHit(i);
    }
    public int getNumOfMissed() {
        return panel.getNumOfMissed();
    }

    public void setNumOfMissed(int numOfMissed) {
        panel.setNumOfMissed(numOfMissed);
    }

    public void setBoatDestroyed(int i) {
        panel.setBoatDestroyed(i);
    }

    public int getBoatDestroyed() {
        return panel.getBoatDestroyed();
    }

    public void setDestroyerDestroyed(int i) {
        panel.setDestroyerDestroyed(i);
    }

    public int getDestroyerDestroyed() {
        return panel.getDestroyerDestroyed();
    }
    public void setSubmarineDestroyed(int i) {
        panel.setSubmarineDestroyed(i);
    }
    public int getSubmarineDestroyed() {
        return panel.getSubmarineDestroyed();
    }
    public void setCruiserDestroyed(int i) {
        panel.setCruiserDestroyed(i);
    }
    public int getCruiserDestroyed() {
        return panel.getCruiserDestroyed();
    }

    public void setAirCarrierDestroyed(int i) {
        panel.setAirCarrierDestroyed(i);
    }
    public int getAirCarrierDestroyed() {
        return panel.getAirCarrierDestroyed();
    }
}
