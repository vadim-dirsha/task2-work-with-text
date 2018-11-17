package ru.vadim.dirsha.task2.model.text_units;

import ru.vadim.dirsha.task2.model.text_units.abstract_units.AbstractTextUnit;
import ru.vadim.dirsha.task2.model.text_units.abstract_units.SubTextUnit;

public class Word extends AbstractTextUnit {
    public Word(String data) {
        super(data);
    }

    @Override
    public SubTextUnit parseDataToTextUnit(String data) {
        
        return new SubTextUnit("","","");
    }
}
