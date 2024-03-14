/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.demo.service.impl;

import tienda.demo.dao.CategoriaDao;
import tienda.demo.domain.categoria;
import tienda.demo.service.categoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CategoriaServiceImpl implements categoriaService {
    @Autowired
    private CategoriaDao categoriaDao;
    
    
    @Transactional(readOnly=true)
    @Override
    public List<categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

        @Override
    @Transactional(readOnly = true)
    public categoria getCategoria(categoria categoria) {
        return categoriaDao.findById(categoria.getIdcategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
