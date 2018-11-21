package ru.vadim.dirsha.task2.model.tasks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.vadim.dirsha.task2.model.text.custom_units.Text;
import ru.vadim.dirsha.task2.model.text.default_units.ITextUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ru.vadim.dirsha.task2.utils.FileLLJava.readAllFile;

/**
 * @author = Vadim Dirsha
 * @date = 21.11.2018
 */
public class Task6Test {

    public static final String DELIMITER = "\r\n";
    public static final String TESTRESULT_FILENAME = "/testresult";
    private static String TEST_DATA = "/task6/testdata";
    private static String TEST_RESULT = "/task6/testresult";

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }


    @DataProvider(name = "data")
    public Object[][] data() {

        ArrayList<ArrayList<Object>> result = new ArrayList<>();

        for (int i = 1; this.getClass().getResource(TEST_DATA + i) != null && this.getClass().getResource(TEST_RESULT + i) != null; i++) {
            ArrayList<Object> temp = new ArrayList<>();

            try {
                List<String> sentenceList = new ArrayList<>();
                temp.add(readAllFile(getClass().getResourceAsStream(TEST_DATA + i)));
                temp.add(new ArrayList<>(Arrays.asList(
                        readAllFile(getClass().getResourceAsStream(TEST_RESULT + i))
                                .split(DELIMITER)
                        ))
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            result.add(temp);
        }

        Object[][] object = new Object[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            object[i] = result.get(i).toArray();
        }
        return object;
    }

    @Test(dataProvider = "data")
    public void testSize(String data, List<String> result) {
        ITextUnit sentence = new Text(data);
        ITaskSolver task6 = new Task6(sentence);
        List solveResult = ((Task6) task6).solve();

        assertEquals(solveResult.size(), result.size());
    }

    @Test(dataProvider = "data", dependsOnMethods = "testSize")
    public void testSolve(String data, List<String> result) {
        ITextUnit sentence = new Text(data);
        ITaskSolver task6 = new Task6(sentence);
        List solveResult = ((Task6) task6).solve();

        for (int i = 0; i < result.size(); i++) {
            assertEquals(solveResult.get(i), result.get(i));
        }
    }
}