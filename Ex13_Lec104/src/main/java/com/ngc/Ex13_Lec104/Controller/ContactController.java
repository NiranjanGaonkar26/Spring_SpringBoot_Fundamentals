package com.ngc.Ex13_Lec104.Controller;

import com.ngc.Ex13_Lec104.Model.Contact;
import com.ngc.Ex13_Lec104.Service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContact(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

//    @RequestMapping("/saveMsg", method = POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email, @RequestParam String subject, @RequestParam String message){
//        log.info(name);
//        log.info(mobileNum);
//        log.info(email);
//        log.info(subject);
//        log.info(message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if (errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact";
        }
        contactService.saveMessageDetails(contact);
        contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times contact form is submitted: "+contactService.getCounter());
        return "redirect:/contact";
    }
}
