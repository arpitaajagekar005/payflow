package com.arpitaajagekar.payflow.operations.repository;

import com.arpitaajagekar.payflow.operations.entity.SettlementPayment;
import com.arpitaajagekar.payflow.operations.entity.SettlementPaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementPaymentRepository extends JpaRepository<SettlementPayment, SettlementPaymentId> {
}
