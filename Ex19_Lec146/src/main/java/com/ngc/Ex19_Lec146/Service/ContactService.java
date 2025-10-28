package com.ngc.Ex19_Lec146.Service;

import com.ngc.Ex19_Lec146.Constants.ApplicationConstants;
import com.ngc.Ex19_Lec146.Model.Contact;
import com.ngc.Ex19_Lec146.Repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContact_id() > 0){
            log.info("Contact successfully saved to the DB");
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> getMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(ApplicationConstants.OPEN);
        return contactMsgs;
    }

    public boolean closeOpenMessage(int msgid, String updatedBy) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(msgid);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(ApplicationConstants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getContact_id() > 0){
            log.info("Contact message status successfully updated to Closed in the DB");
            isUpdated = true;
        }
        return isUpdated;
    }
}
