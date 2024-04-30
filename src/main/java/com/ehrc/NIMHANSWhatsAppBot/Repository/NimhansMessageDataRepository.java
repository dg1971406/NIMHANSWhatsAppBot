package com.ehrc.NIMHANSWhatsAppBot.Repository;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.NimhansMessageModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NimhansMessageDataRepository extends JpaRepository<NimhansMessageModal, Integer> {

    @Query("select new NimhansMessageModal (c.messageID, c.messageType, c.messageURL, c.messageText) from  NimhansMessageModal c")
    public List<NimhansMessageModal> getNimhansMessageData();

    @Query("select new NimhansMessageModal (c.messageID, c.messageType, c.messageURL, c.messageText) from  NimhansMessageModal c where c.messageID = ?1")
    public NimhansMessageModal getNimhansFirstMessageDetails(String messageID);

    @Query("select new NimhansMessageModal (c.messageID, c.messageType, c.messageURL, c.messageText) from  NimhansMessageModal c where c.messageID = ?1")
    public NimhansMessageModal getMessageDataWithMessageID(int messageID);

    @Query("select new NimhansMessageModal (c.messageID, c.messageType, c.messageURL, c.messageText) from  NimhansMessageModal c where c.messageID > ?1 order by c.messageID asc")
    public List<NimhansMessageModal> getNextPendingMessageData(int messageID);

}
