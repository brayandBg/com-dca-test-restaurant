package com.dca.test.restaurant.models.service.implement;

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

    private Producto producto;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) dao.findAll();
    }

    @Override
    public Producto findById(long id) {
        producto = dao.findById(id).orElse(null);
        return producto;
    }

    @Override
    public Producto create(Producto c) {
        producto = findById(c.getId());
        if(producto!=null) return null;
        return dao.save(c);
    }

    @Override
    public Producto edit(Producto c) {

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
