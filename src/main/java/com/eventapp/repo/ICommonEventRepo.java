package com.eventapp.repo;

import com.eventapp.models.CommonEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommonEventRepo  extends CrudRepository<CommonEvent, Long> {
}
