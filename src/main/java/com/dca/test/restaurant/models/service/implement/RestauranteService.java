package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.exception.exceptions.*;
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

    private Restaurante Restaurante;

    @Override
    public List<Restaurante> findAll() throws TrainingResourceNoExistsException {
        if(dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Restaurante>) dao.findAll();
    }

    @Override
    public Restaurante findById(long id) throws TrainingResourceNotFoundException {
        Restaurante = dao.findById(id).orElse(null);
        if(Restaurante==null) throw new TrainingResourceNotFoundException();
        return Restaurante;
    }

    @Override
    public Restaurante create(Restaurante r) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException {

        try {
            return dao.save(r);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Restaurante edit(Restaurante r) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException {
        Restaurante = findById(r.getId());


        try{
            return dao.save(Restaurante);
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
