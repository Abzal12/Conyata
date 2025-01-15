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
    VYGRUZKA_BUTTON("vygruzka_button"),
    SCRIPT_BUTTON("script_button"),
    SCRIPT_CON_ROLE_BUTTON("script_con_role_button"),
    SCRIPT_SPECCON_ROLE_BUTTON("script_speccon_role_button"),
    OTHER_INSTRUCTIONS_BUTTON("other_instructions_button"),
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
