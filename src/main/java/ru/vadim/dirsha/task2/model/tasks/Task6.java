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
package ru.vadim.dirsha.task2.model.tasks;

import ru.vadim.dirsha.task2.model.text.default_units.AbstractTextCollection;
import ru.vadim.dirsha.task2.model.text.default_units.AbstractTextUnit;
import ru.vadim.dirsha.task2.model.text.default_units.ITextUnit;

import java.util.ArrayList;

/**
 * @author = Vadim Dirsha
 * @date = 21.11.2018
 */
public class Task6 implements ITaskSolver<ArrayList<String>> {
    private ITextUnit value;

    public Task6(ITextUnit value) {
        this.value = value;
    }

    @Override
    public ArrayList<String> solve() {
        return new ArrayList<>();
    }
}
