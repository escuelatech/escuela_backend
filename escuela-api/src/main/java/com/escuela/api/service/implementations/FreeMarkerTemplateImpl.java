package com.escuela.api.service.implementations;


import com.escuela.api.service.interfaces.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

@Service
public class FreeMarkerTemplateImpl implements TemplateService {

    @Autowired
    private Configuration freemarkerConfig;

    @Override
    public String getData(Map model,String templateName) {
        try {
            String s = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate(templateName), model);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
