package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Restaurante;
import com.dca.test.restaurant.models.service.IRestauranteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Restaurante")
public class RestauranteRestController {

    @Autowired
    private IRestauranteService restaurantSer;

    @ApiOperation(value = "Retorna lista de Restaurantes", notes = "<br>Retorna una lista con todas las Restaurante registradas en la BD"
            , response = Restaurante.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Restaurante.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Restaurante> findAll() throws TrainingResourceNoExistsException {
        return restaurantSer.findAll();

    }

    @ApiOperation(value = "Retorna una Restaurante", notes = "<br>Retorna una Restaurante atraves del ID"
            , response = Restaurante.class, responseContainer = "Restaurante", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Restaurante.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Restaurante finById(@PathVariable Long id) throws TrainingResourceNotFoundException {
        return restaurantSer.findById(id);
    }

    @ApiOperation(value = "Crea una Restaurante", notes = "<br>Crea una Restaurante recibiendo un objeto Restaurante"
            , response = Restaurante.class, responseContainer = "Restaurante", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Restaurante.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante crear(@RequestBody Restaurante r) throws TrainingResourceFieldAlreadyExistException, TrainingResourceNoCreateException, TrainingResourceNotFoundException {
        return restaurantSer.create(r);
    }

    @ApiOperation(value = "Actualiza la informacion de una Restaurante", notes = "<br>Actualiza la informacion de una Restaurante atraves del ID"
            , response = Restaurante.class, responseContainer = "Restaurante", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Restaurante.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante edit(@RequestBody Restaurante r, @PathVariable Long id) throws TrainingResourceNoUpdateException, TrainingResourceNotFoundException {
        return restaurantSer.edit(r);
    }

    @ApiOperation(value = "Elimina una Restaurante", notes = "<br>Elimina una Restaurante atraves del ID"
            , response = Restaurante.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Restaurante.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceDeletedException {
        restaurantSer.delete(id);
    }
}