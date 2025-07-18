package com.message.simplemessage.service;

import com.message.simplemessage.entity.GreetingEntity;
import com.message.simplemessage.repository.GreetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getMessage(String language) {
        return greetingRepository.findByLanguage(language)
                .map(GreetingEntity::getMessage)
                .orElse("Hello");
    }

    @Override
    public List<String> getAllLanguages() {
        return greetingRepository.findAll().stream().map(GreetingEntity::getLanguage).toList();
    }
}
