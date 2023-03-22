package com.company;

public class Main {

    static int size = 10;
    static char pole = ' ';
    static char ship = '#';

    public static void main(String[] args){
        char[][] map = new char[size][size];
        water(map);
        ships(map);
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9");
        char [][] newMap= new char[map.length][map[0].length+1];
        char[] add = {'0','1','2','3','4','5','6','7','8','9'};
        int index = 0;
        for(int i=0; i<map.length; i++)
        {
            for(int j=0; j<=index; j++)
            {
                newMap[i][j]=map[i][j];
                newMap[i][j]=add[i];
                if (newMap[i].length - (index + 1) >= 0)
                    System.arraycopy(map[i], 0, newMap[i], index + 1, newMap[i].length - (index + 1));
            }
        }
        Out(newMap);
    }

    public static boolean Proverka(int size, boolean Horiz, int y, int x, char[][] map) {
        if(Horiz)
        {
            for (int i = Math.max(0, y - 1); i <= Math.min(10 - 1, y + 1); i++){
                for (int j = Math.max(0, x - 1); j <= Math.min(10 - 1, x + size); j++){
                    if(map[i][j] == ship)
                        return false;
                }
            }
            return  true;
        }
        else
        {
            for (int i = Math.max(0, y - 1); i <= Math.min(10 - 1, y + size); i++) {
                for (int j = Math.max(0, x - 1); j <= Math.min(10 - 1, x + 1); j++) {
                    if(map[i][j] == ship)
                        return false;
                }
            }
            return  true;
        }
    }
    public static void Location(int size, char[][] map) {
        boolean Horiz = (int)(Math.random() * 2) == 0;
        int y;
        int x;
        do {
            do {
                y = (int)(Math.random() * 10);
            }
            while(!Horiz && y > 10 - size);
            do {
                x = (int)(Math.random() * 10);
            }
            while( Horiz && x > 10 - size);
        }
        while(!Proverka(size, Horiz, y, x, map));

        if(Horiz) {
            for(int j = x; j < x + size; j++) {
                map[y][j] = ship;
            }
        }
        else {
            for(int i = y; i < y + size; i++) {
                map[i][x] = ship;
            }
        }
    }
    public static void ships(char[][] map) {
        for(int i = 0; i < 1; i++) {
            Location(4, map);
        }

        for(int i = 0; i < 2; i++) {
            Location(3, map);
        }

        for(int i = 0; i < 3; i++) {
            Location(2, map);
        }

        for(int i = 0; i < 4; i++) {
            Location(1, map);
        }
    }

    public static void Out(char[][] map) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size +1; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void water(char[][] map) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = pole;
            }
        }
    }
}
