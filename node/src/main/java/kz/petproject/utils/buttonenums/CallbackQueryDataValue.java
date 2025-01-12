package kz.petproject.utils.buttonenums;

public enum CallbackQueryDataValue {
    ZNO_BUTTON("zno_button"),
    ZNO_PLAN_BUTTON("zno_ppo_button"),
    ZNO_SUBD_BUTTON("zno_subd_button"),
    ZNI_BUTTON("zni_button"),
    ZNI_PLAN_BUTTON("zni_plan_button"),
    MAINMENU_BUTTON("main_menu"),

    ZNI_VNEPLAN_BUTTON("zni_vneplan_button"),
    kE_BUTTON("ke_button"),
    VYGRUZKA_BUTTON("VYGRUZKA_BUTTON"),
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
