package com.arpitaajagekar.payflow.merchant.api;

import com.arpitaajagekar.payflow.common.dto.SettlementBankDetails;
import com.arpitaajagekar.payflow.common.dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantLookupService {

    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);

    List<UUID> listActiveMerchantIds();

    SettlementBankDetails getSettlementBankDetails(UUID merchantId);

}
