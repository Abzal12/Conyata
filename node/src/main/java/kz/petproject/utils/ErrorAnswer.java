package kz.petproject.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class ErrorAnswer {
    public SendMessage sendError(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Неизвестная ошибка: введите /cancel и попробуйте снова");
        return sendMessage;
    }

    public SendMessage sendUnknownCmd(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Неизвестная команда! Чтобы посмотреть список доступных команд введите /help");
        return sendMessage;
    }
}
