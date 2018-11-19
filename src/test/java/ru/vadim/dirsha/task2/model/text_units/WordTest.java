package ru.vadim.dirsha.task2.model.text_units;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static ru.vadim.dirsha.task2.utils.FileLLJava.readAllFile;

public class WordTest {

    public static String SPLITER = "\r\n";
    private static String TEST_DATA = "/word/testdata";
    private static String TEST_RESULT = "/word/testresult";

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
                temp.add(readAllFile(getClass().getResourceAsStream(TEST_DATA + i)));

                String str = readAllFile(getClass().getResourceAsStream(TEST_RESULT + i));
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str));

                String leftSide = bufferedReader.readLine();

                String word = bufferedReader.readLine();

                String tempSide = bufferedReader.readLine();
                String rightSide = tempSide == null ? "" : tempSide;

                temp.add(new SubTextUnit<String>(word, leftSide, rightSide));
                bufferedReader.close();
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
    public void testParseDataToTextUnit(String data, SubTextUnit<String> result) {
        Word word = new Word(data);
        assertEquals(word.getLeftSide(), result.getLeftSide());
        assertEquals(word.getWord(), result.getValue());
        assertEquals(word.getRightSide(), result.getRightSide());
    }
}