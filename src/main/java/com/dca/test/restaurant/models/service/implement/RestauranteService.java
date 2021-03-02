package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.models.dao.IRestauranteDAO;
import com.dca.test.restaurant.models.entity.Restaurante;
import com.dca.test.restaurant.models.service.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService implements IRestauranteService {
    @Autowired
    private IRestauranteDAO dao;

    private Restaurante restaurante;

    @Override
    public List<Restaurante> findAll() {
        return (List<Restaurante>) dao.findAll();
    }

    @Override
    public Restaurante findById(long id) {
        restaurante = dao.findById(id).orElse(null);
        return restaurante;
    }

    @Override
    public Restaurante create(Restaurante c) {
        restaurante = findById(c.getId());
        if(restaurante!=null) return null;
        return dao.save(c);
    }

    @Override
    public Restaurante edit(Restaurante c) {

        return null;
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
