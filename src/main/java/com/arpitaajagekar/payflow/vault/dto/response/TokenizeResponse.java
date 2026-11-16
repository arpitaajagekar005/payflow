package com.arpitaajagekar.payflow.vault.dto.response;

import com.arpitaajagekar.payflow.common.enums.CardBrand;

public record TokenizeResponse(
        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
