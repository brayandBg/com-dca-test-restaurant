package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll() throws TrainingResourceNoExistsException;

    public Producto findById(long id) throws TrainingResourceNotFoundException;

    public Producto create (Producto p) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException;

    public Producto edit(Producto p) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException;

    public void delete (Long id) throws TrainingResourceDeletedException;
}
