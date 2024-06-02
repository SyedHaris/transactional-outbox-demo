package com.example.microservices.service;

import com.example.microservices.dto.UserRequestDto;
import com.example.microservices.entity.User;
import com.example.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    public UserService(UserRepository userRepository, KafkaTemplate<String, Object> kafkaTemplate, @Value("${kafka.topic.user}") String topic) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Transactional
    public User createUser(UserRequestDto userRequestDto) {
        User user = userRequestDto.mapToUserEntity();

        user = userRepository.save(user);

        kafkaTemplate.send(topic, user);

        return user;
    }

}
