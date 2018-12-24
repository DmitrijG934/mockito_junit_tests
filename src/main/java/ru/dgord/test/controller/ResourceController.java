package ru.dgord.test.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dgord.test.domain.Message;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @GetMapping
    public String getResources() {
        return "It\'s simple resource!";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message getJson() {
        return new Message(1L, "Hello, world!");
    }


}
