package com.dca.test.restaurant.controller;


import com.dca.test.restaurant.exception.exceptions.*;
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

    @ApiOperation(value = "Retorna lista de facturas", notes = "<br>Retorna una lista con todas las Factura registradas en la BD"
            , response = Factura.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Factura.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Factura> findAll() throws TrainingResourceNoExistsException {
        return factSer.findAll();

    }


    @ApiOperation(value = "Retorna una factura", notes = "<br>Retorna una Factura atraves del ID"
            , response = Factura.class, responseContainer = "Factura", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Factura.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Factura finById(@PathVariable Long id) throws TrainingResourceNotFoundException {
        return factSer.findById(id);
    }


    @ApiOperation(value = "Crea una factura", notes = "<br>Crea una Factura recibiendo un objeto factura"
            , response = Factura.class, responseContainer = "Factura", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Factura.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura f) throws TrainingResourceNoCreateException, TrainingResourceNotFoundException, TrainingResourceNotVentasException, TrainingResourceDebePlataException {
        return factSer.create(f);
    }

    @ApiOperation(value = "Actualiza la informacion de una factura", notes = "<br>Actualiza la informacion de una Factura atraves del ID"
            , response = Factura.class, responseContainer = "Factura", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Factura.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura edit(@RequestBody Factura f, @PathVariable Long id) throws TrainingResourceNoUpdateException, TrainingResourceNotFoundException, TrainingResourceDebePlataException, TrainingResourceNotVentasException {
        return factSer.edit(f);
    }

    @ApiOperation(value = "Elimina una factura", notes = "<br>Elimina una Factura atraves del ID"
            , response = Factura.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Factura.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceDeletedException {
        factSer.delete(id);
    }

}
