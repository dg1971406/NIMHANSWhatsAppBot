package com.ehrc.NIMHANSWhatsAppBot.Repository;

import com.ehrc.NIMHANSWhatsAppBot.DataModals.RegisteredUserModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserModal, Integer> {

    @Query("select new RegisteredUserModal(c.userID, c.userName, c.countryCode, c.whatsappNumber) from  RegisteredUserModal c")
    public List<RegisteredUserModal> getRegisteredUsers();

    @Query("select new RegisteredUserModal(c.userID, c.userName, c.countryCode, c.whatsappNumber) from  RegisteredUserModal c where c.whatsappNumber = ?1")
    public RegisteredUserModal getUserIDWithWhatsAppNumber(long whatsAppNumber);

    @Query("select new RegisteredUserModal(c.userID, c.userName, c.countryCode, c.whatsappNumber) from  RegisteredUserModal c where c.userID = ?1")
    public RegisteredUserModal getUserWithUserID(int userID);


}
