package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.models.entity.Restaurante;
import com.dca.test.restaurant.models.service.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Restaurante")
public class RestauranteRestController {

    @Autowired
    private IRestauranteService restaurantSer;


    @GetMapping("/listar")
    public List<Restaurante> findAll() {
        return restaurantSer.findAll();

    }

    @GetMapping("/buscar/{id}")
    public Restaurante finById(@PathVariable Long id) {
        return restaurantSer.findById(id);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante crear(@RequestBody Restaurante r) {
        return restaurantSer.create(r);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante edit(@RequestBody Restaurante r, @PathVariable Long id) {
        Restaurante restaurant = restaurantSer.findById(id);
        restaurant.setName(r.getName());
        restaurant.setCorreo(r.getCorreo());
        restaurant.setTel(r.getTel());
        return restaurantSer.edit(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        restaurantSer.delete(id);
    }
}