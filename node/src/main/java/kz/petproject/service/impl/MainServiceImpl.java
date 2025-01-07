package kz.petproject.service.impl;

import kz.petproject.dao.AppUserDAO;
import kz.petproject.entity.AppUser;
import kz.petproject.service.MainService;
import kz.petproject.service.ProducerService;
import kz.petproject.service.enums.ServiceCommand;
import kz.petproject.utils.CallbackQueryAnswer;
import kz.petproject.utils.ErrorAnswer;
import kz.petproject.utils.KeyboardMarkupType;
import kz.petproject.utils.TextCmdAnswer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import static kz.petproject.entity.UserState.BASIC_STATE;
import static kz.petproject.entity.UserState.WAIT_FOR_CONFIRMATION_STATE;
import static kz.petproject.service.enums.ServiceCommand.*;
import static kz.petproject.utils.buttonenums.CallbackQueryDataValue.*;

@Log4j
@RequiredArgsConstructor
@Service
public class MainServiceImpl implements MainService {
    private final AppUserDAO appUserDAO;
    private final ProducerService producerService;
    private final CallbackQueryAnswer callbackQueryAnswer;
    private final TextCmdAnswer textCmdAnswer;
    private final ErrorAnswer errorAnswer;
    private final KeyboardMarkupType keyboardMarkupType;

    @Override
    public void processTextMessage(Update update) {
        var appUser = findOrSaveAppUser(update);
        var userState = appUser.getUserState();
        var text = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        SendMessage output = null;

        if (isNotAllowToSendVipCmd(chatId, appUser)) {
            return;
        }

        var serviceCommand = ServiceCommand.fromValue(text);
        if (CANCEL.equals(serviceCommand)) {
            output = cancelProcess(chatId, appUser);
        } else if (BASIC_STATE.equals(userState)) {
            output = processServiceCommand(chatId, text);
        } else {
            log.debug("Unknown user state: " + userState);
            output = errorAnswer.sendError(chatId);
        }

        sendAnswer(output);
    }

    @Override
    public void processCallbackQueryMessage(Update update) {
        var appUser = findOrSaveAppUser(update);
        var chatId = update.getCallbackQuery().getMessage().getChatId();
        var callbackData = update.getCallbackQuery().getData();
        SendMessage output = null;

        if (isNotAllowToSendVipCmd(chatId, appUser)) {
            return;
        }

        if (callbackData.equals(ZNO_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoMenu(chatId);
        } else if (callbackData.equals(ZNO_PPO_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoPpoMenu(chatId);
        } else if (callbackData.equals(ZNO_SUBD_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoSubdMenu(chatId);
        } else if (callbackData.equals(ZNI_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniMenu(chatId);
        } else if (callbackData.equals(ZNI_PPO_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniPpoMenu(chatId, update);
        } else if (callbackData.equals(MAINMENU_BUTTON.getValue())) {
            output = textCmdAnswer.getMainMenu(chatId);
        } else if (callbackData.equals(ZNI_SUBD_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniSubdMenu(chatId);
        } else if (callbackData.equals(kE_BUTTON.getValue())) {
            output = callbackQueryAnswer.getKeMenu(chatId);
        } else if (callbackData.equals(FAQ_BUTTON3.getValue())) {
            output = callbackQueryAnswer.getFaqMenu3(chatId);
        } else if (callbackData.equals(FAQ_BUTTON4.getValue())) {
            output = callbackQueryAnswer.getFaqMenu4(chatId);
        } else if (callbackData.equals(FAQ_BUTTON5.getValue())) {
            output = callbackQueryAnswer.getFaqMenu5(chatId);
        } else if (callbackData.equals(FAQ_BUTTON6.getValue())) {
            output = callbackQueryAnswer.getFaqMenu6(chatId);
        } else if (callbackData.equals(FAQ_BUTTON7.getValue())) {
            output = callbackQueryAnswer.getFaqMenu7(chatId);
        } else if (callbackData.equals(FAQ_BUTTON8.getValue())) {
            output = callbackQueryAnswer.getFaqMenu8(chatId);
        } else if (callbackData.equals(FAQ_BUTTON9.getValue())) {
            output = callbackQueryAnswer.getFaqMenu9(chatId);
        } else {
            log.debug("Smth goes wrong in processCallbackQueryMessage");
            output = errorAnswer.sendError(chatId);
        }

        sendAnswer(output);
    }

    public boolean isNotAllowToSendVipCmd(Long chatId, AppUser appUser) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        var userState = appUser.getUserState();
        if (WAIT_FOR_CONFIRMATION_STATE.equals(userState)) {
            var error = "Вы подали заявку на подписку на Бот, ожидайте...";
            sendMessage.setText(error);
            sendAnswer(sendMessage);
            return true;
        }
        return false;
    }

    private void sendAnswer(SendMessage sendMessage) {
        sendMessage.setDisableWebPagePreview(true);
        sendMessage.setProtectContent(true);
        producerService.produceAnswer(sendMessage);
    }

    private SendMessage processServiceCommand(Long chatId, String cmd) {
        var serviceCommand = ServiceCommand.fromValue(cmd);
        if (HELP.equals(serviceCommand)) {
            return textCmdAnswer.helpCmdReceived(chatId);
        } else if (START.equals(serviceCommand)) {
            return textCmdAnswer.getMainMenu(chatId);
        } else {
            return errorAnswer.sendUnknownCmd(chatId);
        }
    }

    private SendMessage cancelProcess(Long chatId, AppUser appUser) {
        appUser.setUserState(null);
        appUserDAO.save(appUser);
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Команда отменена!");
        return sendMessage;
    }

    private AppUser findOrSaveAppUser(Update update) {
        User telegramUser = null;
        if (update.hasCallbackQuery()) {
            telegramUser = update.getCallbackQuery().getFrom();
        } else {
            telegramUser = update.getMessage().getFrom();
        }

        AppUser persistentAppUser = appUserDAO.findAppUserByTelegramUserId(telegramUser.getId());
        if (persistentAppUser == null) {
            AppUser transientAppUser = AppUser.builder()
                    .telegramUserId(telegramUser.getId())
                    .username(telegramUser.getUserName())
                    .firstName(telegramUser.getFirstName())
                    .lastName(telegramUser.getLastName())
                    .userState(WAIT_FOR_CONFIRMATION_STATE)
                    .build();
            return appUserDAO.save(transientAppUser);
        }
        return persistentAppUser;
    }
}