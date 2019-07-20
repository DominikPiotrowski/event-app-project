package com.eventapp.repo;

import com.eventapp.models.CommonEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICommonEventCustomRepo extends JpaRepository<CommonEvent, Long> {

    @Query("SELECT m FROM CommonEvent m WHERE m.eventName =:name")
    List<CommonEvent> findByName(String name);

    @Query("SELECT m FROM CommonEvent m WHERE m.city =:city")
    List<CommonEvent> findByCity(String city);

    @Query("SELECT m FROM CommonEvent m WHERE m.country =:country")
    List<CommonEvent> findByCountry(String country);

    @Query("SELECT m FROM CommonEvent m WHERE m.eventStartDate =:startDate")
    List<CommonEvent> findByStartDate(LocalDateTime startDate);

    @Query("SELECT m FROM CommonEvent m WHERE m.eventEndDate =:endDate")
    List<CommonEvent> findByEndDate(LocalDateTime endDate);
}
