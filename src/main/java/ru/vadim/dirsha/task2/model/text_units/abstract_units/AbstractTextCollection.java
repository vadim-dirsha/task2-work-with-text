/**
 * Vadim Dirsha
 * Copyright (c) 2018 Java Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package ru.vadim.dirsha.task2.model.text_units.abstract_units;

import java.util.List;

/**
 * @author = Vadim Dirsha
 * @date = 08.11.2018
 */
public abstract class AbstractTextCollection extends AbstractTextUnit implements ITextUnitCollection {

    private SubTextUnit<List<ITextUnit>> value;

    public AbstractTextCollection(String data) {
        super(data);
    }

    @Override
    public ITextUnit get(int i) {
        return value.getValue().get(i);
    }

    @Override
    public boolean add(ITextUnit e) {
        return value.getValue().add(e);
    }

    @Override
    public boolean addAll(List<ITextUnit> e) {
        return value.getValue().addAll(e);
    }

    @Override
    public void clear() {
        value.getValue().clear();
    }

    @Override
    public boolean isEmpty() {
        return value.getValue().isEmpty();
    }

    @Override
    public boolean remove(ITextUnit e) {
        return value.getValue().remove(e);
    }

    @Override
    public int size() {
        return value.getValue().size();
    }


}