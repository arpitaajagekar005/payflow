package com.arpitaajagekar.payflow.payment.service.impl;

import com.arpitaajagekar.payflow.common.enums.PaymentStatus;
import com.arpitaajagekar.payflow.payment.api.PaymentLookupService;
import com.arpitaajagekar.payflow.payment.entity.Payment;
import com.arpitaajagekar.payflow.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentLookupServiceImpl implements PaymentLookupService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> findUnsettledCapturedPayments(UUID merchantId) {
        return paymentRepository.findByMerchantIdAndStatusForUpdate(merchantId, PaymentStatus.CAPTURED);
    }
}













