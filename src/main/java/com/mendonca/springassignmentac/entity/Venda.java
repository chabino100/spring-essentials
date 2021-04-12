package com.mendonca.springassignmentac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VENDA")
public class Venda {

    @Id
    @Column(name = "CD_VENDA", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "VL_VENDA", nullable = false)
    private double valor;

    @Column(name = "NM_CLIENTE", nullable = false, length = 60)
    private String cliente;

    @Column(name = "NM_VENDEDOR", length = 60)
    private String vendedor;

    public Venda(double valor, String cliente, String vendedor) {
        this.valor = valor;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }
}
//Out Variable