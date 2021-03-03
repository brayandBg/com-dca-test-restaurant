package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Restaurante;

import java.util.List;

public interface IRestauranteService {

    public List<Restaurante> findAll() throws TrainingResourceNoExistsException;

    public Restaurante findById(long id) throws TrainingResourceNotFoundException;

    public Restaurante create (Restaurante r) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException;

    public Restaurante edit(Restaurante r) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException;

    public void delete (Long id) throws TrainingResourceDeletedException;
}
