package com.word.counter.controller;

import com.word.counter.model.Response;
import com.word.counter.service.HttpService;
import com.word.counter.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class WordCountController {

    @Autowired
    HttpService httpService;
    @Autowired
    WordCounterService wordCounterService;

    @RequestMapping(value = "/counter", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response index(@RequestParam(name = "url") String url){

        Response response = new Response();

        response.setUrl(url);

        try {

            String content = httpService.read(url);
            HashMap<String, Integer> frequencies = wordCounterService.count(content);

            response.setFrequencies(frequencies);
        }
        catch (IOException ex){
            ;// log io exception here
        }
        catch (Exception ex){
            ;//log all other exceptions here
        }
        return response;
    }


}
