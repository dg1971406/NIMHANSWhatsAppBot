package com.ehrc.NIMHANSWhatsAppBot.Utilities;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.MessageTransactionDataModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.NimhansMessageModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.RegisteredUserModal;
import com.ehrc.NIMHANSWhatsAppBot.Repository.MessageTransactionDetailsRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.NimhansMessageDataRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.RegisteredUserRepository;
import com.ehrc.NIMHANSWhatsAppBot.WhatsAppMessageProcessors.WhatsappMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ProcessPendingMessagesUtility {
    @Autowired
    private RegisteredUserRepository registeredUserRepository;
    @Autowired
    private NimhansMessageDataRepository nimhansMessageDataRepository;

    private DateTimeUtility dateTimeUtility;

    @Autowired
    private MessageTransactionDetailsRepository messageTransactionDetailsRepository;
    @Autowired
    private WhatsappMessageHandler whatsappMessageHandler;

    public void processPendingMessage(MessageTransactionDataModal pendingMessage) throws Exception {

        NimhansMessageModal messageData = nimhansMessageDataRepository.getMessageDataWithMessageID(pendingMessage.getMessageID());
        System.out.println("message data is " + messageData);

        System.out.println("Message type is text and we will handle this");
        RegisteredUserModal registeredUserDetails = registeredUserRepository.getUserWithUserID(pendingMessage.getUserID());
        whatsappMessageHandler.sendWhatsAppMessage(registeredUserDetails, messageData);
        processMessageTransactionData(pendingMessage, registeredUserDetails);
    }


    public void processMessageTransactionData(MessageTransactionDataModal pendingMessage, RegisteredUserModal registeredUserDetails) {
        updateSentMessageStatusFlag(pendingMessage.getTransactionID());

        makeNextUnsentMessageTransaction(pendingMessage, registeredUserDetails);
    }

    public void makeNextUnsentMessageTransaction(MessageTransactionDataModal pendingMessage, RegisteredUserModal registeredUSerDetails) {

        List<NimhansMessageModal> pendingMessageList = nimhansMessageDataRepository.getNextPendingMessageData(pendingMessage.getMessageID());

        System.out.println("current message id is = " + pendingMessage.getMessageID());
        System.out.println("pending list is : " + pendingMessageList);
        System.out.println(pendingMessageList.size());

        if (pendingMessageList.size() == 0) return;

        //Creating Next Pending Message Modal to save...
        NimhansMessageModal nextMessageData = pendingMessageList.get(0);
        MessageTransactionDataModal transactionModal = new MessageTransactionDataModal();

        transactionModal.setUserID(registeredUSerDetails.getUserID());
        transactionModal.setMessageID(nextMessageData.getMessageID());
        transactionModal.setIsSent(false);

        if (dateTimeUtility == null) dateTimeUtility = new DateTimeUtility();
        transactionModal.setMessageTime(dateTimeUtility.getTimeAfterSevenDaysInterval());
        messageTransactionDetailsRepository.save(transactionModal);
    }


    public void updateSentMessageStatusFlag(long transactionID) {
        MessageTransactionDataModal transactionData = messageTransactionDetailsRepository.getSentMessageTransactionDataWithTransactionID(transactionID);
        transactionData.setIsSent(true);
        Date modifiedDate = new Date(Calendar.getInstance().getTimeInMillis());
        transactionData.setMessageTime(modifiedDate);
        messageTransactionDetailsRepository.save(transactionData);
    }


}
