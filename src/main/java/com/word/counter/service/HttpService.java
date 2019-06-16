package com.word.counter.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class HttpService {

    public String read(String urlText) throws IOException {

        URL url = new URL(urlText);
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));

        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = read.readLine()) != null)
            stringBuilder.append(line.toLowerCase());

        read.close();
        return stringBuilder.toString();
    }
}
