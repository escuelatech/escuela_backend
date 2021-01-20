package com.escuela.api.service.implementations;

import com.escuela.api.db.models.EscuelaServiceContent;
import com.escuela.api.jpa.repositories.EscuelaServiceContentRepository;
import com.escuela.api.service.interfaces.EscuelaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "escuelacontentservice")
public class EscuelaContentServiceImpl implements EscuelaContentService {

    @Autowired
    EscuelaServiceContentRepository contentRepository;

    @Override
    public List<EscuelaServiceContent> getAllService() {
        return contentRepository.findAll();
    }

    @Override
    public List<EscuelaServiceContent> findContentById(Integer id) {
        return contentRepository.findContentById(id);
    }
}
