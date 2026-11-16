package com.arpitaajagekar.payflow.merchant.service;

import com.arpitaajagekar.payflow.merchant.dto.request.LoginRequest;
import com.arpitaajagekar.payflow.merchant.dto.request.MerchantSignupRequest;
import com.arpitaajagekar.payflow.merchant.dto.response.LoginResponse;
import com.arpitaajagekar.payflow.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);

    LoginResponse login(LoginRequest request);
}
