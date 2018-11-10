package ru.vadim.dirsha.task2;

import ru.vadim.dirsha.task2.model.text_units.TextCollection;
import ru.vadim.dirsha.task2.model.text_units.TextUnit;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        TextCollection<List<TextUnit<String>>> name = new TextCollection<>("");
        System.out.println("Hello World!");
    }
}
