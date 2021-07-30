package Home_Work_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;       //количество ячеек
    private int winLength;

    private boolean isInit;

    private int cellWidth;           //ширина ячейки
    private int cellHeight;           //высота ячейки

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {        //клик мыши в BattleMap
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int cellX = e.getX() / cellWidth;        //координата X
                int cellY = e.getY() / cellHeight;       //координата Y

                if (isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);            //постройть логику кто победил!!!

                }
                repaint();
            }
        });
    }

    void startNewGame(int fieldSize, int winLength) {       //получили данные из GameWindow
        this.fieldSize = fieldSize;
        this.winLength = winLength;
        repaint();

        isInit = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;    //ширина одной ячейки
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.GRAY);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        for (int i = 1; i < fieldSize; i++) {     //построение гороизонталей
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {     //построение вертикалей
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);

        }

//        if (Logic.map[0][1] == Logic.DOT_X) {      //ДОДЕЛАТЬ!!! двойная матрица
//            drawX(g, 0, 1);
//        }
//    }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                } else if (Logic.map[i][j] == Logic.DOT_O) {
                    draw0(g, i, j);
                }
            }
        }
    }


    private void drawX(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3));

        g.drawLine(x * cellWidth, y * cellHeight, (x + 1) * cellWidth, (y + 1) * cellHeight);
        g.drawLine(x * cellWidth, (y * cellHeight)+cellHeight, (x + 1) * cellWidth, (y) * cellHeight);
    }

    private void draw0(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3));

        g.drawOval(x * cellWidth, y * cellHeight,  cellWidth,  cellHeight);

    }
}
