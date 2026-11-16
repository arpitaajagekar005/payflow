package com.arpitaajagekar.payflow.operations.repository;

import com.arpitaajagekar.payflow.common.enums.SettlementStatus;
import com.arpitaajagekar.payflow.operations.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SettlementRepository extends JpaRepository<Settlement, UUID> {
    List<Settlement> findByStatus(SettlementStatus settlementStatus);
}
