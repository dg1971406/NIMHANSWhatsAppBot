package com.ehrc.NIMHANSWhatsAppBot.RestControllers;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.MessageTransactionDataModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.NimhansMessageModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.RegisteredUserModal;
import com.ehrc.NIMHANSWhatsAppBot.Repository.MessageTransactionDetailsRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.NimhansMessageDataRepository;
import com.ehrc.NIMHANSWhatsAppBot.Repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoRestController {
    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private NimhansMessageDataRepository nimhansMessageDataRepository;

    @Autowired
    private MessageTransactionDetailsRepository messageTransactionDetailsRepository;

    @GetMapping("/getusers")
    public List<RegisteredUserModal> getHelloWorld() {
        return registeredUserRepository.getRegisteredUsers();
    }

    @GetMapping("/getpendingmessages")
    public List<MessageTransactionDataModal> getPendingMessageLists() {
        return messageTransactionDetailsRepository.getPendingMessageDetails();
    }

    @GetMapping("/getmessagesdata")
    public List<NimhansMessageModal> getnimhansmessagedata() {
        return nimhansMessageDataRepository.getNimhansMessageData();
    }
}
