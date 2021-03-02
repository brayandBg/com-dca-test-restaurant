package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.models.entity.Cajero;
import com.dca.test.restaurant.models.service.ICajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cajero")
public class CajeroRestController {

    @Autowired
    private ICajeroService casherSer;


    @GetMapping("/listar")
    public List<Cajero> findAll() {
        return casherSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    public Cajero finById(@PathVariable Long id) {
        return casherSer.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Cajero crear(@RequestBody Cajero c) {
        return casherSer.create(c);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cajero edit(@RequestBody Cajero c, @PathVariable Long id) {
        Cajero casher = casherSer.findById(id);
        casher.setName(c.getName());
        casher.setLastename(c.getLastename());
        casher.setNumDocumento(c.getNumDocumento());

        return casher;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        casherSer.delete(id);
    }
}