package com.azamat.structures;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
    }
}
