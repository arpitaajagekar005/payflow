package com.arpitaajagekar.payflow.merchant.dto.request;

import com.arpitaajagekar.payflow.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
