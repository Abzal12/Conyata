package kz.petproject.utils.buttonenums;

import com.vdurmont.emoji.EmojiParser;

public enum CallbackQueryButtonLabel {

    ZNO_BUTTON_LABEL(EmojiParser.parseToUnicode("ЗНО")),
    ZNO_PPO_BUTTON_LABEL(EmojiParser.parseToUnicode("ЗНО ППО")),
    ZNO_SUBD_BUTTON_LABEL(EmojiParser.parseToUnicode("ЗНО СУБД")),
    ZNI_BUTTON_LABEL(EmojiParser.parseToUnicode("ЗНИ")),
    ZNI_PLAN_LABEL(EmojiParser.parseToUnicode(" ЗНИ плановое")),
    MAINMENU_BUTTON_LABEL(EmojiParser.parseToUnicode("В ГЛАВНОЕ МЕНЮ")),
    ZNI_VNEPLAN_BUTTON_LABEL("ЗНИ внеплан"),
    KE_BUTTON_LABEL("КЕ"),
    VYGRUZKA_BUTTON_LABEL("Выгрузка-select"),

    SCRIPT_BUTTON_LABEL("Скрипты для СУБД"),
    SCRIPT_CON_ROLE_BUTTON_LABEL("Скрипт на роль админа АРМ ЦОН"),
    SCRIPT_SPECCON_ROLE_BUTTON_LABEL("Скрипт на роли АРМ Спец ЦОН"),
    OTHER_INSTRUCTIONS_BUTTON_LABEL("Другие инструкции"),
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
