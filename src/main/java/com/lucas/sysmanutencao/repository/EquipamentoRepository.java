package com.lucas.sysmanutencao.repository;

import com.lucas.sysmanutencao.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}