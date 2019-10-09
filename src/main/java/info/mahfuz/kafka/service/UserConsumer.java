package info.mahfuz.kafka.service;

import info.mahfuz.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "test", containerFactory = "userKafkaListenerFactory")
    public void receiveUser(User user) {
        System.out.println(user);
    }
}
