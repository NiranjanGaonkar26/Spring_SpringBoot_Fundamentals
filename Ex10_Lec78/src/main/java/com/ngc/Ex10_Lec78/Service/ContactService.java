package com.ngc.Ex10_Lec78.Service;

import com.ngc.Ex10_Lec78.Model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}
