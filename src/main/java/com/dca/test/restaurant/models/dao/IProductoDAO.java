package com.dca.test.restaurant.models.dao;

import com.dca.test.restaurant.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
}
