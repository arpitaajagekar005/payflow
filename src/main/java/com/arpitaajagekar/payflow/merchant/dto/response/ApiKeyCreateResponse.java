package com.arpitaajagekar.payflow.merchant.dto.response;

import com.arpitaajagekar.payflow.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}
