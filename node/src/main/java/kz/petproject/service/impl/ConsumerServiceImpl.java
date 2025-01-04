package kz.petproject.service.impl;

import kz.petproject.service.ConsumerService;
import kz.petproject.service.MainService;
import kz.petproject.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j
@RequiredArgsConstructor
@Service
public class ConsumerServiceImpl implements ConsumerService {
    private final MainService mainService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.text-message-update}")
    @Transactional
    public void consumeTextMessageUpdates(Update update) {
        log.debug("NODE: Text message is received.");
        mainService.processTextMessage(update);
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.callback-message-update}")
    @Transactional
    public void consumeCallbackQueryMessageUpdates(Update update) {
        log.debug("NODE: Callback query message is received.");
        mainService.processCallbackQueryMessage(update);
    }
}
