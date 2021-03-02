package com.dca.test.restaurant.controller;


import com.dca.test.restaurant.models.entity.Factura;
import com.dca.test.restaurant.models.service.IFacturaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaRestController {

    @Autowired
    private IFacturaService factSer;



    @GetMapping("/listar")
    public List<Factura> findAll(){
        return factSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    public Factura finById(@PathVariable Long id){
        return factSer.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura p) {
        return factSer.create(p);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura edit(@RequestBody Factura f, @PathVariable Long id){
        Factura fact = factSer.findById(id);
        fact.setNumDocumento(f.getNumDocumento());
        fact.setNomClient(f.getNomClient());
        fact.setIdCasher(fact.getIdCasher());
        fact.setPago(f.getPago());

        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        factSer.delete(id);
    }

}
