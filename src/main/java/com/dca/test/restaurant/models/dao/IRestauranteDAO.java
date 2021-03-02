package com.dca.test.restaurant.models.dao;

import com.dca.test.restaurant.models.entity.Restaurante;
import org.springframework.data.repository.CrudRepository;

public interface IRestauranteDAO extends CrudRepository<Restaurante, Long> {
}
