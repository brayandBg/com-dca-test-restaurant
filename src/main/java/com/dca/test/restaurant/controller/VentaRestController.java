package com.dca.test.restaurant.controller;


import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Venta;
import com.dca.test.restaurant.models.service.IVentaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Venta")
public class VentaRestController {

    @Autowired
    private IVentaService ventaSer;

    @ApiOperation(value = "Retorna lista de Ventas", notes = "<br>Retorna una lista con todas las Venta registradas en la BD"
            , response = Venta.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Venta> findAll() throws TrainingResourceNoExistsException {
        return ventaSer.findAll();

    }

    @ApiOperation(value = "Retorna una Venta", notes = "<br>Retorna una Venta atraves del ID"
            , response = Venta.class, responseContainer = "Venta", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Venta finById(@PathVariable Long id) throws TrainingResourceNotFoundException {
        return ventaSer.findById(id);
    }

    @ApiOperation(value = "Crea una Venta", notes = "<br>Crea una Venta recibiendo un objeto Venta"
            , response = Venta.class, responseContainer = "Venta", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta crear(@RequestBody Venta v) throws TrainingResourceFieldAlreadyExistException, TrainingResourceNoCreateException, TrainingResourceNotFoundException {
        return ventaSer.create(v);
    }

    @ApiOperation(value = "Elimina una Venta", notes = "<br>Elimina una Venta atraves del ID"
            , response = Venta.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Venta.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceDeletedException {
        ventaSer.delete(id);
    }
}