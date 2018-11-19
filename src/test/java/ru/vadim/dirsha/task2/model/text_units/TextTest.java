package ru.vadim.dirsha.task2.model.text_units;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ru.vadim.dirsha.task2.utils.FileLLJava.readAllFile;

public class TextTest {

    public static final String DELIMITER = "\r\n";
    public static final String TESTRESULT_FILENAME = "/testresult";
    private static String TEST_DATA = "/text/testdata";
    private static String TEST_RESULT = "/text/testresult";

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

                for (int j = 1; this.getClass().getResource(TEST_RESULT + i + TESTRESULT_FILENAME + j) != null; j++) {
                    sentenceList.add(readAllFile(getClass().getResourceAsStream(TEST_RESULT + i + TESTRESULT_FILENAME + j)));
                }

                temp.add(sentenceList);
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
        Text sentence = new Text(data);
        assertEquals( sentence.size(), result.size());
    }

    @Test(dataProvider = "data", dependsOnMethods = "testSize")
    public void testParseDataToTextUnitCollection(String data, List<String> result) {
        Text sentence = new Text(data);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(sentence.get(i).toText(), result.get(i));
        }
    }
}