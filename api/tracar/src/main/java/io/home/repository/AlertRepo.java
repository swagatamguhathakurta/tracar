package io.home.repository;

import io.home.entity.Reading;

public interface AlertRepo {

    Reading create(Reading rd, String priority, String alert);
}
