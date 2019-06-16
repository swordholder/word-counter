package com.word.counter.service;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class WordCounterService {

    public HashMap<String, Integer> count(String content) {

        if (StringUtils.isEmpty(content))
            return new HashMap<>();

        String[] split = content.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        Arrays.stream(split).forEach(item -> {
            if (!map.containsKey(item))
                map.put(item, 1);
            else
                map.put(item, map.get(item) + 1);
        });

        return map;
    }
}
