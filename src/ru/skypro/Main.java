package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("line_1");
        stringList.add("line_2");
        stringList.add("line_3");
        stringList.add("line_4");

        stringList.add(3, "line_6");

        stringList.remove(1);

        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.clear();

        System.out.println(stringList.size());

    }
}
