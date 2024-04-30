package com.ehrc.NIMHANSWhatsAppBot.Repository;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.MessageTransactionDataModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageTransactionDetailsRepository extends JpaRepository<MessageTransactionDataModal, Integer> {

    @Query("select new MessageTransactionDataModal (c.transactionID, c.userID, c.isSent, c.messageID, c.messageTime) from  MessageTransactionDataModal c where c.messageTime <= NOW() and c.isSent = false")
    public List<MessageTransactionDataModal> getPendingMessageDetails();

    @Query("select new MessageTransactionDataModal (c.transactionID, c.userID, c.isSent, c.messageID, c.messageTime) from  MessageTransactionDataModal c where c.transactionID = ?1")
    public MessageTransactionDataModal getSentMessageTransactionDataWithTransactionID(long transactionID);

}
