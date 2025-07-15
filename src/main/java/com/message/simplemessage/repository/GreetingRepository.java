package com.message.simplemessage.repository;

import com.message.simplemessage.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface GreetingRepository extends JpaRepository<GreetingEntity, String> {

    Optional<GreetingEntity> findByLanguage(String language);

    @Query("SELECT g FROM GreetingEntity g")
    List<GreetingEntity> findAll();
}
