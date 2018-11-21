package ru.vadim.dirsha.task2.model.text.custom_units;

import ru.vadim.dirsha.task2.model.text.default_units.AbstractTextCollection;
import ru.vadim.dirsha.task2.model.text.default_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text.default_units.SubTextUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends AbstractTextCollection {
    private static final String LEFT_SIDE_REG = "^\\W*";
    private static final String RIGHT_SIDE_REG = "\\W*$";
    private static Pattern leftSidePattern = Pattern.compile(LEFT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);
    private static Pattern rightSidePattern = Pattern.compile(RIGHT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);
    public Sentence(String data) {
        super(data);
    }

    @Override
    public SubTextUnit<List<ITextUnit>> parseDataToTextUnit(String data) {

        String leftSide = "";
        String rightSide = "";
        String[] sentenceArray = new String[]{};

        Matcher matcher = leftSidePattern.matcher(data);
        try {

            leftSide = matcher.find() ? matcher.group() : "";
            if (!leftSide.equals("")) {
                data = data.replaceFirst(leftSide, "");
            }

            matcher = rightSidePattern.matcher(data);
            rightSide = matcher.find() ? matcher.group() : "";

            data = data.substring(0, !Objects.equals(rightSide, "") ? data.indexOf(rightSide) : data.length());
            sentenceArray = data.split(" ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ArrayList<ITextUnit> words = new ArrayList<>();
        for (String aSentenceArray : sentenceArray) {
            words.add(new Word(aSentenceArray));
        }

        return new SubTextUnit<>(words, leftSide, rightSide);
    }

    @Override
    public String toText() {
        StringBuilder result = new StringBuilder();
        for (ITextUnit unit : value.getValue()) {
            result.append(unit.toText()).append(" ");
        }
        return String.join("", value.getLeftSide(), result.toString().substring(0, result.toString().length() - 1), value.getRightSide());
    }
}
