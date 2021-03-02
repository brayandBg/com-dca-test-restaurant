package com.dca.test.restaurant.models.dao;

import com.dca.test.restaurant.models.entity.Cajero;
import org.springframework.data.repository.CrudRepository;

public interface ICajeroDAO extends CrudRepository<Cajero, Long> {
}
