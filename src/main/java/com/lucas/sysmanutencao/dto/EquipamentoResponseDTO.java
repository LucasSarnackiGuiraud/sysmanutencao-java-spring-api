package com.lucas.sysmanutencao.dto;

import com.lucas.sysmanutencao.enums.CategoriaEquipamentos;
import com.lucas.sysmanutencao.entity.Equipamento;

import java.time.LocalDate;

public class EquipamentoResponseDTO {
    //
    private long idEquipamento;
    private String nomeEquipamento;
    private CategoriaEquipamentos categoriaEquipamentos;
    private LocalDate dataCadastroEquipamento;
    private boolean statusEquipamento;

    public EquipamentoResponseDTO(Equipamento equipamento) {
        this.idEquipamento = equipamento.getIdEquipamento();
        this.nomeEquipamento = equipamento.getNomeEquipamento();
        this.categoriaEquipamentos = equipamento.getCategoriaEquipamento();
        this.dataCadastroEquipamento = LocalDate.now();
        this.statusEquipamento = true;
    }

    public long getIdEquipamento() {
        return idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public CategoriaEquipamentos getCategoriaEquipamento() {
        return categoriaEquipamentos;
    }

    public LocalDate getDataCadastroEquipamento() {
        return dataCadastroEquipamento;
    }

    public boolean isStatusEquipamento() {
        return statusEquipamento;
    }

}
