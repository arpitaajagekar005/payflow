package com.arpitaajagekar.payflow.operations.settlement;

import com.arpitaajagekar.payflow.common.entity.Money;
import com.arpitaajagekar.payflow.operations.settlement.dto.BankTransferResult;

import java.util.UUID;

public interface BankTransferProcessor {

    BankTransferResult initiate(UUID settlementId, UUID merchantId, Money amount,
                                String bankAccount, String ifsc);
}
