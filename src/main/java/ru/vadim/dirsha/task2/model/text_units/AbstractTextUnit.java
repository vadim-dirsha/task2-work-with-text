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
public abstract class AbstractTextUnit implements ITextUnit, ITextUnitCreator {

    protected String data;
    protected String leftSide;
    protected String rightSide;
    //TODO не клеится, нужно поле в котором будут хранится отпаршенные значения.... Object?

    public AbstractTextUnit(String data){
        this.data = data;
    }

    @Override
    public String getLeftSide() {
        return leftSide;
    }

    @Override
    public String getRightSide() {
        return rightSide;
    }

    public void paarseCollection(){
        
    }
}
