package com.reto3.demo.service;

import com.reto3.demo.model.Audience;
import com.reto3.demo.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audi) {
        if (audi.getId() == null) {
            return audienceRepository.save(audi);
        } else {
            Optional<Audience> consulta = audienceRepository.getAudience(audi.getId());
            if (consulta.isEmpty()) {
                return audienceRepository.save(audi);
            } else {
                return audi;

            }
        }
    }

}
