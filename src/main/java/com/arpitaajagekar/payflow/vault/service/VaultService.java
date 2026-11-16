package com.arpitaajagekar.payflow.vault.service;

import com.arpitaajagekar.payflow.common.entity.Money;
import com.arpitaajagekar.payflow.payment.processor.dto.PaymentProcessorResponse;
import com.arpitaajagekar.payflow.vault.dto.request.TokenizeRequest;
import com.arpitaajagekar.payflow.vault.dto.response.TokenizeResponse;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

public interface VaultService {

    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
