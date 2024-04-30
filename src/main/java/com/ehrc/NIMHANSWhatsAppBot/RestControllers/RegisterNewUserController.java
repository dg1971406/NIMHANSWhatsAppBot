package com.ehrc.NIMHANSWhatsAppBot.RestControllers;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.MessageTransactionDataModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.NimhansMessageModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.RegisteredUserModal;
import com.ehrc.NIMHANSWhatsAppBot.Repository.MessageTransactionDetailsRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.NimhansMessageDataRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.RegisteredUserRepository;
import com.ehrc.NIMHANSWhatsAppBot.Utilities.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterNewUserController {

    private DateTimeUtility dateTimeUtility;

    @Autowired
    private MessageTransactionDetailsRepository messageTransactionDetailsRepository;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private NimhansMessageDataRepository nimhansMessageDataRepository;

    @PostMapping("/registernewuser")
    public RegisteredUserModal registerNewUser(@RequestBody RegisteredUserModal newUser) {
        registeredUserRepository.save(newUser);
        RegisteredUserModal registeredUserData = registeredUserRepository.getUserIDWithWhatsAppNumber(newUser.getWhatsappNumber());

        if (dateTimeUtility == null)
            dateTimeUtility = new DateTimeUtility();

        NimhansMessageModal messageData = nimhansMessageDataRepository.getNimhansFirstMessageDetails("1");

        MessageTransactionDataModal transactionModal = new MessageTransactionDataModal();

        transactionModal.setUserID(registeredUserData.getUserID());
        transactionModal.setMessageID(messageData.getMessageID());
        transactionModal.setIsSent(false);
        transactionModal.setMessageTime(dateTimeUtility.getFirstMessageTime());

        messageTransactionDetailsRepository.save(transactionModal);

        return registeredUserData;
    }
}
