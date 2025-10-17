package com.ngc.Ex17_Lec128.Service;

import com.ngc.Ex17_Lec128.Constants.ApplicationConstants;
import com.ngc.Ex17_Lec128.Model.Contact;
import com.ngc.Ex17_Lec128.Repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository){
        System.out.println("Contact Service bean instantiated");
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ApplicationConstants.OPEN);
        contact.setCreatedBy(ApplicationConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        int result = contactRepository.saveMessageToDB(contact);
        if(result > 0){
            log.info("Contact successfully saved to the DB");
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> getMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.fetchMsgsWithStatus(ApplicationConstants.OPEN);
        return contactMsgs;
    }
}
