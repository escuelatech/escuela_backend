package com.escuela.api.service.implementations;


import com.escuela.api.service.interfaces.EmailService;
import com.escuela.api.service.interfaces.TemplateService;
import com.escuela.api.ui.models.Mail;
import com.escuela.api.utilities.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//import static com.web.escuela.api.utils.PranamaConstants.PRANAMA_EMAIL;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailUtils email;

    @Autowired
    TemplateService templateService;

//    @Autowired
//    EmailRepository emailRepository;

    @Async
    public void sendEmail(Mail mail){
//        persistEmail(mail);
        mail.setMessage(templateService.getData(mail.getTemplateModel(),mail.getTemplateName()));
        email.sendInDividualEmail(mail.getMessage(),mail.getTo(),mail.getSubject());
    }


    @Deprecated
    public void sendEmails(Mail mail){
        try{
            mail.setSubject("[Pranama] Customer Enquiry Received ");
            mail.setFrom(mail.getEmail());
            mail.setTo("PRANAMA_EMAIL");
//            persistEmail(mail);
            boolean flag=email.sendInDividualEmail(mail.getMessage(), mail.getEmail(), mail.getSubject());
            email.sendInDividualEmail("Thanks for your enquiry, We are happy to help you. Our team will be in touch with you soon ",
                    mail.getEmail(),
                    " [Pranama] Thanks for Contacting Pranama ");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

//    /**
//     *
//     * @param mail
//     */
//    public void persistEmail(Mail mail){
//        try {
//            EmailDBModel emailModel = new EmailDBModel();
//            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
//            emailModel.setReceivedDate(String.valueOf(sqlDate));
//            emailModel.setFromEmail(mail.getFrom());
//            //system generated email
//            if(null==mail.getFrom()){
//                mail.setFrom("paranamaindia@gmail.com");
//                emailModel.setFromEmail("paranamaindia@gmail.com");
//            }
//            emailModel.setToEmail(mail.getTo());
//            emailModel.setEmailSubject(mail.getSubject());
//            emailModel.setMessageDetails(mail.getMessage());
//            emailModel.setUserEmail(mail.getFrom());
//            emailRepository.save(emailModel);
//        }catch (Exception e){
//            e.printStackTrace();
//            email.sendInDividualEmail(String.valueOf(e.getLocalizedMessage()),
//                    "shyam_ramath@yahoo.com"," [Pranama] Thanks for Contacting Pranama ");
//        }
//    }


}
