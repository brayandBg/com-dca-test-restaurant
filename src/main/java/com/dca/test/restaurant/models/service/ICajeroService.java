package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.models.entity.Cajero;

import java.util.List;

public interface ICajeroService {
    public List<Cajero> findAll();

    public Cajero findById(long id);

    public Cajero create (Cajero c);

    public Cajero edit(Cajero c);

    public void delete (Long id);
}
