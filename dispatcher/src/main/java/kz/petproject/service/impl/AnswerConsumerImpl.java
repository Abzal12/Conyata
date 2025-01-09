package kz.petproject.service.impl;

import kz.petproject.controller.UpdateController;
import kz.petproject.service.AnswerConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class AnswerConsumerImpl implements AnswerConsumer {

    private final UpdateController updateController;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.answer-message}")
    public void consume(SendMessage sendMessage) {
        updateController.setView(sendMessage);
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.answer-photo-id}")
    public void consumePhotoIds(ArrayList<String> photoIds) {
        if (!photoIds.isEmpty()) {
            String chatId = photoIds.get(0);
            for (int i = 1; i < photoIds.size(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted: " + e.getMessage());
                }
                updateController.setPhotoView(chatId, photoIds.get(i));
            }
        }
    }
}