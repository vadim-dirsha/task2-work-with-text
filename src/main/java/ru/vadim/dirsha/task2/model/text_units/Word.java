package ru.vadim.dirsha.task2.model.text_units;

import ru.vadim.dirsha.task2.model.text_units.abstract_units.AbstractTextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends AbstractTextUnit {
    private static String LEFT_SIDE_REG = "^\\W*";
    private static String RIGHT_SIDE_REG = "\\W*$";
    private static Pattern leftSidePattern = Pattern.compile(LEFT_SIDE_REG);
    private static Pattern rightSidePattern = Pattern.compile(RIGHT_SIDE_REG);

    public Word(String data) {
        super(data);
    }

    @Override
    public SubTextUnit parseDataToTextUnit(String data) {
        SubTextUnit result = new SubTextUnit();
        String leftSide = "";
        String rightSide = "";
        String word = "";

        Matcher matcher = leftSidePattern.matcher(data);
        try {

            leftSide = matcher.find() ? matcher.group() : "";
            if (leftSide != ""){
                data = data.substring(data.indexOf(leftSide), data.length());
            }

            matcher = rightSidePattern.matcher(data);
            rightSide = matcher.find() ? matcher.group() : "";
            word = data.substring(leftSide.length(), !Objects.equals(rightSide, "") ? data.indexOf(rightSide) : data.length());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        result = new SubTextUnit(word, leftSide, rightSide);
        return result;
    }
}
