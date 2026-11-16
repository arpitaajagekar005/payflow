package com.arpitaajagekar.payflow.payment.api;

import com.arpitaajagekar.payflow.payment.entity.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentLookupService {

    List<Payment> findUnsettledCapturedPayments(UUID merchantId);
}
