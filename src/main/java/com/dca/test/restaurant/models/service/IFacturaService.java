package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.models.entity.Factura;

import java.util.List;

public interface IFacturaService{
    public List<Factura> findAll();

    public Factura findById(long id);

    public Factura create (Factura f);

    public Factura edit(Factura f);

    public void delete (Long id);
}
