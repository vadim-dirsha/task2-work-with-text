package ru.vadim.dirsha.task2;

import ru.vadim.dirsha.task2.model.text_units.TextCollection;
import ru.vadim.dirsha.task2.model.text_units.TextUnit;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //TODO можно добавить еще один абстрактный метод чтобы избавится от лютых вложеностей при инициализации
        TextCollection<List<TextUnit<String>>> name = new TextCollection<>("");
        System.out.println("Hello World!");
    }
}
