package io.home.service;

import io.home.entity.Reading;
import io.home.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    private ReadingRepository repository;

    @Override
    @Transactional
    public Reading create(Reading rd) {

        return repository.create(rd);
    }
}
