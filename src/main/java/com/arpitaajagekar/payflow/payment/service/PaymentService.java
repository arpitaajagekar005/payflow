package com.arpitaajagekar.payflow.payment.service;

import com.arpitaajagekar.payflow.payment.dto.request.PaymentInitRequest;
import com.arpitaajagekar.payflow.payment.dto.response.PaymentResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);

    PaymentResponse capture(UUID merchantId, UUID paymentId);

    void resolveAuthorization(UUID paymentId, boolean approve, String bankRef, String errorCode, String errorDescription);
}
