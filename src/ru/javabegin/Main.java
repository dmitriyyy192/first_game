package ru.javabegin;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static class tic_tac_toe {
        private int count = 9; //количество свободных ячеек
        public char[][] playing_board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        public int getCount() {
            return count;
        }

        //метод изображения доски
        public void print_board() {
            for (int i = 0; i < playing_board.length; i++) {
                for (int j = 0; j < playing_board.length; j++) {
                    System.out.print(playing_board[i][j]);
                }
                System.out.println();
            }
        }

        //ход пользователя
        public void user_move(int number) {
            if (exists_count()) {
                switch (number - 1) {
                    case 0:
                        playing_board[0][0] = 'O';
                        count--;
                        break;
                    case 1:
                        playing_board[0][2] = 'O';
                        count--;
                        break;
                    case 2:
                        playing_board[0][4] = 'O';
                        count--;
                        break;
                    case 3:
                        playing_board[2][0] = 'O';
                        count--;
                        break;
                    case 4:
                        playing_board[2][2] = 'O';
                        count--;
                        break;
                    case 5:
                        playing_board[2][4] = 'O';
                        count--;
                        break;
                    case 6:
                        playing_board[4][0] = 'O';
                        count--;
                        break;
                    case 7:
                        playing_board[4][2] = 'O';
                        count--;
                        break;
                    case 8:
                        playing_board[4][4] = 'O';
                        count--;
                        break;

                }
            }
        }

        //ход компьютера
        public void computer_move() {
            if (exists_count()) {
                boolean ok = false;
                do {
                    int j = (int) (Math.random() * 9);
                    switch (j) {
                        case 0:
                            if (playing_board[0][0] == 'O' || playing_board[0][0] == 'X') {
                                break;
                            } else {
                                playing_board[0][0] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                        case 1:
                            if (playing_board[0][2] == 'O' || playing_board[0][2] == 'X') {
                                break;
                            } else {
                                playing_board[0][2] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                        case 2:
                            if (playing_board[0][4] == 'O' || playing_board[0][4] == 'X') {
                                break;
                            } else {
                                playing_board[0][4] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                        case 3:
                            if (playing_board[2][0] == 'O' || playing_board[2][0] == 'X') {
                                break;
                            } else {
                                playing_board[2][0] = 'X';
                                count--;
                                ok = true;
                                break;
                            }

                        case 4:
                            if (playing_board[2][2] == 'O' || playing_board[2][2] == 'X') {
                                break;
                            } else {
                                playing_board[2][2] = 'X';
                                count--;
                                ok = true;
                                break;
                            }

                        case 5:
                            if (playing_board[2][4] == 'O' || playing_board[2][4] == 'X') {
                                break;
                            } else {
                                playing_board[2][4] = 'X';
                                count--;
                                ok = true;
                                break;
                            }

                        case 6:
                            if (playing_board[4][0] == 'O' || playing_board[4][0] == 'X') {
                                break;
                            } else {
                                playing_board[4][0] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                        case 7:
                            if (playing_board[4][2] == 'O' || playing_board[4][2] == 'X') {
                                break;
                            } else {
                                playing_board[4][2] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                        case 8:
                            if (playing_board[4][4] == 'O' || playing_board[4][4] == 'X') {
                                break;
                            } else {
                                playing_board[4][4] = 'X';
                                count--;
                                ok = true;
                                break;
                            }
                    }
                } while (ok != true);
            }
        }

        //проверка наличия свободной ячейки
        public boolean exists_count() {
            boolean ok = false;
            for(int i = 0; i < playing_board.length; i++) {
                for(int j = 0; j < playing_board.length; j++) {
                    if(playing_board[i][j] == ' ') {
                        ok = true;
                        break;
                    }
                }
            }
            return ok;
        }

        //проверка на победу
        public boolean is_win() {
            boolean win = false;
            if((playing_board[0][0] == 'O' && playing_board[0][2] == 'O' && playing_board[0][4] == 'O') || (playing_board[0][0] == 'X' && playing_board[0][2] == 'X' && playing_board[0][4] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[2][0] == 'O' && playing_board[2][2] == 'O' && playing_board[2][4] == 'O') || (playing_board[2][0] == 'X' && playing_board[2][2] == 'X' && playing_board[2][4] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[4][0] == 'O' && playing_board[4][2] == 'O' && playing_board[4][4] == 'O') || (playing_board[4][0] == 'X' && playing_board[4][2] == 'X' && playing_board[4][4] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[0][0] == 'O' && playing_board[2][0] == 'O' && playing_board[4][0] == 'O') || (playing_board[0][0] == 'X' && playing_board[2][0] == 'X' && playing_board[4][0] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[0][2] == 'O' && playing_board[2][2] == 'O' && playing_board[4][2] == 'O') || (playing_board[0][2] == 'X' && playing_board[2][2] == 'X' && playing_board[4][2] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[0][4] == 'O' && playing_board[2][4] == 'O' && playing_board[4][4] == 'O') || (playing_board[0][4] == 'X' && playing_board[2][4] == 'X' && playing_board[4][4] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[0][0] == 'O' && playing_board[2][2] == 'O' && playing_board[4][4] == 'O') || (playing_board[0][0] == 'X' && playing_board[2][2] == 'X' && playing_board[4][4] == 'X')) {
                win = true;
                return win;
            } else if((playing_board[0][4] == 'O' && playing_board[2][2] == 'O' && playing_board[4][0] == 'O') || (playing_board[0][4] == 'X' && playing_board[2][2] == 'X' && playing_board[4][0] == 'X')) {
                win = true;
                return win;
            } else {
                return win;
            }
        }

        //функция проверяет занята ли ячейка и возвращает булевое значение
        public boolean is_empty(int number) {
            boolean be = true;
            switch (number - 1) {
                case 0:
                    if(playing_board[0][0] == 'O' || playing_board[0][0] == 'X') {
                        be = false;
                        break;
                    }
                case 1:
                    if(playing_board[0][2] == 'O' || playing_board[0][2] == 'X') {
                        be = false;
                        break;
                    }
                case 2:
                    if(playing_board[0][4] == 'O' || playing_board[0][4] == 'X') {
                        be = false;
                        break;
                    }
                case 3:
                    if(playing_board[2][0] == 'O' || playing_board[2][0] == 'X') {
                        be = false;
                        break;
                    }
                case 4:
                    if(playing_board[2][2] == 'O' || playing_board[2][2] == 'X') {
                        be = false;
                        break;
                    }
                case 5:
                    if(playing_board[2][4] == 'O' || playing_board[2][4] == 'X') {
                        be = false;
                        break;
                    }
                case 6:
                    if(playing_board[4][0] == 'O' || playing_board[4][0] == 'X') {
                        be = false;
                        break;
                    }
                case 7:
                    if(playing_board[4][2] == 'O' || playing_board[4][2] == 'X') {
                        be = false;
                        break;
                    }
                case 8:
                    if(playing_board[4][4] == 'O' || playing_board[4][4] == 'X') {
                        be = false;
                        break;
                    }
            }
            return be;
        }
    }

    //метод приветствия
    public static void greetings() {
        System.out.println(ANSI_GREEN + "---Привет. Давай поиграем в крестики-нолики. Я буду играть крестиками, а ты ноликами---" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\tЧтобы сделать ход просто выбери одну из 9 областей. Удачи!" + ANSI_RESET);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        greetings();
        System.out.print("Хотите походить первым?(y - да, n - нет): ");
        String answer = sc.next();

        tic_tac_toe toe = new tic_tac_toe();

        switch (answer) {
            case "y":
                toe.print_board();
                do {
                    int number;
                    do {
                        System.out.println(ANSI_BLUE + "Ваш ход(свободных ячеек - " + toe.getCount() + "): " + ANSI_RESET);
                        number = sc.nextInt();
                    }while(toe.is_empty(number) != true);
                    toe.user_move(number);
                    if(toe.getCount() <= 5) {
                        if(toe.is_win()) {
                            System.out.println(ANSI_PURPLE + "Вы победили!" + ANSI_RESET);
                            break;
                        }
                    }
                    toe.computer_move();
                    if(toe.getCount() <= 5) {
                        if(toe.is_win()) {
                            System.out.println(ANSI_PURPLE + "Вы проиграли:(" + ANSI_RESET);
                            break;
                        }
                    }
                    toe.print_board();
                } while (toe.getCount() > 0);
                if(!toe.is_win()) {
                    System.out.println(ANSI_YELLOW + "Ничья!" + ANSI_RESET);
                }
                break;
            case "n":
                int m_number = 0;
                do {
                    toe.computer_move();
                    if(toe.getCount() <= 5) {
                        if(toe.is_win()) {
                            System.out.println(ANSI_PURPLE + "Вы проиграли:(" + ANSI_RESET);
                            break;
                        }
                    }
                    toe.print_board();
                    do {
                        System.out.println(ANSI_BLUE + "Ваш ход(свободных ячеек - " + toe.getCount() + "): " + ANSI_RESET);
                        m_number = sc.nextInt();
                    }while(toe.is_empty(m_number) != true);
                    toe.user_move(m_number);
                    if(toe.getCount() <= 5) {
                        if(toe.is_win()) {
                            System.out.println(ANSI_PURPLE + "Вы победили!" + ANSI_RESET);
                            break;
                        }
                    }
                    toe.print_board();
                } while (toe.getCount() > 0);
                System.out.println(ANSI_YELLOW + "Ничья!" + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_RED + "---Некорректный ввод---" + ANSI_RESET);
        }

    }
}
