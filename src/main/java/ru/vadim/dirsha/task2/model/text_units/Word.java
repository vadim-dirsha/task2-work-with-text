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

/**
 * @author = Vadim Dirsha
 * @date = 08.11.2018
 */
public class Word extends AbstractTextUnit {
    private String value;

    public Word() {
        super("");
        this.value = "";
        this.leftSide = "";
        this.rightSide = "";
    }

    public Word(String data){
        super(data);
    }
    public Word(String value, String rightSide) {
        super("");
        this.value = value;
        this.rightSide = rightSide;
        this.leftSide = "";
    }

    public Word(String value, String leftSide, String rightSide) {
        super("");
        this.value = value;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toText() {
        return String.join("", leftSide, value, rightSide);
    }


    @Override
    public ITextUnit createTextUnit() {
        return null;
    }
}
