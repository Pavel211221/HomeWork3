package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class XOgame {

    static final int SIZE = 3;       //объявление константы
    static final char DOT_X = 'X';  //метка 1-го игрока
    static final char DOT_O = 'O';  //метка 2-го игрока (компьютер)
    static final char DOT_EMPTY = '.';  //пустая ячейка

    static char[][] map;  //map - игровое поле (2-х мерный массив)

    static final Scanner sc = new Scanner(System.in);  //метод ввода 1-го игрока
    static final Random random = new Random();         //метод ввода 2-го игрока (компьютер)

    public static void main(String[] args) {
        initMap();           //3*
        printMap();           //3*


        while (true) {                                  //6*  устанавливаем бесконечный цикл для поочередности ходов человек - компьютер
            humanTurn();                                //4*
            printMap();                                 //4*
            if (checkWin(DOT_X)){                       //8* проверка на Победу!!!
                System.out.println("Вы победили!");
                break;
            }
            if (isFull()){                             //7*проверка на ничью и break
                System.out.println("Ничья");
                break;
            }


            aiTurn();                                   //5*
            printMap();                                 //5*
            if (checkWin(DOT_O)){                       //8* проверка на Победу!!!
                System.out.println("Компьютер победил. Сейчас их даже в шахматы не выиграть...");
                break;
            }
            if (isFull()){                              //7*проверка на ничью и break
                System.out.println("Ничья");
                break;
            }
        }
    }


    public static void initMap() {         //1*
        map = new char[SIZE][SIZE];       //объявили размеры поля массива [SIZE][SIZE]

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;     //1* начало игры - объявили (инициализироавли массив) поле массива из пустых ячеек DOT_EMPTY
            }

        }

    }

    public static void printMap() {             //2*
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++){
            System.out.print(i + 1 + " ");
        }
        System.out.println();                   // пронумеровали столбцы

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");    //пронумеровали строки
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);  //2* распечатали массив из пустых ячеек DOT_EMPTY
            }
            System.out.println();
        }
    }


    public static void humanTurn() {   //4* метод объявляет ход человека
        int x;                  //объявление координат
        int y;

        do {
            System.out.println("input Y X");
            y = sc.nextInt() - 1;              // ввели координаты
            x = sc.nextInt() - 1;              // ввели координаты
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;                     //обозначили метку хода

    }


    public static boolean isCellValid(int y, int x) {  //проверка верно ли сходил человек в методе humanTurn() (защита от дурака)
        if (x < 0 || y < 0 || x > SIZE || y > SIZE) {      //проверка на выход из поля map
            return false;
        }
        return map[y][x] == DOT_EMPTY;                    //проверка пустая ли ячейка поля map. ячека должна быть DOT_EMPTY
    }


    public static void aiTurn(){                    //5* метод объявляет ход компьютера  (уходим в метод main на цикл (while 6*while) )
        int x;                                       //объявление координат
        int y;

        do {
            y = random.nextInt(SIZE);
            x= random.nextInt(SIZE);
        }while (!isCellValid(y,x));

        map[y][x] = DOT_O;                     //обозначили метку хода

    }


    public static boolean isFull() {                //7* проверка на ничью
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
     * например, с использованием циклов.
     * */
    public static boolean checkWin(char c){                                      //8* проверка победы!!!
        for (int i = 0; i < 3; i++)
            if ((map[i][0] == c && map[i][1] == c &&
                    map[i][2] == c) ||
                    (map[0][i] == c && map[1][i] == c &&
                            map[2][i] == c))
                return true;
        if ((map[0][0] == c && map[1][1] == c &&
                map[2][2] == c) ||
                (map[2][0] == c && map[1][1] == c &&
                        map[0][2] == c))
            return true;
        return false;
    }
}
