package com.ehrc.NIMHANSWhatsAppBot.DataModals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_data")
public class NimhansMessageModal {

    @Id
    @Column(name = "message_id")
    private int messageID;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "message_URL")
    private String messageURL;

    @Column(name = "message_text")
    private String messageText;

}
