package com.arpitaajagekar.payflow.vault.repository;

import com.arpitaajagekar.payflow.vault.entity.VaultCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaultCardRepository extends JpaRepository<VaultCard, UUID> {
}
