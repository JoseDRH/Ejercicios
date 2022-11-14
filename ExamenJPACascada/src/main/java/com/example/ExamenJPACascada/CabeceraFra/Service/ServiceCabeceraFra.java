package com.example.ExamenJPACascada.CabeceraFra.Service;

import com.example.ExamenJPACascada.CabeceraFra.CabeceraFra;
import com.example.ExamenJPACascada.CabeceraFra.Model.CabeceraFraDTO;
import com.example.ExamenJPACascada.CabeceraFra.Repository.RepositoryCabeceraFra;
import com.example.ExamenJPACascada.LineasFra.Service.ServiceLineasFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCabeceraFra {

    @Autowired
    RepositoryCabeceraFra repositoryCabeceraFra;

    @Autowired
    ServiceLineasFra serviceLineasFra;

    public List<CabeceraFraDTO> findAll(){
        List<CabeceraFraDTO> facturas=new ArrayList<>();
        repositoryCabeceraFra.findAll().forEach(cabeceraFra -> facturas.add(cabeceraFra.setToDTO()));
        return facturas;
    }
    public void save(CabeceraFra cabeceraFra){
        cabeceraFra.getLineas().forEach(lineasFra -> serviceLineasFra.save(lineasFra));
        repositoryCabeceraFra.save(cabeceraFra);

    }
    public CabeceraFra findById(int id) throws Exception  {
        if (repositoryCabeceraFra.findById(id).isEmpty()){
            throw new RuntimeException() ;
        }
        else{
            return  repositoryCabeceraFra.findById(id).get();
        }
    }
    public void delete (int id) throws Exception {
       CabeceraFra ca=findById(id);
       ca.getLineas().forEach(lineasFra -> serviceLineasFra.delete(lineasFra.getID()));
       repositoryCabeceraFra.deleteById(id);
    }

}
