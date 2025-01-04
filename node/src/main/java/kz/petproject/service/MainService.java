package kz.petproject.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface MainService {
    void processTextMessage(Update update);
    void processCallbackQueryMessage(Update update);
}
