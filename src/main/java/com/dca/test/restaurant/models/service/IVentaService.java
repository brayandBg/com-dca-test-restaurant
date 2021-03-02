package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.models.entity.Venta;

import java.util.List;

public interface IVentaService {
    public List<Venta> findAll();

    public Venta findById(long id);

    public Venta create (Venta v);

    public void delete (Long id);
}
