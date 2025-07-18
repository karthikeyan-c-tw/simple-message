package com.message.simplemessage.controller;

import java.util.List;
import java.util.Map;

import com.message.simplemessage.service.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simple-message")
@CrossOrigin(origins = "${webapp.cors.allowed-origin}")
@Slf4j
public class MessageController {

    @Autowired
    private final GreetingService greetingService;

    @GetMapping("/message/{language}")
    public Map<String, String> getMessage(@PathVariable("language") String language) {
        log.info("Getting message for language {}", language);
        return Map.of("Message", greetingService.getMessage(language));
    }

    @GetMapping("/languages")
    public List<String> getLanguages() {
        log.info("Getting All languages");
        return greetingService.getAllLanguages();
    }
}
