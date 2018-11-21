package ru.vadim.dirsha.task2;

import ru.vadim.dirsha.task2.model.tasks.ITaskSolver;
import ru.vadim.dirsha.task2.model.tasks.Task6;
import ru.vadim.dirsha.task2.model.text.custom_units.Text;
import ru.vadim.dirsha.task2.utils.FileLLJava;
import ru.vadim.dirsha.task2.utils.InputStreamHelper;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ITaskSolver task6 = null;
        try {
            task6 = new Task6(new Text(FileLLJava.readAllFile(new InputStreamHelper().getStream("/data.txt"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> result = null;
        if (task6 != null) {
            result = ((Task6) task6).solve();
            result.forEach(System.out::println);
        }


    }
}
