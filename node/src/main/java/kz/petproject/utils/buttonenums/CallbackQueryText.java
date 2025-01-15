package kz.petproject.utils.buttonenums;

public enum CallbackQueryText {

    MAINMENU_TEXT("Инструкции:"),

    ZNO_TEXT("В части ППО или СУБД?"),

    ZNO_PPO_TEXT("ЗНО ППО:\n\n" +
            "1) sd.nitec.kz\n\n" +
            "2) Управление запросами\n\n" +
            "3) (Запрос на обслуживание сопровождаемых ИС) Создать новый запрос\n\n" +
            "3.1) Свойства\n" +
            "   Организация: <b>NITEC</b> (по умолчанию)\n" +
            "   Информационная система: \n<b>Интегрированная информационная система Центров обслуживания населения</b>\n" +
            "   Информационная система->Куратор проекта: \n<b>Салтанат Оразова</b> (по умолчанию)\n" +
            "   Реестр ЗНО: <b>Обновление услуг</b>\n" +
            "   Категория запроса: <b>Администрирование ППО</b> (по умолчанию)\n" +
            "   Статус: <b>Новый</b> (по умолчанию)\n" +
            "   Описание: \n<b>Прошу провести ЗНО в части ППО</b> (в Арм ЦОН или Арм СЦОН это нужно уточнять)\n\n" +
            "3.2) КЕ\n" +
            "   ДОБАВИТЬ ОБЪЕКТ ФУНКЦИОНАЛЬНЫЕ КЕ\n" +
            "   ПОИСК: <b>Виртуальная машина</b>\n" +
            "   нажать на значок \"<b>+</b>\" (т.е. Добавить критерий)\n" +
            "   выбрать <b>IP-адрес</b>\n" +
            "   отметить данные значения в поле IP-адрес:\n" +
            "   нажать на значок <b>Поиск</b>\n" +
            "   отметить все найденные IP-адреса виртуальных машин\n" +
            "   нажать на кнопку <b>Добавить</b> (для добавления IP-адресов)\n" +
            "   нажать на кнопку <b>Создать</b> (для создания зно)\n\n" +
            "3.3) Вложение\n" +
            "Вложить саму сборку (если сборка до 50 мб) либо скрин пути на сборку (если сборка превышает 50 мб)\n\n" +
            "4) Ожидать согласование руководителя проекта\n\n" +
            "5) После согласования, написать админам ППО чтобы провели работы по ЗНО\n\n" +
            "Советы:\n" +
            "Чем раньше вы предупредите о ЗНО ответственных за проведение ЗНО и за возможные последующие последствия (особенно заказчика (нужно предупреждать о необходимости дроп кеша при необходимости), 2-линию), тем меньше будет у вас проблем по ЗНО после его проведении\n"),

    ZNO_SUBD_TEXT("ЗНО СУБД:\\n\\n" +
            "1) sd.nitec.kz\n\n" +
            "2) Управление запросами\n\n" +
            "3) (Запрос на обслуживание сопровождаемых ИС) Создать новый запрос\n" +
            "3.1) Свойства\n" +
            "   Организация: <b>NITEC</b> (по умолчанию)\n" +
            "   Информационная система: \n<b>Интегрированная информационная система Центров обслуживания населения</b>\n" +
            "   Информационная система->Куратор проекта: \n<b>Салтанат Оразова</b> (по умолчанию)\n" +
            "   Реестр ЗНО: <b>Выполнение SQL запросов в БД (insert, update)</b>\n" +
            "   Категория запроса: <b>Администрирование СУБД</b> (по умолчанию)\n" +
            "   Статус: <b>Новый</b> (по умолчанию)\n" +
            "   Описание: \n<b>Прошу провести ЗНО в части БД</b> (в Арм ЦОН или Арм СЦОН это нужно уточнять)\n" +
            "3.2) КЕ\n" +
            "   ДОБАВИТЬ ОБЪЕКТ ФУНКЦИОНАЛЬНЫЕ КЕ\n" +
            "   ПОИСК: <b>Виртуальная машина</b>\n" +
            "   нажать на значок \"<b>+</b>\" (т.е. Добавить критерий)\n" +
            "   выбрать <b>IP-адрес</b>\n" +
            "   отметить данные значения в поле IP-адрес:\n" +
            "   нажать на значок <b>Поиск</b>\n" +
            "   отметить все найденные IP-адреса виртуальных машин\n" +
            "   нажать на кнопку <b>Добавить</b> (для добавления IP-адресов)\n" +
            "   нажать на кнопку <b>Создать</b> (для создания зно)\n" +
            "3.3) Вложение\n" +
            "Вложить саму сборку (если сборка до 50 мб) либо скрин пути на сборку (если сборка превышает 50 мб)\n" +
            "4) Ожидать согласование руководителя проекта\n" +
            "5) После согласования, написать админам ППО чтобы провели работы по ЗНО\n\n" +
            "Советы:\n" +
            "Чем раньше вы предупредите о ЗНО ответственных за проведение ЗНО и за возможные последующие последствия (особенно заказчика (нужно предупреждать о необходимости дроп кеша при необходимости), 2-линию), тем меньше будет у вас проблем по ЗНО после его проведении\n"),

    ZNI_TEXT("В части ППО или СУБД?"),

    ZNI_PLAN_TEXT("ЗНИ плановое"),

    ZNI_VNEPLAN_TEXT("ЗНИ внеплан"),

    KE_TEXT("ППО ЦОН:\n" +
            "1) 130.41\n" +
            "2) 130.42\n" +
            "3) 130.43\n" +
            "4) 130.44\n" +
            "5) 130.45\n" +
            "6) 130.46\n" +
            "7) 130.47\n" +
            "8) 130.56\n" +
            "\n" +
            "ППО СЦОН:\n" +
            "1) 130.37\n" +
            "2) 130.38\n" +
            "\n" +
            "БД ЦОН:\n" +
            "1) 130.120\n" +
            "2) 130.244\n" +
            "\n" +
            "БД СЦОН\n" +
            "1) 130.121\n" +
            "2) 130.245\n" +
            "\n" +
            "ШИНА\n" +
            "1) 130.82\n" +
            "\n" +
            "Карта Мониторинга:\n" +
            "1) 130.77\n" +
            "2) 130.78\n" +
            "\n" +
            "АРМ ГО:\n" +
            "1) 64.82"),

    VYGRUZKA_TEXT("Инструкция по выгрузке"),

    SCRIPT_TEXT("Скрипты для СУБД:"),

    OTHER_INSTRUCTIONS_TEXT("Другие инструкции (добавлю)"),

    FAQ_TEXT6("\uD83D\uDC49 Как работает партнерская программа?\n" +
            "\n" +
            "❓ Какие преимущества даёт партнерская программа HASH7?\n" +
            "\n" +
            "✅ Партнерская программа позволяет вам получать доход не только от торговли, но и за привлечение новых пользователей. За продажу лицензий и торговлю ваших рефералов вы можете зарабатывать до 90%% от стоимости лицензий и до 18%% от прибыли с их торговли.\n" +
            "\n" +
            "\uD83D\uDD25 Чем активнее ваша команда, тем больше бонусов и доходов вы сможете получать! У вас есть шанс выйти на доход более 10 000 USDT всего за 6 месяцев."),

    FAQ_TEXT7("\uD83D\uDC49 Что делать, если возникнут вопросы или трудности?\n" +
            "\n" +
            "❓ Куда обращаться за помощью, если я столкнусь с проблемами?\n" +
            "\n" +
            "✅ У нас есть команда поддержки, которая всегда готова помочь вам на любом этапе работы с роботом.\n" +
            "\n" +
            "\uD83D\uDC49 Вы можете обратиться к своему наставнику, написать в наш Telegram-канал или воспользоваться подробными инструкциями в разделе FAQ.\n" +
            "\n" +
            "\uD83D\uDCA1 Также доступны обучающие видео и статьи для решения большинства вопросов!"),

    FAQ_TEXT8("\uD83D\uDC49 Как начать работу с роботом?\n" +
            "\n" +
            "❓ Как быстро подключить робота и начать зарабатывать?\n" +
            "\n" +
            "✅ Чтобы начать, выполните следующие шаги:" +
            "\n" +
            "1. Зарегистрируйтесь на бирже ByBit (используйте реферальный код: GKJZVJ). (https://www.bybit.com/invite?ref=GKJZVJ)\n" +
            "2. Пройдите KYC верификацию на бирже для повышения безопасности.\n" +
            "3. Установите Google Аутентификатор для дополнительной защиты.\n" +
            "Устанавливаете через AppStore или PlayMarket.\n" +
            "4. Купите USDT через P2P и переведите средства в спотовый кошелёк.\n" +
            "5. Перейдите в Единый торговый аккаунт на ByBit.\n" +
            "6. Зарегистрируйтесь в Hash7 \uD83D\uDD17ссылка (https://web.hash7.cloud/invite?ref=8qif60) и введите реферальный код 8qif60.\n" +
            "7. Скачайте приложение Hash7 для iOS через TestFlight(Сперва (https://apps.apple.com/kz/app/testflight/id899247664) нужно скачать TestFlight (https://apps.apple.com/kz/app/testflight/id899247664) с AppStore, после по ссылку нужно скачать Hash7) (https://testflight.apple.com/join/yZg3crZM) или на Android (https://play.google.com/store/apps/details?id=io.hash7.app&pcampaignid=web_share) через Play Market. (https://play.google.com/store/apps/details?id=io.hash7.app&pcampaignid=web_share)\n" +
            "8. Пополните бот на $150-$160 через сеть TRC20.\n" +
            "9. Активируйте бота за $140. Оставшиеся средства пойдут на оплату комиссии (20%% от прибыли).\n" +
            "10. Подключите API-ключи ByBit к Hash7 для автоматизации торговли.\n" +
            "11. Настройте стратегию, выберите монеты и запустите бота.\n" +
            "12. После активации бота, напишите мне в личку. Я вам отправлю стратегию.\n" +
            "\n" +
            "\uD83D\uDD25 Важно: Все средства находятся на вашем личном счёте на бирже ByBit, и вы всегда сможете вывести их в любой момент.\n" +
            "\n" +
            "\uD83D\uDC49 Весь процесс занимает всего 30-40 минут, и уже скоро вы увидите первые результаты!"),

    FAQ_TEXT9("\uD83D\uDC49 Есть ли риски в использовании робота?\n" +
            "\n" +
            "❓ Могу ли я потерять деньги при использовании робота?\n" +
            "\n" +
            "✅ Торговый робот HASH7 никогда не закрывает сделку в минус. Если рынок начинает падать, бот не продает активы в убыток, а удерживает их в спотовом кошельке до тех пор, пока рынок снова не начнет расти.\n" +
            "\n" +
            "\uD83D\uDC49 Таким образом, ваши активы остаются в безопасности, и вы можете дождаться восстановления рынка без риска продать по низким ценам.\n" +
            "\n" +
            "\uD83D\uDD25 Также вы можете настроить стратегию так, чтобы бот продолжал торговать на “низах” рынка. Это позволит вам закупать активы по более низким ценам, что повысит ваш потенциал прибыли, когда рынок начнёт расти.\n" +
            "\n" +
            "⚠\uFE0F Несмотря на это, важно помнить, что крипторынок всегда подвержен волатильности. Мы рекомендуем использовать только те средства, которые вы готовы оставить на длительный срок в случае падения рынка.");

    private final String text;

    private CallbackQueryText(String text) {
        this.text = text;
    }

    public String getText(Object... args) {
        return String.format(text, args);
    }
}
