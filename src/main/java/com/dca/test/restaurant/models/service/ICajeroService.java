package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Cajero;

import java.util.List;

public interface ICajeroService {

    public List<Cajero> findAll() throws TrainingResourceNoExistsException;

    public Cajero findById(long id) throws TrainingResourceNotFoundException;

    public Cajero create (Cajero c) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException;

    public Cajero edit(Cajero c) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException;

    public void delete (Long id) throws TrainingResourceDeletedException;
}
