package info.mahfuz.kafka.resource;

import info.mahfuz.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class PublishController {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private final String TOPIC = "test";

    @GetMapping("/publish/{name}")
    public String publishName(@PathVariable final String name) {
        User user = new User(1, name);
        kafkaTemplate.send(TOPIC, user);
        return "Published successfully";
    }
}
