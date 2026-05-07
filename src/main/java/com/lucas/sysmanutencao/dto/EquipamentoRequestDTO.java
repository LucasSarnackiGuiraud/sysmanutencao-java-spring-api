package com.lucas.sysmanutencao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.lucas.sysmanutencao.enums.CategoriaEquipamentos;


public class EquipamentoRequestDTO {


    @NotBlank
    private String nomeEquipamento;

    @NotNull
    private CategoriaEquipamentos categoriaEquipamento;

    public String getNomeEquipamento() {return nomeEquipamento;}

    public void setNomeEquipamento() {this.nomeEquipamento = nomeEquipamento;}

    public CategoriaEquipamentos getCategoriaEquipamento() {return categoriaEquipamento;}

    public void  setCategoria(){this.categoriaEquipamento = categoriaEquipamento;}
}
