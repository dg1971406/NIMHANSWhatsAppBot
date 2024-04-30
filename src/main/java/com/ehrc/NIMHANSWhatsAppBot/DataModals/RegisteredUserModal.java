package com.ehrc.NIMHANSWhatsAppBot.DataModals;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registered_users")
public class RegisteredUserModal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private int userID;

    @Column(name = "name")
    @JsonProperty("name")
    private String userName;

    @Column(name = "country_code")
    @JsonProperty("country_code")
    private int countryCode;

    @Column(name = "whatsapp_number")
    @JsonProperty("whatsapp_number")
    private long whatsappNumber;

}
