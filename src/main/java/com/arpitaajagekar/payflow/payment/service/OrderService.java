package com.arpitaajagekar.payflow.payment.service;

import com.arpitaajagekar.payflow.payment.dto.request.CreateOrderRequest;
import com.arpitaajagekar.payflow.payment.dto.response.OrderResponse;
import com.arpitaajagekar.payflow.payment.dto.response.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);

    OrderResponse getById(UUID merchantId, UUID orderId);

    OrderResponse cancel(UUID merchantId, UUID orderId);

    List<PaymentResponse> listPayments(UUID merchantId, UUID orderId);
}
