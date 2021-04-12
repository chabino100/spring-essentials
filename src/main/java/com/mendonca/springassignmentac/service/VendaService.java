package com.mendonca.springassignmentac.service;

import com.mendonca.springassignmentac.entity.Venda;
import com.mendonca.springassignmentac.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public Venda saveVenda(Venda venda) {
        return repository.save(venda);
    }

    public List<Venda> getVendas() {
        return repository.findAll();
    }

    public Venda getVendaById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteVenda(int id) {
        repository.deleteById(id);
        return "Venda removed - " + id;
    }

    public Venda updateVenda(Venda venda) {
        Venda existingVenda = repository.findById(venda.getId()).orElse(venda);
        existingVenda.setVendedor(venda.getVendedor());
        existingVenda.setValor(venda.getValor());
        existingVenda.setCliente(venda.getCliente());
        return repository.save(existingVenda);
    }

}
