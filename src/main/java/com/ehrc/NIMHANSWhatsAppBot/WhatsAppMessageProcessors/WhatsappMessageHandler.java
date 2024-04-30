package com.ehrc.NIMHANSWhatsAppBot.WhatsAppMessageProcessors;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.NimhansMessageModal;
import com.ehrc.NIMHANSWhatsAppBot.DataModals.RegisteredUserModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhatsappMessageHandler {

    @Autowired
    private WhatsAppMessageGlobalHandler whatsAppMessageGlobalHandler;

    public void sendWhatsAppMessage(RegisteredUserModal registeredUserDetails, NimhansMessageModal messageData) throws Exception {

        String JSONBody = getWhatsAppMessageJson(registeredUserDetails, messageData);

        System.out.println("JSON Data is : " + JSONBody);
        String whatsappServerResponse = whatsAppMessageGlobalHandler.hitWhatsAppServerMessageRequestWithBody(JSONBody);
        System.out.println("Response after hitting server is " + whatsappServerResponse);
    }


    public String getWhatsAppMessageJson(RegisteredUserModal registeredUSerDetails, NimhansMessageModal messageData) {
        String senderWhatsAppNumber = "" + registeredUSerDetails.getCountryCode() + registeredUSerDetails.getWhatsappNumber();
        switch (messageData.getMessageType()) {
            case "text":
                return "{\"messaging_product\":\"whatsapp\",\"preview_url\":false,\"recipient_type\":\"individual\",\"to\":\"" +
                        senderWhatsAppNumber +
                        "\",\"type\":\"text\",\"text\":{\"body\":\"" +
                        messageData.getMessageText() +
                        "\"}}";

            case "pdf":
                return "{\"messaging_product\":\"whatsapp\",\"preview_url\":false,\"recipient_type\":\"individual\",\"to\":\"" +
                        senderWhatsAppNumber +
                        "\",\"type\":\"document\",\"document\":{\"link\":\"" +
                        messageData.getMessageURL() +
                        "\", \"caption\":\"" +
                        messageData.getMessageText() +
                        "\"}}";
            case "video":
                return "{\"messaging_product\":\"whatsapp\",\"preview_url\":false,\"recipient_type\":\"individual\",\"to\":\"" +
                        senderWhatsAppNumber +
                        "\",\"type\":\"video\",\"video\":{\"link\":\"" +
                        messageData.getMessageURL() +
                        "\"}}";
            default:
                //Return audio file!!!
                return "";
        }
    }
//
//    {
//        "messaging_product": "whatsapp",
//            "recipient_type": "individual",
//            "to": "919015346166",
//            "type": "video",
//            "video": {
//        "link": "https://onlinetestcase.com/wp-content/uploads/2023/06/1MB.mp4"
//    }
//    }


}
