package com.arpitaajagekar.payflow.merchant.dto.response;

import com.arpitaajagekar.payflow.common.enums.BusinessType;
import com.arpitaajagekar.payflow.common.enums.MerchantStatus;
import lombok.Data;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
