package com.dca.test.restaurant.controller;

import com.dca.test.restaurant.exception.exceptions.*;
import com.dca.test.restaurant.models.entity.Producto;
import com.dca.test.restaurant.models.service.IProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
public class ProductoRestController {

    @Autowired
    private IProductoService productSer;

    @ApiOperation(value = "Retorna lista de Productos", notes = "<br>Retorna una lista con todas las Producto registradas en la BD"
            , response = Producto.class, responseContainer = "List", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Producto.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/listar")
    public List<Producto> findAll() throws TrainingResourceNoExistsException {
        return productSer.findAll();

    }

    @ApiOperation(value = "Retorna una Producto", notes = "<br>Retorna una Producto atraves del ID"
            , response = Producto.class, responseContainer = "Producto", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Producto.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @GetMapping("/buscar/{id}")
    public Producto finById(@PathVariable Long id) throws TrainingResourceNotFoundException {
        return productSer.findById(id);
    }

    @ApiOperation(value = "Crea una Producto", notes = "<br>Crea una Producto recibiendo un objeto Producto"
            , response = Producto.class, responseContainer = "Producto", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Producto.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto p) throws TrainingResourceFieldAlreadyExistException, TrainingResourceNoCreateException, TrainingResourceNotFoundException {
        return productSer.create(p);
    }

    @ApiOperation(value = "Actualiza la informacion de una Producto", notes = "<br>Actualiza la informacion de una Producto atraves del ID"
            , response = Producto.class, responseContainer = "Producto", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Producto.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto edit(@RequestBody Producto p, @PathVariable Long id) throws TrainingResourceNotFoundException, TrainingResourceNoUpdateException {
        Producto product = productSer.findById(id);
        product.setName(p.getName());
        product.setDescripcion(p.getDescripcion());
        product.setPrecio(p.getPrecio());
        return productSer.edit(product);
    }

    @ApiOperation(value = "Elimina una Producto", notes = "<br>Elimina una Producto atraves del ID"
            , response = Producto.class, responseContainer = "null", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operación Exitosa", response = Producto.class),
            @ApiResponse(code = 401, message = "No posees  autorización"),
            @ApiResponse(code = 403, message = "Esta operación no esta permitida"),
            @ApiResponse(code = 404, message = "Recurso no encotrado"),
            @ApiResponse(code = 500, message = "Error del sistema")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws TrainingResourceDeletedException {
        productSer.delete(id);
    }
}