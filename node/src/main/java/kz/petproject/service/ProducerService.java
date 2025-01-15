package kz.petproject.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;

public interface ProducerService {
    void produceAnswer(SendMessage sendMessage);
    void producePhotoId(ArrayList<String> photoIds);
    void produceFileId(ArrayList<String> fileId);
}
