package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.models.dao.ICajeroDAO;
import com.dca.test.restaurant.models.entity.Cajero;
import com.dca.test.restaurant.models.service.ICajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajeroService implements ICajeroService {
    @Autowired
    private ICajeroDAO dao;

    private Cajero cajero;

    @Override
    public List<Cajero> findAll() {
        return (List<Cajero>) dao.findAll();
    }

    @Override
    public Cajero findById(long id) {
        cajero = dao.findById(id).orElse(null);
        return cajero;
    }

    @Override
    public Cajero create(Cajero c) {
        cajero = findById(c.getId());
        if(cajero!=null) return null;
        return dao.save(c);
    }

    @Override
    public Cajero edit(Cajero c) {

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
