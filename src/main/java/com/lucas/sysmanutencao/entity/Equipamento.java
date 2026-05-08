package com.lucas.sysmanutencao.entity;

import com.lucas.sysmanutencao.enums.CategoriaEquipamentos;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Equipamento {
    //

    public Equipamento() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEquipamento;

    @Enumerated(EnumType.STRING)
    private CategoriaEquipamentos categoriaEquipamento;

    private LocalDate dataCadastroEquipamento;

    private boolean statusEquipamento;


    public Equipamento(String nomeEquipamento, CategoriaEquipamentos categoriaEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
        this.categoriaEquipamento =  categoriaEquipamento;
        this.dataCadastroEquipamento = LocalDate.now();
        this.statusEquipamento = true;
    }

    public Long getIdEquipamento() {return id;}

    public CategoriaEquipamentos getCategoriaEquipamento() {return  categoriaEquipamento;}

    public LocalDate getDataCadastroEquipamento() {return dataCadastroEquipamento;}

    public String getNomeEquipamento() {return nomeEquipamento;}

    public boolean isStatusEquipamento() {return statusEquipamento;}

    public void setStatusEquipamento(boolean statusEquipamentoNovo) {
        this.statusEquipamento = statusEquipamentoNovo;
    }

}
