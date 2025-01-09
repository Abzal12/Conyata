package kz.petproject.configuration;

import lombok.Getter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.queues.text-message-update}")
    private String textMessageUpdateQueue;

    @Value("${spring.rabbitmq.queues.callback-message-update}")
    private String callbackQueryUpdateQueue;

    @Value("${spring.rabbitmq.queues.answer-message}")
    private String answerMessageQueue;

    @Value("${spring.rabbitmq.queues.answer-photo-id}")
    private String answerPhotoIdQueue;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue textMessageQueue() {
        return new Queue(textMessageUpdateQueue);
    }

    @Bean
    public Queue callbackQueryQueue() {
        return new Queue(callbackQueryUpdateQueue);
    }

    @Bean
    public Queue answerMessageQueue() {
        return new Queue(answerMessageQueue);
    }

    @Bean
    public Queue answerPhotoIdQueue() {
        return new Queue(answerPhotoIdQueue);
    }
}
