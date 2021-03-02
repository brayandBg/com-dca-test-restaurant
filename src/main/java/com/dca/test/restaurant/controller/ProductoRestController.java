package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.models.entity.Producto;
import com.dca.test.restaurant.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Producto")
public class ProductoRestController {

    @Autowired
    private IProductoService productSer;


    @GetMapping("/listar")
    public List<Producto> findAll() {
        return productSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    public Producto finById(@PathVariable Long id) {
        return productSer.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto p) {
        return productSer.create(p);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto edit(@RequestBody Producto p, @PathVariable Long id) {
        Producto product = productSer.findById(id);
        product.setName(p.getName());
        product.setDescripcion(p.getDescripcion());
        product.setPrecio(p.getPrecio());
        return productSer.edit(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productSer.delete(id);
    }
}