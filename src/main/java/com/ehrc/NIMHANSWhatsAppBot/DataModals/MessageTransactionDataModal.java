package com.ehrc.NIMHANSWhatsAppBot.DataModals;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_sent_data ")
public class MessageTransactionDataModal {

    @Id
    @Column(name = "transaction_id")
    private long transactionID;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "is_sent")
    private Boolean isSent;

    @Column(name = "message_id")
    private int messageID;

    @Column(name = "message_time")
    private Date messageTime;
}
