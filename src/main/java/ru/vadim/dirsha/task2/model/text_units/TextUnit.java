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
public class TextUnit implements ITextUnit {

    protected String leftSide;
    protected String rightSide;
    private String value;

    public TextUnit() {
        this.value = "";
        this.leftSide = "";
        this.rightSide = "";
    }

    public TextUnit(String value, String rightSide) {
        this.value = value;
        this.rightSide = rightSide;
        this.leftSide = "";
    }

    public TextUnit(String value, String leftSide, String rightSide) {
        this.value = value;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public String getValue() throws IllegalAccessException {
        //TODO ye it is
        return value;
    }


    //TODO подумать над тем нужно ли это в интерфейсе как и нужно ли там вообще наследование от этого класса, возможно просто нужен интерфейс с одним туТекст,
    //один интерфейс, один обстрактный базовый класс наподобии textUnit, один класс типа коллекция, и куча лифов, все они наслед от базового абстрактного текст юнита
    @Override
    public String getLeftSide() {
        return leftSide;
    }

    @Override
    public String getRightSide() {
        return rightSide;
    }

    @Override
    public String toText() {
        return String.join("", leftSide, value, rightSide);
    }
}
