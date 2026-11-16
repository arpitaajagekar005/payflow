package com.arpitaajagekar.payflow.operations.repository;

import com.arpitaajagekar.payflow.operations.entity.DlqEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DlqEventRepository extends JpaRepository<DlqEvent, UUID> {
}
