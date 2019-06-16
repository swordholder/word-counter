package com.word.counter;

import com.word.counter.service.WordCounterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordcounterApplicationTests {

    @Autowired
    WordCounterService wordCounterService;

    @Test
    public void testWordCounter() {

        String content = "Lorem ipsum sit amet solor amet";

        HashMap<String, Integer> map = wordCounterService.count(content);

        int count = map.get("amet");
        Assert.assertEquals(count, 2);

        count = map.get("Lorem");
        Assert.assertEquals(count, 1);
    }

}
