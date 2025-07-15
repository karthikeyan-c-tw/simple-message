package com.message.simplemessage.service;

import java.util.List;

public interface GreetingService {
    String getMessage(String language);

    List<String> getAllLanguages();
}
