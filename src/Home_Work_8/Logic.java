package Home_Work_8;

import java.util.Random;

public class Logic {

    static int SIZE = 5;       //объявление константы размера поля
    static int DOTS_TO_WIN = 4;       //объявление константы победы
    static final char DOT_X = 'X';  //метка 1-го игрока
    static final char DOT_O = 'O';  //метка 2-го игрока (компьютер)
    static final char DOT_EMPTY = '.';  //пустая ячейка

    static char[][] map;  //map - игровое поле (2-х мерный массив)


    static final Random random = new Random();         //метод ввода 2-го игрока (компьютер)
    static boolean isGameFinished;

    public static void go() {                           //поочередность ходов человек - компьютер
        isGameFinished = true;
        printMap();                                 //4*
        if (checkWinLines(DOT_X, DOTS_TO_WIN)) {                       //8* проверка на Победу!!!
            System.out.println("Вы победили!");
            return;
        }
        if (isFull()) {                             //7*проверка на ничью и break
            System.out.println("Ничья");
            return;
        }


        aiTurn();                                   //5*
        printMap();                                 //5*
        if (checkWinLines(DOT_O, DOTS_TO_WIN)) {                       //8* проверка на Победу!!!
            System.out.println("Компьютер победил. Сейчас их даже в шахматы не выиграть...");
            return;
        }
        if (isFull()) {                              //7*проверка на ничью и break
            System.out.println("Ничья");
            return;
        }

        isGameFinished = false;
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
        for (int i = 0; i < SIZE; i++) {
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


    public static void humanTurn(int y, int x) {   //4* метод объявляет ход человека
        if (isCellValid(y, x)){
            map[y][x] = DOT_X;                     //обозначили метку хода
            go();
        }

    }


    public static boolean isCellValid(int y, int x) {  //проверка верно ли сходил человек в методе humanTurn() (защита от дурака)
        if (x < 0 || y < 0 || x > SIZE || y > SIZE) {      //проверка на выход из поля map
            return false;
        }
        return map[y][x] == DOT_EMPTY;                    //проверка пустая ли ячейка поля map. ячека должна быть DOT_EMPTY
    }


    public static void aiTurn() {                    //5* метод объявляет ход компьютера  (уходим в метод main на цикл (while 6*while) )
        int x;                                       //объявление координат
        int y;

//ПОПЫТКА ПОБЕДИТЬ САМОМУ
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


        //СБИТЬ ПОБЕДНУЮ ЛИНИЮ ПРОТИВНИКА ЕСЛИ ОСТАЛСЯ 1 ХОД ДО ПОБЕДЫ
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


        //ПОПЫТКА ПОБЕДИТЬ САМОМУ, ЕСЛИ ОСТАЛОСЬ 2 ХОДА ДО ПОБЕДЫ
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) {     //фактор случайности чтоб сбивал не все время
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


        //СБИТЬ ПОБЕДНУЮ ЛИНИЮ ПРОТИВНИКА, ЕСЛИ ОСТАЛОСЬ 2 ХОДА ДО ПОБЕДЫ
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) {     //фактор случайности чтоб сбивал не все время
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


        //СХОДИТЬ В ПРОИЗВОЛЬНУЮ НЕ ЗАНЯТУЮ ЯЧЕЙКУ
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;         //обозначили метку хода
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




//8*Проверка победы!!!
    /**3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
     * Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     * */
    static boolean checkLine( int cy, int cx, int vy, int vx, char dot, int dotsToWin){
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0){
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx]!= dot){
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)){
                    return true;
                }
            }
        }
        return false;}
}
