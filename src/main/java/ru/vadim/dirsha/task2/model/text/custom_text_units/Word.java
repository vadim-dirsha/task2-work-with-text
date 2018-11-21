package ru.vadim.dirsha.task2.model.text.custom_text_units;

import ru.vadim.dirsha.task2.model.text.default_units.AbstractTextUnit;
import ru.vadim.dirsha.task2.model.text.default_units.SubTextUnit;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends AbstractTextUnit {
    private static String LEFT_SIDE_REG = "^\\W*";
    private static String RIGHT_SIDE_REG = "\\W*$";
    private static Pattern leftSidePattern = Pattern.compile(LEFT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);
    private static Pattern rightSidePattern = Pattern.compile(RIGHT_SIDE_REG, Pattern.UNICODE_CHARACTER_CLASS);

    public Word(String data) {
        super(data);
    }

    @Override
    public SubTextUnit parseDataToTextUnit(String data) {
        SubTextUnit result = new SubTextUnit<String>();
        String leftSide = "";
        String rightSide = "";
        String word = "";

        Matcher matcher = leftSidePattern.matcher(data);
        try {

            leftSide = matcher.find() ? matcher.group() : "";
            if (!leftSide.equals("")) {
                // FIXME: 19.11.2018 Тут подстава ведь в во всех этих реплейсах сплитах и прочем РЕГЕКСЫ И тут могут быть служебные символы, ухнать как их изолировать

                data = data.replaceFirst(Pattern.quote(leftSide), "");
            }

            matcher = rightSidePattern.matcher(data);
            rightSide = matcher.find() ? matcher.group() : "";
            word = data.substring(0, !Objects.equals(rightSide, "") ? data.lastIndexOf(rightSide) : data.length());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        result = new SubTextUnit<String>(word, leftSide, rightSide);
        return result;
    }
}
