package kz.petproject.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

public interface AnswerConsumer {
    void consume(SendMessage sendMessage);
    void consumePhotoIds(ArrayList<String> photoIds);
    void consumeFileIds(ArrayList<String> fileId);
}
