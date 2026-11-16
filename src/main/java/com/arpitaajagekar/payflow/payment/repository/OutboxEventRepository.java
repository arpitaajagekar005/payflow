package com.arpitaajagekar.payflow.payment.repository;

import com.arpitaajagekar.payflow.common.enums.OutboxStatus;
import com.arpitaajagekar.payflow.payment.entity.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OutboxEventRepository extends JpaRepository<OutboxEvent, UUID> {

    List<OutboxEvent> findByStatusOrderByCreatedAtAsc(OutboxStatus status);
}
