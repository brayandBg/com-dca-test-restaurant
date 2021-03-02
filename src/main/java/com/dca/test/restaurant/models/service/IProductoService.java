package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.models.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();

    public Producto findById(long id);

    public Producto create (Producto p);

    public Producto edit(Producto p);

    public void delete (Long id);
}
