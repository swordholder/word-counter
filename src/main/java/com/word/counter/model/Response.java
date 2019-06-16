package com.word.counter.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Response {

    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private HashMap<String,Integer> frequencies;
}
