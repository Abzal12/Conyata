package kz.petproject.service.impl;

import kz.petproject.dao.AppUserDAO;
import kz.petproject.entity.AppUser;
import kz.petproject.service.MainService;
import kz.petproject.service.ProducerService;
import kz.petproject.service.enums.ServiceCommand;
import kz.petproject.utils.CallbackQueryAnswer;
import kz.petproject.utils.ErrorAnswer;
import kz.petproject.utils.TextCmdAnswer;
import kz.petproject.utils.constant_ids.FileIds;
import kz.petproject.utils.constant_ids.PhotoIds;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

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
    private final PhotoIds photoIdConstants;
    private final FileIds fileIdConstants;

    @Override
    public void processTextMessage(Update update) {
        var appUser = findOrSaveAppUser(update);
        var userState = appUser.getUserState();
        var text = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        SendMessage output;

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
        SendMessage output;
        SendMessage sendText = null;
        ArrayList<String> photoIds = new ArrayList<>(Arrays.asList(String.valueOf(chatId)));
        ArrayList<String> fileId = new ArrayList<>(Arrays.asList(String.valueOf(chatId)));
        ;

        if (isNotAllowToSendVipCmd(chatId, appUser)) {
            return;
        }

        if (callbackData.equals(ZNO_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoMenu(chatId);
        } else if (callbackData.equals(ZNO_PLAN_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoPpoMenu(chatId);
            photoIds.add(String.valueOf(chatId));
            photoIds.addAll(photoIdConstants.getZnoPpoPhotoIds());
        } else if (callbackData.equals(ZNO_SUBD_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZnoSubdMenu(chatId);
            photoIds.addAll(photoIdConstants.getZnoSubdPhotoIds());
        } else if (callbackData.equals(ZNI_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniMenu(chatId);
        } else if (callbackData.equals(ZNI_PLAN_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniPlanMenu(chatId, update);
            photoIds.addAll(photoIdConstants.getZniPlanPhotoIds());
        } else if (callbackData.equals(MAINMENU_BUTTON.getValue())) {
            output = textCmdAnswer.getMainMenu(chatId);
        } else if (callbackData.equals(ZNI_VNEPLAN_BUTTON.getValue())) {
            output = callbackQueryAnswer.getZniVneplanMenu(chatId);
            photoIds.addAll(photoIdConstants.getZniVneplanPhotoIds());

            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = today.format(formatter);
            sendText = new SendMessage();
            sendText.setChatId(chatId);
            sendText.setText(
                    "Заготовленный текст для СЗ:\n\n" +
                            "Департамент Е-лицензирования и интегрированной информационной системы «Центр обслуживания " +
                            "населения» просит согласовать проведение внепланового обновления ИИС ЦОН в 21:00 часов " + formattedDate +
                            " года на основании письма от НАО «Государственная корпорация «Правительство для граждан»"
            );

        } else if (callbackData.equals(kE_BUTTON.getValue())) {
            output = callbackQueryAnswer.getKeMenu(chatId);
        } else if (callbackData.equals(VYGRUZKA_BUTTON.getValue())) {
            output = callbackQueryAnswer.getVygruzkaMenu(chatId);
            photoIds.addAll(photoIdConstants.getVygruzkaPhotoIds());
        } else if (callbackData.equals(SCRIPT_BUTTON.getValue())) {
            output = callbackQueryAnswer.getScriptMenu(chatId);
        } else if (callbackData.equals(SCRIPT_CON_ROLE_BUTTON.getValue())) {
            output = callbackQueryAnswer.getScriptMenu(chatId);
            fileId.add(fileIdConstants.getScriptConRole());
        } else if (callbackData.equals(SCRIPT_SPECCON_ROLE_BUTTON.getValue())) {
            output = callbackQueryAnswer.getScriptMenu(chatId);
            fileId.add(fileIdConstants.getScriptSpecConRole());
        } else if (callbackData.equals(OTHER_INSTRUCTIONS_BUTTON.getValue())) {
            output = callbackQueryAnswer.getOtherInstructionsMenu(chatId);
        } else if (callbackData.equals(FAQ_BUTTON8.getValue())) {
            output = callbackQueryAnswer.getFaqMenu8(chatId);
        } else if (callbackData.equals(FAQ_BUTTON9.getValue())) {
            output = callbackQueryAnswer.getFaqMenu9(chatId);
        } else {
            log.debug("Smth goes wrong in processCallbackQueryMessage");
            output = errorAnswer.sendError(chatId);
        }

        if (photoIds.size() > 1) {
            sendPhotoId(photoIds);
            try {
                int millis = 475 * photoIds.size();
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }

        if (sendText != null) {
            sendAnswer(sendText);
        }

        if (fileId.size() > 1) {
            sendFileId(fileId);
            try {
                int millis = 475 * fileId.size();
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }

        if (output != null) {
            sendAnswer(output);
        }
    }

    private void sendFileId(ArrayList<String> fileId) {
        producerService.produceFileId(fileId);
    }

    private void sendPhotoId(ArrayList<String> photoIds) {
        producerService.producePhotoId(photoIds);
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
        User telegramUser;
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