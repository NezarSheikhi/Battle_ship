/*
    Author_1: <Nezar Sheikhi>
*/
package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private Controller controller;
    private int counter;
    private int numOfHit;
    private int numOfMissed;
    private int boatDestroyed;
    private int destroyerDestroyed;
    private int submarineDestroyed;
    private int cruiserDestroyed;
    private int airCarrierDestroyed;

    private JLabel lblInfo;
    private JPanel title_panel;
    private JPanel button_panel;
    private JLabel textField;
    private JPanel reset_panel;
    private JButton[] buttons;
    private JList <String> list;
    private JList <String> scoreList;
    private JButton reset_btn;
    private JButton exit_btn;

    public MainPanel(int width, int height, Controller controller){
        setSize(new Dimension(width,height));
        this.controller = controller;
        createPanel();
    }
    public void createPanel(){

        setVisible(true);
        setLayout(new BorderLayout());

        lblInfo = new JLabel("0");
        counter = 0;
        numOfHit =0;
        numOfMissed =85;
        boatDestroyed=1;
        destroyerDestroyed = 1;
        submarineDestroyed = 1;
        cruiserDestroyed = 1;
        airCarrierDestroyed = 1;
        title_panel = new JPanel();
        button_panel = new JPanel();
        reset_panel = new JPanel();

        textField = new JLabel();
        buttons = new JButton[101];
        list = new JList<>();
        scoreList = new JList();
        list.setFont(new Font("New Times Roman", Font.PLAIN,14));
        scoreList.setFont(new Font("New Times Roman", Font.PLAIN,14));
        list.setBackground(Color.lightGray);
        scoreList.setBackground(Color.lightGray);

        JScrollPane s = new JScrollPane(scoreList);

        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(300-20,-2*20));

        JScrollPane s1 = new JScrollPane(list);

        s1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s1.setPreferredSize(new Dimension(300-20,-2*20));

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Battle Ship");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(10,10));
        button_panel.setBackground(new Color(150,150,150));

        Dimension dim = new Dimension(50,50);
        reset_btn = new JButton("New Game");
        reset_btn.setSize(dim);
        add(reset_panel);
        exit_btn = new JButton("Exit");
        exit_btn.setSize(dim);
        add(exit_btn);

        reset_panel.add(reset_btn);
        reset_panel.add(exit_btn);


        for(int i=1;i<101;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,30));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        add(title_panel,BorderLayout.NORTH);
        add(button_panel).setVisible(true);
        add(reset_panel,BorderLayout.SOUTH);
        addListener();
        add(s,BorderLayout.WEST);
        add(s1,BorderLayout.EAST);
    }

    private void addListener() {
        ActionListener listener = new ButtonActionListener();
        reset_btn.addActionListener(listener);
        exit_btn.addActionListener(listener);
    }
    class ButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()== reset_btn)
            {
                controller.reset();
            }else if (e.getSource() == exit_btn)
            {
                controller.exit();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=1;i<buttons.length;i++) {
            controller.setNumOfTarget1(i);
            if(e.getSource()== buttons[i]&&controller.arrayContains()!=i) {

                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        numOfMissed--;
                    }

                controller.updateView();
                controller.messed();
            }
            if (e.getSource()== buttons[i]&&controller.arrayContains()==i){

                if(buttons[i].getText().equals("")) {
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("O");
                    counter++;
                    controller.hit();

                }
                if (controller.arrayContains()==controller.getOneCell()){
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("B");
                    if (boatDestroyed==1){
                        boatDestroyed --;
                        numOfHit ++;
                    }

                    controller.updateView();
                    controller.sankBoat();
                }
                if (buttons[controller.getSecondCell_1()].getText().equals("O") && buttons[controller.getSecondCell_2()].getText().equals("O")){

                    buttons[controller.getSecondCell_1()].setForeground(new Color(0,0,255));
                    buttons[controller.getSecondCell_1()].setText("D");
                    numOfHit ++;
                    buttons[controller.getSecondCell_2()].setForeground(new Color(0,0,255));
                    buttons[controller.getSecondCell_2()].setText("D");
                    destroyerDestroyed --;
                    numOfHit ++;
                    controller.updateView();
                    controller.sankDestroyer();

                }
                if (buttons[controller.getThirdCell_1()].getText().equals("O") && buttons[controller.getThirdCell_2()].getText().equals("O")
                        && buttons[controller.getThirdCell_3()].getText().equals("O")){

                    buttons[controller.getThirdCell_1()].setForeground(new Color(0,0,255));
                    buttons[controller.getThirdCell_1()].setText("S");
                    numOfHit ++;
                    buttons[controller.getThirdCell_2()].setForeground(new Color(0,0,255));
                    buttons[controller.getThirdCell_2()].setText("S");
                    numOfHit ++;
                    buttons[controller.getThirdCell_3()].setForeground(new Color(0,0,255));
                    buttons[controller.getThirdCell_3()].setText("S");
                    submarineDestroyed --;
                    numOfHit ++;
                    controller.updateView();
                    controller.sankSubmarine();
                }
                if (buttons[controller.getForthCell_1()].getText().equals("O") && buttons[controller.getForthCell_2()].getText().equals("O")
                        && buttons[controller.getForthCell_3()].getText().equals("O")&& buttons[controller.getForthCell_4()].getText().equals("O")){

                    buttons[controller.getForthCell_1()].setForeground(new Color(0,0,255));
                    buttons[controller.getForthCell_1()].setText("C");
                    numOfHit ++;
                    buttons[controller.getForthCell_2()].setForeground(new Color(0,0,255));
                    buttons[controller.getForthCell_2()].setText("C");
                    numOfHit ++;
                    buttons[controller.getForthCell_3()].setForeground(new Color(0,0,255));
                    buttons[controller.getForthCell_3()].setText("C");
                    numOfHit ++;
                    buttons[controller.getForthCell_4()].setForeground(new Color(0,0,255));
                    buttons[controller.getForthCell_4()].setText("C");
                    cruiserDestroyed --;
                    numOfHit ++;
                    controller.updateView();
                    controller.sankCruiser();

                }

                if (buttons[controller.getFifthCell_1()].getText().equals("O") && buttons[controller.getFifthCell_2()].getText().equals("O")
                        && buttons[controller.getFifthCell_3()].getText().equals("O")&& buttons[controller.getFifthCell_4()].getText().equals("O")
                        && buttons[controller.getFifthCell_5()].getText().equals("O")){

                    buttons[controller.getFifthCell_1()].setForeground(new Color(0,0,255));
                    buttons[controller.getFifthCell_1()].setText("A");
                    numOfHit ++;
                    buttons[controller.getFifthCell_2()].setForeground(new Color(0,0,255));
                    buttons[controller.getFifthCell_2()].setText("A");
                    numOfHit ++;
                    buttons[controller.getFifthCell_3()].setForeground(new Color(0,0,255));
                    buttons[controller.getFifthCell_3()].setText("A");
                    numOfHit ++;
                    buttons[controller.getFifthCell_4()].setForeground(new Color(0,0,255));
                    buttons[controller.getFifthCell_4()].setText("A");
                    numOfHit ++;
                    buttons[controller.getFifthCell_5()].setForeground(new Color(0,0,255));
                    buttons[controller.getFifthCell_5()].setText("A");
                    airCarrierDestroyed --;
                    numOfHit ++;
                    controller.updateView();
                    controller.sankAirCarrier();
                }
                controller.gameController();
            }

        }
        getIndexButton(e);

    }

    public void getIndexButton(ActionEvent e){

        JButton button = (JButton) e.getSource();

        for (int i = 1; i< buttons.length; i++){
            if (buttons[i].equals(button))
            {
                lblInfo.setText(String.format("%d",i));
            }
        }

    }



    public void updateNameList(String[] name) {
        list.setListData(name);
    }
    public void updateScoreList(String[] name) {
        scoreList.setListData(name);
    }
    public void gameFinished(){
        for (int i = 1; i< buttons.length; i++) {
            buttons[i].setText("");
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getBoatDestroyed() {
        return boatDestroyed;
    }

    public void setBoatDestroyed(int boatDestroyed) {
        this.boatDestroyed = boatDestroyed;
    }

    public int getNumOfHit() {
        return numOfHit;
    }

    public void setNumOfHit(int numOfHit) {
        this.numOfHit = numOfHit;
    }

    public int getNumOfMissed() {
        return numOfMissed;
    }

    public void setNumOfMissed(int numOfMissed) {
        this.numOfMissed = numOfMissed;
    }

    public int getDestroyerDestroyed() {
        return destroyerDestroyed;
    }

    public void setDestroyerDestroyed(int destroyerDestroyed) {
        this.destroyerDestroyed = destroyerDestroyed;
    }

    public int getSubmarineDestroyed() {
        return submarineDestroyed;
    }

    public void setSubmarineDestroyed(int submarineDestroyed) {
        this.submarineDestroyed = submarineDestroyed;
    }

    public int getCruiserDestroyed() {
        return cruiserDestroyed;
    }

    public void setCruiserDestroyed(int cruiserDestroyed) {
        this.cruiserDestroyed = cruiserDestroyed;
    }

    public int getAirCarrierDestroyed() {
        return airCarrierDestroyed;
    }

    public void setAirCarrierDestroyed(int airCarrierDestroyed) {
        this.airCarrierDestroyed = airCarrierDestroyed;
    }

}
