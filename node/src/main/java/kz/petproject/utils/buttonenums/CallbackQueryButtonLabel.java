package kz.petproject.utils.buttonenums;

import com.vdurmont.emoji.EmojiParser;

public enum CallbackQueryButtonLabel {

    ZNO_BUTTON_LABEL(EmojiParser.parseToUnicode(":robot_face: ЗНО :robot_face:")),
    ZNO_PPO_BUTTON_LABEL(EmojiParser.parseToUnicode(":moneybag: ЗНО ППО :moneybag:")),
    ZNO_SUBD_BUTTON_LABEL(EmojiParser.parseToUnicode(":gift: ЗНО СУБД :gift:")),
    ZNI_BUTTON_LABEL(EmojiParser.parseToUnicode(":bulb: ЗНИ :bulb:")),
    ZNI_PPO_LABEL(EmojiParser.parseToUnicode(":white_check_mark: ЗНИ ППО :white_check_mark:")),
    MAINMENU_BUTTON_LABEL(EmojiParser.parseToUnicode(":recycle: В ГЛАВНОЕ МЕНЮ :recycle:")),

    ZNI_SUBD_BUTTON_LABEL("\uD83D\uDC49ЗНИ СУБД"),
    KE_BUTTON_LABEL("\uD83D\uDC49КЕ"),
    FAQ_BUTTON_LABEL3("\uD83D\uDC49Сколько я смогу зарабатывать?"),
    FAQ_BUTTON_LABEL4("\uD83D\uDC49Насколько это безопасно?"),
    FAQ_BUTTON_LABEL5("\uD83D\uDC49Как часто я могу выводить прибыль?"),
    FAQ_BUTTON_LABEL6("\uD83D\uDC49Как работает партнерская программа?"),
    FAQ_BUTTON_LABEL7("\uD83D\uDC49Что делать, если возникнут вопросы или трудности?"),
    FAQ_BUTTON_LABEL8("\uD83D\uDC49Как начать работу с роботом?"),
    FAQ_BUTTON_LABEL9("\uD83D\uDC49Есть ли риски в использовании робота?");

    private final String label;

    private CallbackQueryButtonLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
