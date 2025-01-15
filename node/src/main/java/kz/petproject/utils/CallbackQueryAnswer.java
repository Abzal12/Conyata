package kz.petproject.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static kz.petproject.utils.buttonenums.CallbackQueryText.*;

@Slf4j
@Component
public class CallbackQueryAnswer {
    private final InlineKeyboardButtonType inlineKeyboardButtonType;

    public CallbackQueryAnswer(InlineKeyboardButtonType inlineKeyboardButtonType) {
        this.inlineKeyboardButtonType = inlineKeyboardButtonType;
    }

    public SendMessage getZnoMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNO_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZnoPpoButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getZnoSubdButton());

        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        buttonRow3.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);
        buttonRows.add(buttonRow3);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getZnoPpoMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNO_PPO_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZNOButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getZnoSubdMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNO_SUBD_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZNOButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getZniMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNI_TEXT.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniPlanButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getZniVneplanButton());

        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        buttonRow3.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);
        buttonRows.add(buttonRow3);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getZniPlanMenu(Long chatId, Update update) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNI_PLAN_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getZniVneplanMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(ZNI_VNEPLAN_TEXT.getText());
        sendMessage.setParseMode("HTML");

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getKeMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(KE_TEXT.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getVygruzkaMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(VYGRUZKA_TEXT.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getScriptMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(SCRIPT_TEXT.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getConRoleButton());

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(inlineKeyboardButtonType.getSpecConButton());

        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        buttonRow3.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);
        buttonRows.add(buttonRow2);
        buttonRows.add(buttonRow3);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getOtherInstructionsMenu(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(OTHER_INSTRUCTIONS_TEXT.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getMainMenuButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getFaqMenu6(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(FAQ_TEXT6.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getFaqMenu7(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(FAQ_TEXT7.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getFaqMenu8(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(FAQ_TEXT8.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }

    public SendMessage getFaqMenu9(Long chatId) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(FAQ_TEXT9.getText());

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttonRows = new ArrayList<>();

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(inlineKeyboardButtonType.getZniButton());

        buttonRows.add(buttonRow1);

        inlineMarkup.setKeyboard(buttonRows);
        sendMessage.setReplyMarkup(inlineMarkup);

        return sendMessage;
    }
}
