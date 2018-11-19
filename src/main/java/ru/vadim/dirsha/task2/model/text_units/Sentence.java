package ru.vadim.dirsha.task2.model.text_units;

import ru.vadim.dirsha.task2.model.text_units.abstract_units.AbstractTextCollection;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.ITextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends AbstractTextCollection {
    public Sentence(String data) {
        super(data);
    }

    @Override
    public SubTextUnit<List<ITextUnit>> parseDataToTextUnitCollection(String data) {
        return new SubTextUnit<>();
    }
}
