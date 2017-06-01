package io.home.controller;

import io.home.entity.Reading;
import io.home.service.AlertService;
import io.home.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class ReadingsController {

    @Autowired
    private ReadingService service;
    @Autowired
    private AlertService aservice;

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading rd) {
        service.create(rd);
        aservice.create(rd);

        return rd;
    }
}
