package ru.vadim.dirsha.task2.model.text_units;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.io.*;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class WordTest {

    public static String TEST_DATA = "/word/testdata";
    public static String TEST_RESULT = "/word/testresult";
    public static String SPLITER = "\r\n";

    public static String utilReadAllFile(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

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
            ArrayList temp = new ArrayList();

            try {
                temp.add(utilReadAllFile(getClass().getResourceAsStream(TEST_DATA + i)));

                String str = utilReadAllFile(getClass().getResourceAsStream(TEST_RESULT + i));
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                String leftSide = bufferedReader.readLine();
                String word = bufferedReader.readLine();
                String tempSide = bufferedReader.readLine();
                String rightSide =  tempSide == null ? "" : tempSide;
                temp.add(new SubTextUnit<String>(word, leftSide, rightSide));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
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