package ru.vadim.dirsha.task2.model.text_units;

import ru.vadim.dirsha.task2.model.text_units.abstract_units.AbstractTextCollection;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Text extends AbstractTextCollection {

    private static String SENTENCE_REG = "[\\.\\!\\?]|\n\\W+$";
    private static Pattern pattern = Pattern.compile(SENTENCE_REG);

    private static String[] delimiters = new String[]{".", "!", "?",};
    private static HashSet<String> set = new HashSet<>(Arrays.asList(delimiters));


    public Text(String data) {
        super(data);
    }

    @Override
    public SubTextUnit<List<ITextUnit>> parseDataToTextUnit(String data) {
        String leftSide = "";
        String rightSide = "";
        ArrayList<ITextUnit> sentences = new ArrayList<>();

        StringBuilder dataB = new StringBuilder();
        dataB.append(data);
        data = "";

        StringBuilder tempB = new StringBuilder();

        for (int i = 0; i < dataB.length(); i++) {
            if (Character.isUpperCase(dataB.charAt(i)) || Character.isDigit(dataB.charAt(i))) {
                if (i != 0) {
                    tempB.append(dataB.substring(0, i));
                    dataB.delete(0, i);
                    i = 0;
                }

                if (tempB.length() > 0) {
                    if (pattern.matcher(tempB.toString()).find()) {
                        sentences.add(new Sentence(tempB.toString()));
                        tempB = new StringBuilder();
                    }
                }

            }

        }
        if (dataB.length() != 0 || tempB.length() != 0) {
            sentences.add(new Sentence(tempB.toString() + dataB.toString()));
        }

        SubTextUnit result = new SubTextUnit<List<ITextUnit>>();
        result = new SubTextUnit<List<ITextUnit>>(sentences, leftSide, rightSide);
        return result;
    }
}
