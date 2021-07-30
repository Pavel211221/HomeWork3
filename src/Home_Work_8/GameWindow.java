package Home_Work_8;

import javax.swing.*;
import java.awt.*;


public class GameWindow  extends JFrame {
    private BattleMap battleMap;
    private Setting setting;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //кнопка закрытия(крестик)
        setBounds(500, 500, 500, 500);          //размер окена
        setTitle("TicTavToe");                                    //надпись в загаловке окна

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStart = new JButton("Start new  game");
        panel.add(buttonStart);

        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        battleMap = new BattleMap(this);                //сделали ссылку на BattleMap
        add(battleMap, BorderLayout.CENTER);
        setting = new Setting(this);                //сделали ссылку на Setting

//        buttonStart.addActionListener(new ActionListener() {          //press on (new ActionListener()) -> alt + enter  -> replace with lambda
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Hello");
//            }
//        });

//        buttonStart.addActionListener(e -> System.out.println("Hello"));

        buttonStart.addActionListener(e -> setting.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));

        setVisible(true);                                         //по умолчанию окно не видимое
    }

    void startNewGame(int fieldSize, int winLength) {
        battleMap.startNewGame(fieldSize, winLength);   //получили данные из Setting и передали данные в BattleMap
    }
}
