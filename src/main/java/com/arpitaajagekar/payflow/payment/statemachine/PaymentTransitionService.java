package com.arpitaajagekar.payflow.payment.statemachine;

import com.arpitaajagekar.payflow.common.enums.PaymentActor;
import com.arpitaajagekar.payflow.common.enums.PaymentEvent;
import com.arpitaajagekar.payflow.common.enums.PaymentStatus;
import com.arpitaajagekar.payflow.payment.entity.Payment;
import com.arpitaajagekar.payflow.payment.entity.PaymentTransitionLog;
import com.arpitaajagekar.payflow.payment.repository.PaymentTransitionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentTransitionService {

    private final PaymentTransitionLogRepository paymentTransitionLogRepository;
    private final PaymentStateMachine paymentStateMachine;

    public PaymentStatus apply(Payment payment, PaymentEvent event) {
        PaymentStatus next = paymentStateMachine.transition(payment.getStatus(), event);
        PaymentTransitionLog log = PaymentTransitionLog.builder()
                .payment(payment)
                .fromStatus(payment.getStatus())
                .event(event)
                .toStatus(next)
                .actor(PaymentActor.SYSTEM) //TODO: fetch merchant context to identify actor
                .occurredAt(LocalDateTime.now())
                .build();
        payment.setStatus(next);
        paymentTransitionLogRepository.save(log);
        return next;
    }
}
