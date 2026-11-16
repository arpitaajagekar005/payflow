package com.arpitaajagekar.payflow.payment.processor;

import com.arpitaajagekar.payflow.payment.processor.dto.PaymentProcessorRequest;
import com.arpitaajagekar.payflow.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
