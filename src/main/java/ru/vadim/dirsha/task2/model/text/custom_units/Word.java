package ru.vadim.dirsha.task2.model.text.custom_units;

import org.apache.log4j.Logger;
import ru.vadim.dirsha.task2.model.text.default_units.AbstractTextUnit;
import ru.vadim.dirsha.task2.model.text.default_units.SubTextUnit;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends AbstractTextUnit {
    private static final String LEFT_SIDE_REG = "^\\W*";
    private static final String RIGHT_SIDE_REG = "\\W*$";
    private static final Logger logger = Logger.getLogger(Word.class);
    private static Pattern leftSidePattern = Pattern.compile(LEFT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);
    private static Pattern rightSidePattern = Pattern.compile(RIGHT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);
    private String delimiter = "";

    public Word(String data, String delimiter) {
        super(data);
        this.delimiter = delimiter;
    }

    public Word(String data) {
        super(data);
    }

    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public SubTextUnit<String> parseDataToTextUnit(String data) {
        String leftSide = "";
        String rightSide = "";
        String word = "";

        Matcher matcher = leftSidePattern.matcher(data);
        try {

            leftSide = matcher.find() ? matcher.group() : "";
            if (!leftSide.equals("")) {
                data = data.replaceFirst(Pattern.quote(leftSide), "");
            }

            matcher = rightSidePattern.matcher(data);
            rightSide = matcher.find() ? matcher.group() : "";
            word = data.substring(0, !Objects.equals(rightSide, "") ? data.lastIndexOf(rightSide) : data.length());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new SubTextUnit<>(word, leftSide, rightSide);
    }
}
