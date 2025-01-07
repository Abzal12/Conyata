package kz.petproject.utils;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static kz.petproject.utils.buttonenums.CallbackQueryButtonLabel.*;
import static kz.petproject.utils.buttonenums.CallbackQueryDataValue.*;

@Component
public class InlineKeyboardButtonType {

    public InlineKeyboardButton getZNOButton() {
        var znoButton = new InlineKeyboardButton();
        znoButton.setText(EmojiParser.parseToUnicode(ZNO_BUTTON_LABEL.getLabel()));
        znoButton.setCallbackData(ZNO_BUTTON.getValue());
        return znoButton;
    }

    public InlineKeyboardButton getZnoPpoButton() {
        var znoPpoButton = new InlineKeyboardButton();
        znoPpoButton.setText(EmojiParser.parseToUnicode(ZNO_PPO_BUTTON_LABEL.getLabel()));
        znoPpoButton.setCallbackData(ZNO_PPO_BUTTON.getValue());
        return znoPpoButton;
    }

    public InlineKeyboardButton getZnoSubdButton() {
        var znoSubdButton = new InlineKeyboardButton();
        znoSubdButton.setText(EmojiParser.parseToUnicode(ZNO_SUBD_BUTTON_LABEL.getLabel()));
        znoSubdButton.setCallbackData(ZNO_SUBD_BUTTON.getValue());
        return znoSubdButton;
    }

    public InlineKeyboardButton getZniButton() {
        var zniButton = new InlineKeyboardButton();
        zniButton.setText(EmojiParser.parseToUnicode(ZNI_BUTTON_LABEL.getLabel()));
        zniButton.setCallbackData(ZNI_BUTTON.getValue());
        return zniButton;
    }

    public InlineKeyboardButton getZniPpoButton() {
        var zniPpoButton = new InlineKeyboardButton();
        zniPpoButton.setText(EmojiParser.parseToUnicode(ZNI_PPO_LABEL.getLabel()));
        zniPpoButton.setCallbackData(ZNI_PPO_BUTTON.getValue());
        return zniPpoButton;
    }

    public InlineKeyboardButton getMainMenuButton() {
        var mainMenuButton = new InlineKeyboardButton();
        mainMenuButton.setText(EmojiParser.parseToUnicode(MAINMENU_BUTTON_LABEL.getLabel()));
        mainMenuButton.setCallbackData(MAINMENU_BUTTON.getValue());
        return mainMenuButton;
    }

    public InlineKeyboardButton getZniSubdButton() {
        var zniSubdButton = new InlineKeyboardButton();
        zniSubdButton.setText(EmojiParser.parseToUnicode(ZNI_SUBD_BUTTON_LABEL.getLabel()));
        zniSubdButton.setCallbackData(ZNI_SUBD_BUTTON.getValue());
        return zniSubdButton;
    }

    public InlineKeyboardButton getKeButton() {
        var keButton = new InlineKeyboardButton();
        keButton.setText(EmojiParser.parseToUnicode(KE_BUTTON_LABEL.getLabel()));
        keButton.setCallbackData(kE_BUTTON.getValue());
        return keButton;
    }

    public InlineKeyboardButton getFaqButton3() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL3.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON3.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton4() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL4.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON4.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton5() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL5.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON5.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton6() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL6.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON6.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton7() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL7.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON7.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton8() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL8.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON8.getValue());
        return faqButton;
    }

    public InlineKeyboardButton getFaqButton9() {
        var faqButton = new InlineKeyboardButton();
        faqButton.setText(EmojiParser.parseToUnicode(FAQ_BUTTON_LABEL9.getLabel()));
        faqButton.setCallbackData(FAQ_BUTTON9.getValue());
        return faqButton;
    }
}

