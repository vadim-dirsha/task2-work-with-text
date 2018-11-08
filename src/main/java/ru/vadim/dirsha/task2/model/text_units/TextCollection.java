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
package ru.vadim.dirsha.task2.model.text_units;

import java.util.ArrayList;
import java.util.List;

/**
 * @author = Vadim Dirsha
 * @date = 08.11.2018
 */
public class TextCollection extends AbstractTextUnit implements ITextUnitCollection {
    private List<ITextUnit> collection;

    TextCollection() {
        this.collection = new ArrayList<>();
    }

    @Override
    public ITextUnit get(int i) {
        return collection.get(i);
    }

    @Override
    public boolean add(ITextUnit e) {
        return collection.add(e);
    }

    @Override
    public boolean addAll(List<ITextUnit> e) {
        return collection.addAll(e);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean remove(ITextUnit e) {
        return collection.remove(e);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public void parseCollection() {

    }

    @Override
    public String toText() {
        StringBuilder result = new StringBuilder();
        for (ITextUnit unit : collection) {
            result.append(unit.toText());
        }
        return String.join("", leftSide, result, rightSide);
    }

    @Override
    public ITextUnit createTextUnit() {
        return null;
    }
}
