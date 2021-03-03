package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Cajero;
import com.dca.test.restaurant.models.service.ICajeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cajero")
public class CajeroRestController {

    @Autowired
    private ICajeroService casherSer;

    @ApiOperation(value = "Retorna lista de Cajeros", notes = "<br>Retorna una lista con todas las Cajero registradas en la BD"
            , response = Cajero.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Cajero.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Cajero> findAll() throws TrainingResourceNoExistsException {
        return casherSer.findAll();

    }

    @ApiOperation(value = "Retorna una Cajero", notes = "<br>Retorna una Cajero atraves del ID"
            , response = Cajero.class, responseContainer = "Cajero", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Cajero.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Cajero finById(@PathVariable Long id) throws TrainingResourceNotFoundException {
        return casherSer.findById(id);
    }

    @ApiOperation(value = "Crea una Cajero", notes = "<br>Crea una Cajero recibiendo un objeto Cajero"
            , response = Cajero.class, responseContainer = "Cajero", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Cajero.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Cajero crear(@RequestBody Cajero c) throws TrainingResourceNotFoundException, TrainingResourceNoCreateException, TrainingResourceFieldAlreadyExistException {
        return casherSer.create(c);
    }

    @ApiOperation(value = "Actualiza la informacion de una Cajero", notes = "<br>Actualiza la informacion de una Cajero atraves del ID"
            , response = Cajero.class, responseContainer = "Cajero", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Cajero.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cajero edit(@RequestBody Cajero c, @PathVariable Long id) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException {
        return casherSer.edit(c);
    }


    @ApiOperation(value = "Elimina una Cajero", notes = "<br>Elimina una Cajero atraves del ID"
            , response = Cajero.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Cajero.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceDeletedException {
        casherSer.delete(id);
    }
}