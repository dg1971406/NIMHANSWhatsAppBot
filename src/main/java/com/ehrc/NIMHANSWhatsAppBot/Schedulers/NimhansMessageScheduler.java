package com.ehrc.NIMHANSWhatsAppBot.Schedulers;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.MessageTransactionDataModal;
import com.ehrc.NIMHANSWhatsAppBot.Repository.MessageTransactionDetailsRepository;
import com.ehrc.NIMHANSWhatsAppBot.Utilities.ProcessPendingMessagesUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NimhansMessageScheduler {

    @Autowired
    private MessageTransactionDetailsRepository messageTransactionDetailsRepository;

    @Autowired
    private ProcessPendingMessagesUtility processPendingMessagesUtility;


    @Scheduled(initialDelay = 10 * 1000, fixedDelay = 30 * 1000)
    public void sendPeriodicMessages() throws Exception{
        System.out.println("Scheduler method is running!!!");

        List<MessageTransactionDataModal> pendingMessageList = messageTransactionDetailsRepository.getPendingMessageDetails();
        System.out.println("Pending message list is count is : " + pendingMessageList.size());

        if(pendingMessageList.size() == 0) return;

        MessageTransactionDataModal pendingMessage = pendingMessageList.get(0);
        processPendingMessagesUtility.processPendingMessage(pendingMessage);
    }
}
