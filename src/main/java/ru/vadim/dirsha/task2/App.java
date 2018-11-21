package ru.vadim.dirsha.task2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import ru.vadim.dirsha.task2.model.tasks.ITaskSolver;
import ru.vadim.dirsha.task2.model.tasks.Task6;
import ru.vadim.dirsha.task2.model.text.custom_units.Text;
import ru.vadim.dirsha.task2.model.text.custom_units.Word;
import ru.vadim.dirsha.task2.utils.FileLLJava;
import ru.vadim.dirsha.task2.utils.InputStreamHelper;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("App start");
        ITaskSolver task6 = null;
        try {
            task6 = new Task6(new Text(FileLLJava.readAllFile(new InputStreamHelper().getStream("/data.txt"))));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        List<String> result = null;
        if (task6 != null) {
            result = ((Task6) task6).solve();
            result.forEach(System.out::println);
        }
        logger.info("App end");
    }
}
