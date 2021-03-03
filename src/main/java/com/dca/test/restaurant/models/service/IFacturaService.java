package com.dca.test.restaurant.models.service;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Factura;

import java.util.List;

public interface IFacturaService{

    public List<Factura> findAll() throws TrainingResourceNoExistsException;

    public Factura findById(long id) throws TrainingResourceNotFoundException;

    public Factura create (Factura f) throws TrainingResourceNotFoundException, TrainingResourceNoCreateException, TrainingResourceNotVentasException, TrainingResourceDebePlataException;

    public Factura edit(Factura f) throws TrainingResourceNotFoundException, TrainingResourceNotVentasException, TrainingResourceDebePlataException, TrainingResourceNoUpdateException;

    public void delete (Long id) throws TrainingResourceDeletedException;
}
