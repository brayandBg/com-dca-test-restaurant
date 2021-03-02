package com.dca.test.restaurant.models.service.implement;


import com.dca.test.restaurant.models.dao.IFacturaDAO;
import com.dca.test.restaurant.models.dao.IProductoDAO;
import com.dca.test.restaurant.models.entity.Factura;
import com.dca.test.restaurant.models.entity.Producto;
import com.dca.test.restaurant.models.entity.Venta;
import com.dca.test.restaurant.models.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService {
    @Autowired
    private IFacturaDAO facturaDAO;
    
    @Autowired
    private IProductoDAO productoDAO;

    private Factura factura;

    @Autowired
    VentaService ventaService;

    @Autowired
    ProductoService productoService;

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaDAO.findAll();
    }

    @Override
    public Factura findById(long id) {
        factura = facturaDAO.findById(id).orElse(null);
        return factura;
    }

    @Override
    public Factura create(Factura f) {
        factura = findById(f.getId());
        if(factura!=null) return null;
        double precio=0;

        return facturaDAO.save(f);
    }

    @Override
    public Factura edit(Factura f) {


        factura.setNomClient(f.getNomClient());
        factura.setNumDocumento(f.getNumDocumento());
        factura.setPago(f.getPago());
        double precio=0;
        /*int con=0;
        while(con==0){
            if(){
                ventaService.create();
            }else if(){
                ventaService.delete();
            }else{
                con=1;
            }

        }


        List<Venta> ventas;//= select * from ventas where id_factura = f.getId()
        for (Venta venta:
             ventas) {
            Producto p = productoService.findById(venta.getIdProducto());
            precio+=p.getPrecio()*venta.getCantProduct();
        }*/
        factura.setPrecio(precio);

        factura.setVuelto(f.getPago()-f.getPrecio());
        factura.setCreateAt(LocalDate.now());

        return facturaDAO.save(factura);
    }

    @Override
    public void delete(Long id) {
        facturaDAO.deleteById(id);
    }
}
