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

import java.util.List;

/**
 * @author = Vadim Dirsha
 * @date = 08.11.2018
 */
public class TextCollection<E extends List<? extends ITextUnit>> extends AbstractTextUnit<E> implements ITextUnitCollection {
    public TextCollection(String data) {
        super(data);
    }

    @Override
    public E getValue() {
        return null;
    }

    @Override
    public String getLeftSide() {
        return null;
    }

    @Override
    public String getRightSide() {
        return null;
    }

    @Override
    public String toText() {
        return null;
    }

    @Override
    public ITextUnit get(int i) {
        return null;
    }

    @Override
    public boolean add(ITextUnit e) {
        return false;
    }

    @Override
    public boolean addAll(List<ITextUnit> e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(ITextUnit e) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void parseCollection() {

    }

    @Override
    public E parseDataToTextUnit(String data) {
        return null;
    }
}
