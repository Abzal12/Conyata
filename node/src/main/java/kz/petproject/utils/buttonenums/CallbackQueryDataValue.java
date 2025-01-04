package kz.petproject.utils.buttonenums;

public enum CallbackQueryDataValue {
    ZNO_BUTTON("zno_button"),
    ZNO_PPO_BUTTON("zno_ppo_button"),
    ZNO_SUBD_BUTTON("zno_subd_button"),
    ZNI_BUTTON("zni_button"),
    ZNI_PPO_BUTTON("zni_ppo_button"),
    MAINMENU_BUTTON("main_menu"),

    ZNI_SUBD_BUTTON("zni_subd_button1"),
    FAQ_BUTTON2("faq_button2"),
    FAQ_BUTTON3("faq_button3"),
    FAQ_BUTTON4("faq_button4"),
    FAQ_BUTTON5("faq_button5"),
    FAQ_BUTTON6("faq_button6"),
    FAQ_BUTTON7("faq_button7"),
    FAQ_BUTTON8("faq_button8"),
    FAQ_BUTTON9("faq_button9");

    private final String value;

    private CallbackQueryDataValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
