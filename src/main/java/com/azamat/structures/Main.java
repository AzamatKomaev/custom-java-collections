package com.azamat.structures;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add(0, "Azamat");
        list.add(0, "Sasha");
        System.out.println(list);
    }
}
