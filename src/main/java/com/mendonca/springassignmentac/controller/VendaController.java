package com.mendonca.springassignmentac.controller;

import com.mendonca.springassignmentac.entity.Venda;
import com.mendonca.springassignmentac.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendaController {

    @Autowired
    private VendaService service;

    @PostMapping("/addVenda")
    public String addVenda(@RequestBody Venda venda) {
        Venda savedVenda = service.saveVenda(venda);
        return String.valueOf(savedVenda.getId());
    }

    @GetMapping("/vendas")
    public List<Venda> findAllVendas() { return service.getVendas(); }

    @GetMapping("/venda/{id}")
    public Venda findVendaById(@PathVariable int id) {
        return service.getVendaById(id);
    }

    @PutMapping("/update")
    public String updateVenda(@RequestBody Venda venda) {
        Venda updateVenda = service.updateVenda(venda);
        return String.valueOf(updateVenda.getId());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVenda(@PathVariable int id) { return service.deleteVenda(id); }

}
