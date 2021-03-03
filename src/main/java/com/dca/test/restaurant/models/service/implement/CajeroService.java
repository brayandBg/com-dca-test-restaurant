package com.dca.test.restaurant.models.service.implement;

import com.dca.test.restaurant.exception.exceptions.*;
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
    public List<Cajero> findAll() throws TrainingResourceNoExistsException {
        if(dao.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Cajero>) dao.findAll();
    }

    @Override
    public Cajero findById(long id) throws TrainingResourceNotFoundException {
        cajero = dao.findById(id).orElse(null);
        if(cajero==null) throw new TrainingResourceNotFoundException();
        return cajero;
    }

    @Override
    public Cajero create(Cajero c) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceFieldAlreadyExistException {

        try {
            return dao.save(c);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Cajero edit(Cajero c) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException {
        cajero = findById(c.getId());

        cajero.setName(c.getName());
        cajero.setLastName(c.getLastName());
        cajero.setNumDocumento(c.getNumDocumento());
        try{
            return dao.save(cajero);
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
