package ru.vadim.dirsha.task2.model.text;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.vadim.dirsha.task2.model.text.default_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text.default_units.SubTextUnit;
import ru.vadim.dirsha.task2.model.text.custom_text_units.Sentence;
import ru.vadim.dirsha.task2.model.text.custom_text_units.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ru.vadim.dirsha.task2.utils.FileLLJava.readAllFile;

public class SentenceTest {
    public static final String DELIMITER = "\r\n";
    private static String TEST_DATA = "/sentence/testdata";
    private static String TEST_RESULT = "/sentence/testresult";

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

                int size = str.replaceAll("[^" + DELIMITER + "]", "").length() / DELIMITER.length();
                String[] strtemp = str.split(DELIMITER);

                List<ITextUnit> tempList = new ArrayList<>();
                String leftSide = strtemp[0];

                String rightSide = "";
                if (size == strtemp.length) {
                    for (int j = 1; j < strtemp.length; j++) {
                        tempList.add(new Word(strtemp[j]));
                    }

                } else {
                    for (int j = 1; j < strtemp.length - 1; j++) {
                        tempList.add(new Word(strtemp[j]));
                    }
                    rightSide = strtemp[strtemp.length - 1];
                }

                temp.add(new SubTextUnit<List<ITextUnit>>(tempList, leftSide, rightSide));
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
    public void testLeftSide(String data, SubTextUnit<List<ITextUnit>> result) {
        Sentence sentence = new Sentence(data);
        assertEquals(sentence.getLeftSide(), result.getLeftSide());
    }

    @Test(dataProvider = "data", dependsOnMethods = "testLeftSide")
    public void testRightSide(String data, SubTextUnit<List<ITextUnit>> result) {
        Sentence sentence = new Sentence(data);
        assertEquals(sentence.getRightSide(), result.getRightSide());
    }

    @Test(dataProvider = "data", dependsOnMethods = "testRightSide")
    public void testSize(String data, SubTextUnit<List<ITextUnit>> result) {
        Sentence sentence = new Sentence(data);
        assertEquals(result.getValue().size(), sentence.size());
    }

    @Test(dataProvider = "data", dependsOnMethods = "testSize")
    public void testParseDataToTextUnitCollection(String data, SubTextUnit<List<ITextUnit>> result) {
        Sentence sentence = new Sentence(data);
        for (int i = 0; i < result.getValue().size(); i++) {
            assertEquals(sentence.get(i).toText(), result.getValue().get(i).toText());
        }
    }
}