package com.escuela.api.service.implementations;


import com.escuela.api.service.interfaces.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

@Service
public class FreeMarkerTemplateImpl implements TemplateService {

    @Qualifier("freemarker")
    private Configuration freemarkerConfig;

    private Template getTemplate(String templateName){
        try {
            return freemarkerConfig.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getData(Map model,String templateName) {
        try {
            String s = FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(templateName), model);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
