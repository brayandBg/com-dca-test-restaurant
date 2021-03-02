package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.models.dao.IVentaDAO;
import com.dca.test.restaurant.models.entity.Venta;

import com.dca.test.restaurant.models.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaDAO dao;

    private Venta venta;

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) dao.findAll();
    }

    @Override
    public Venta findById(long id) {
        venta = dao.findById(id).orElse(null);
        return venta;
    }

    @Override
    public Venta create(Venta c) {
        venta = findById(c.getId());
        if(venta!=null) return null;
        return dao.save(c);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
