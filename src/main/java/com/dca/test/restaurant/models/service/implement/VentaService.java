package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.dao.IVentaDAO;
import com.dca.test.restaurant.models.dao.IVentaDAO;
import com.dca.test.restaurant.models.entity.Venta;
import com.dca.test.restaurant.models.entity.Venta;

import com.dca.test.restaurant.models.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    //Clase auxiliar para establecer la relación de los productos que tendra una factura

    @Autowired
    private IVentaDAO dao;

    private Venta Venta;

    @Override
    public List<Venta> findAll() throws TrainingResourceNoExistsException {
        if(dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Venta>) dao.findAll();
    }

    @Override
    public Venta findById(long id) throws TrainingResourceNotFoundException {
        Venta = dao.findById(id).orElse(null);
        if(Venta==null) throw new TrainingResourceNotFoundException();
        return Venta;
    }

    @Override
    public Venta create(Venta v) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException {

        try {
            return dao.save(v);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceDeletedException {
        try{
            dao.deleteById(id);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }
}
