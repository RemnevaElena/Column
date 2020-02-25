package com.company;

import java.io.IOException;
import java.util.HashMap;

public class Graf {
    public int size;
    public Integer desk[][];
    public String num; //номер вершины, которую нужно удалить
    public Integer a;
    public Integer b;
    public Integer  nameCount = 0;
    public Integer weight;
    public Integer num1;
    public Integer count;
    public Integer name1;
    public HashMap<Integer, String> name = new HashMap();
    public Graf(int size) {
        this.size = size; //количество вершин
        this.desk = new Integer[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                this.desk[i][j] = -1 + (int) (Math.random() * 5);
                this.name.put(i, Integer.toString(i));
                nameCount = i;
            }
    }
    public Integer SearchOfIndex (String name1) {
        for (int i = 0; i < size; i++) {
            if (name.get(i) == name1) {
                return i;
            }
        }
        return null;
    }
    public Integer[][] DeleteOfTop (int num) {
        Integer desk1[][] = new Integer[size - 1][size - 1];
        for (int j = num; j < size - 1; j++) {
            for (int i = 0; i < size; i++) {
                this.desk[i][j] = this.desk[i][j + 1];
            }
        }
        for (int i = num; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                this.desk[i][j] = this.desk[i + 1][j];
            }
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) desk1[i][j] = desk[i][j];
        }
        name.remove(num);
        for (int i = num; i < size - 1; i++) {
            name.put(i, name.get(i + 1));
        }
        name.remove(size - 1);
        size = size - 1;
        this.desk = desk1;
        return this.desk;
    }

    public Integer[][] AdditionOfTop() {
        Integer desk1[][] = new Integer[size + 1][size + 1];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) desk1[i][j] = this.desk[i][j];
        for (int i = 0; i <= size; i++) desk1[i][size] = 0;
        for (int j = 0; j <= size; j++) desk1[size][j] = 0;
        this.desk = desk1;
        name.put(size, Integer.toString(nameCount + 1));
        System.out.println(name);
        size = size + 1;
        return this.desk;
    }

    public String EnteringTops (int num) {
        int count = 0;
        String rezult = "";
        for (int i = 0; i < size; i++) {
            if (desk[i][num] != -1 && desk[i][num] > 0) {
                rezult += Integer.toString(i) + " ";
                count++;
            }
            //если меньше или равно 0, кинем исключение
        }
        if(count == 0) rezult += "Нет входящих вершин";
        System.out.println(rezult);
        return rezult;
    }
    public String OutgoingTops (int num) {
        int count = 0;
        String rezult = "";
        for (int i = 0; i < size; i++) {
            if (desk[num][i] != -1 && desk[num][i] > 0) {
                rezult += Integer.toString(i) + " ";
                count++;
            }
        }
        if(count == 0) rezult += "Нет исодящих вершин";
        System.out.println(rezult);
        return rezult;
    }
    public Integer[][] DeleteOfAnEdge (int a, int b) {
        this.desk[a][b] = -1;
        return this.desk;
    }
    public Integer[][] AdditionEdges (int a, int b, int weight) {
        this.desk[a][b] = weight;
        return this.desk;
    }

}
