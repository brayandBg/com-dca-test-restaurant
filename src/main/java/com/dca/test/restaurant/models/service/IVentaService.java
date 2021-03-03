package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> findAll() throws TrainingResourceNoExistsException;

    public Venta findById(long id) throws TrainingResourceNotFoundException;

    public Venta create (Venta v) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException;

    public void delete (Long id) throws TrainingResourceDeletedException;
}
