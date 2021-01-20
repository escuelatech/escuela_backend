package com.escuela.api.service.interfaces;

import com.escuela.api.db.models.EscuelaServiceContent;

import java.util.List;

public interface EscuelaContentService {
    public List<EscuelaServiceContent> getAllService();

    public List<EscuelaServiceContent> findContentById(Integer id);
}
