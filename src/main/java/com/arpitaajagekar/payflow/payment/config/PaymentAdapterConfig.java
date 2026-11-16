package com.arpitaajagekar.payflow.payment.config;

import com.arpitaajagekar.payflow.common.enums.PaymentMethod;
import com.arpitaajagekar.payflow.payment.gateway.PaymentAdapter;
import com.arpitaajagekar.payflow.payment.gateway.adapter.CardPaymentAdapter;
import com.arpitaajagekar.payflow.payment.gateway.adapter.NetBankingAdapter;
import com.arpitaajagekar.payflow.payment.gateway.adapter.UpiPaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class PaymentAdapterConfig {

    private final NetBankingAdapter netBankingAdapter;
    private final CardPaymentAdapter cardPaymentAdapter;
    private final UpiPaymentAdapter upiPaymentAdapter;

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap() {
        return Map.of(
                PaymentMethod.CARD, cardPaymentAdapter,
                PaymentMethod.NETBANKING, netBankingAdapter,
                PaymentMethod.UPI, upiPaymentAdapter
        );
    }
}
