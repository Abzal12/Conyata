package kz.petproject.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static kz.petproject.utils.buttonenums.CallbackQueryText.MAINMENU_TEXT;

@Component
public class TextCmdAnswer {
    private final InlineKeyboardButtonType inlineKeyboardButtonType;

    public TextCmdAnswer(InlineKeyboardButtonType inlineKeyboardButtonType) {
        this.inlineKeyboardButtonType = inlineKeyboardButtonType;
    }

    public SendMessage helpCmdReceived(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Список доступных команд:\n"
                + "/start - вывести главное меню");
        return sendMessage;
    }

    public SendMessage getMainMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(MAINMENU_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZNOButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getZniButton());

        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        buttonRow3.add(inlineKeyboardButtonType.getVygruzkaButton());

        List<InlineKeyboardButton> buttonRow4 = new ArrayList<>();
        buttonRow4.add(inlineKeyboardButtonType.getKeButton());

        List<InlineKeyboardButton> buttonRow5 = new ArrayList<>();
        buttonRow5.add(inlineKeyboardButtonType.getScriptButton());

        List<InlineKeyboardButton> buttonRow6 = new ArrayList<>();
        buttonRow6.add(inlineKeyboardButtonType.getOtherInstructionsButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);
        buttonRows.add(buttonRow3);
        buttonRows.add(buttonRow4);
        buttonRows.add(buttonRow5);
        buttonRows.add(buttonRow6);

        markupInLine.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(markupInLine);

        return sendMessage;
    }
}
