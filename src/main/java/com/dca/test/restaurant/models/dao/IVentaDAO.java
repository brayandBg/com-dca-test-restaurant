package com.dca.test.restaurant.models.dao;

import com.dca.test.restaurant.models.entity.Venta;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDAO extends CrudRepository<Venta, Long> {
}
