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
public class TextCollection extends TextUnit implements ITextUnitCollection {
    private List<ITextUnit> mCollection;

    TextCollection() {
        this.mCollection = new ArrayList<>();
    }

    @Override
    public ITextUnit get(int i) {
        return mCollection.get(i);
    }

    @Override
    public boolean add(ITextUnit e) {
        return mCollection.add(e);
    }

    @Override
    public boolean addAll(List<ITextUnit> e) {
        return mCollection.addAll(e);
    }

    @Override
    public void clear() {
        mCollection.clear();
    }

    @Override
    public boolean isEmpty() {
        return mCollection.isEmpty();
    }

    @Override
    public boolean remove(ITextUnit e) {
        return mCollection.remove(e);
    }

    @Override
    public int size() {
        return mCollection.size();
    }

    @Override
    public String getValue() throws IllegalAccessException {
        //TODO it looks stupid
        throw new IllegalAccessException();
    }
}
