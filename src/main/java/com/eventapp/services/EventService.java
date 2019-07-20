package com.eventapp.services;

import com.eventapp.models.CommonEvent;
import com.eventapp.repo.ICommonEventCustomRepo;
import com.eventapp.repo.ICommonEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private ICommonEventRepo iCommonEventRepo;
    private ICommonEventCustomRepo iCommonEventCustomRepo;
    
    @Autowired
    public EventService(ICommonEventRepo iCommonEventRepo, ICommonEventCustomRepo iCommonEventCustomRepo) {
        this.iCommonEventCustomRepo = iCommonEventCustomRepo;
        this.iCommonEventRepo = iCommonEventRepo;
    }

    public List<CommonEvent> findAll() {
        return iCommonEventCustomRepo.findAll();
    }

    public CommonEvent findByName(String name) {
        return (CommonEvent) iCommonEventCustomRepo.findByName(name);
    }

    public List findByCity(String city) {
        return iCommonEventCustomRepo.findByCity(city);
    }

    public List findByCountry(String country) {
        return iCommonEventCustomRepo.findByCountry(country);
    }

    public List findByStartDate(LocalDateTime startDate) {
        return iCommonEventCustomRepo.findByStartDate(startDate);
    }

    public List<CommonEvent> findByEndDate(LocalDateTime endDate) {
        return  iCommonEventCustomRepo.findByEndDate(endDate);
    }
}
