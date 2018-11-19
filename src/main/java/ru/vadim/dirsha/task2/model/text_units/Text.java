package ru.vadim.dirsha.task2.model.text_units;

import ru.vadim.dirsha.task2.model.text_units.abstract_units.AbstractTextCollection;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.util.List;

public class Text extends AbstractTextCollection {
    public Text(String data) {
        super(data);
    }

    @Override
    public SubTextUnit<List<ITextUnit>> parseDataToTextUnit(String data) {
        return null;
    }
}
