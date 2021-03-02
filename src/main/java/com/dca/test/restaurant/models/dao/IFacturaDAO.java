package com.dca.test.restaurant.models.dao;

import com.dca.test.restaurant.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {

}
