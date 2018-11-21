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

import java.util.*;

/**
 * @author = Vadim Dirsha
 * @date = 21.11.2018
 */
public class Task6 implements ITaskSolver<List<String>> {
    private ITextUnit value;

    public Task6(ITextUnit value) {
        this.value = value;
    }

    private static List<String> getWords(ITextUnit value) {
        List<ITextUnit> list = new LinkedList<>();
        List<String> words = new LinkedList<>();
        if (value instanceof AbstractTextCollection) {
            list.addAll(((AbstractTextCollection) value).getCollection());
        } else {
            list.add(value);
        }

        Iterator<ITextUnit> iter = list.iterator();
        while (iter.hasNext()) {
            ITextUnit unit = iter.next();
            if (unit instanceof AbstractTextCollection) {
                list.addAll(((AbstractTextCollection) unit).getCollection());
                list.remove(unit);
                iter = list.iterator();
            }
        }
        for (ITextUnit unit : list) {
            if (unit instanceof AbstractTextUnit) {
                words.add(((AbstractTextUnit) unit).getWord());
            }
        }
        return words;
    }

    @Override
    public List<String> solve() {
        List<String> words = getWords(value);

        Map<Character, List<String>> map = new HashMap<>();
        Set<Character> keys = new HashSet<>();

        words.forEach(unit -> keys.add(unit.charAt(0)));
        keys.forEach(unit -> map.put(unit, new ArrayList<>()));

        words.forEach(unit -> map.get(unit.charAt(0)).add(unit));
        map.forEach((k, v) -> v.sort(Comparator.comparing(String::toString)));

        ArrayList<Character> sortKeys = new ArrayList<>(keys);
        sortKeys.sort(Comparator.comparing(Character::charValue));

        List<String> result = new ArrayList<>();
        sortKeys.forEach(u -> result.add(String.join(" ", map.get(u))));

        return result;

//        return map.values()
//                .stream()
//                .map(v -> {
//                    StringBuilder temp = new StringBuilder();
//                    v.forEach(unit -> temp.append(unit).append(" "));
//                    return temp.toString().substring(0, temp.toString().length() - 1);
//                }).collect(Collectors.toList());

    }
}
