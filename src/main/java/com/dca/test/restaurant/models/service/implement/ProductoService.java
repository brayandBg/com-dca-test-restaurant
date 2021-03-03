package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.dao.IProductoDAO;
import com.dca.test.restaurant.models.entity.Producto;
import com.dca.test.restaurant.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoDAO dao;

    private Producto Producto;

    @Override
    public List<Producto> findAll() throws TrainingResourceNoExistsException {
        if(dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Producto>) dao.findAll();
    }

    @Override
    public Producto findById(long id) throws TrainingResourceNotFoundException {
        Producto = dao.findById(id).orElse(null);
        if(Producto==null) throw new TrainingResourceNotFoundException();
        return Producto;
    }

    @Override
    public Producto create(Producto p) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException {

        try {
            return dao.save(p);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Producto edit(Producto p) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException {
        Producto = findById(p.getId());

        Producto.setPrecio(p.getPrecio());
        Producto.setName(p.getName());
        Producto.setDescripcion(p.getDescripcion());
        Producto.setCodigo(p.getCodigo());

        try{
            return dao.save(Producto);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
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
