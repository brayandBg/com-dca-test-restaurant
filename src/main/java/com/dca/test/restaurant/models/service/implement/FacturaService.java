package com.dca.test.restaurant.models.service.implement;


import com.dca.test.restaurant.exception.exceptions.*;
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
    public List<Factura> findAll() throws TrainingResourceNoExistsException {
        if(facturaDAO.findAll()==null) throw new TrainingResourceNoExistsException();
        return (List<Factura>) facturaDAO.findAll();
    }

    @Override
    public Factura findById(long id) throws TrainingResourceNotFoundException {
        factura = facturaDAO.findById(id).orElse(null);
        if(factura==null) throw new TrainingResourceNotFoundException();
        return factura;
    }

    double calculaPrecio(List<Venta> ventas){
        double precio=0;
        for (Venta v:
                ventas) {
            Producto p = productoDAO.findById(v.getId()).orElse(null);
            if (p!=null){
                precio+=p.getPrecio() * v.getCantProduct();

            }

        }
        return precio;
    }

    @Override
    public Factura create(Factura f) throws TrainingResourceNotFoundException, TrainingResourceNoCreateException, TrainingResourceNotVentasException, TrainingResourceDebePlataException {
        factura.setVentas(f.getVentas());
        factura.setCasher(f.getCasher());
        factura.setCodigoFactura(f.getCodigoFactura());
        factura.setPago(f.getPago());
        factura.setNomClient(f.getNomClient());
        factura.setVuelto(factura.getPrecio()-factura.getPago());
        factura.setNumDocumento(f.getNumDocumento());
        factura.setCreateAt(LocalDate.now());
        factura.setPrecio(calculaPrecio(factura.getVentas()));

        if (factura.getVentas()==null) throw new TrainingResourceNotVentasException();
        if (factura.getVuelto() < 0) throw new TrainingResourceDebePlataException();

        try{
            return facturaDAO.save(factura);
        }catch (Exception e){
            throw new TrainingResourceNoCreateException();
        }
    }

    @Override
    public Factura edit(Factura f) throws TrainingResourceNotFoundException, TrainingResourceNotVentasException, TrainingResourceDebePlataException, TrainingResourceNoUpdateException {
        factura = findById(f.getId());

        factura.setNomClient(f.getNomClient());
        factura.setNumDocumento(f.getNumDocumento());
        factura.setPago(f.getPago());

        factura.setVentas(f.getVentas());

        if (factura.getVentas()==null) throw new TrainingResourceNotVentasException();

        factura.setPrecio(calculaPrecio(factura.getVentas()));

        factura.setVuelto(f.getPago()-f.getPrecio());

        if (factura.getVuelto() < 0) throw new TrainingResourceDebePlataException();

        factura.setCreateAt(LocalDate.now());

        try{
            return facturaDAO.save(factura);
        }catch (Exception e){
            throw new TrainingResourceNoUpdateException();
        }
    }

    @Override
    public void delete(Long id) throws TrainingResourceDeletedException {
        try{
            facturaDAO.deleteById(id);
        }catch (Exception e){
            throw new TrainingResourceDeletedException();
        }
    }
}
