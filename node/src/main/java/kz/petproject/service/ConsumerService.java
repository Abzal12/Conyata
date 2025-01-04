package kz.petproject.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ConsumerService {
    void consumeTextMessageUpdates(Update update);
    void consumeCallbackQueryMessageUpdates(Update update);
}
