package com.dca.test.restaurant.controller;


import com.dca.test.restaurant.models.entity.Venta;
import com.dca.test.restaurant.models.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Venta")
public class VentaRestController {

    @Autowired
    private IVentaService ventaSer;


    @GetMapping("/listar")
    public List<Venta> findAll() {
        return ventaSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    public Venta finById(@PathVariable Long id) {
        return ventaSer.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta crear(@RequestBody Venta v) {
        return ventaSer.create(v);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ventaSer.delete(id);
    }
}