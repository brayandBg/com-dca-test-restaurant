package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.models.entity.Restaurante;

import java.util.List;

public interface IRestauranteService {
    public List<Restaurante> findAll();

    public Restaurante findById(long id);

    public Restaurante create (Restaurante r);

    public Restaurante edit(Restaurante r);

    public void delete (Long id);
}
