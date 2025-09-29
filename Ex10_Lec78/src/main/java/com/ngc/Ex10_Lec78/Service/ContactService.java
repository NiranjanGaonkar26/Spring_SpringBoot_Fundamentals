package com.ngc.Ex10_Lec78.Service;

import com.ngc.Ex10_Lec78.Model.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ContactService {
    Logger log = Logger.getLogger(ContactService.class.getName());

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
