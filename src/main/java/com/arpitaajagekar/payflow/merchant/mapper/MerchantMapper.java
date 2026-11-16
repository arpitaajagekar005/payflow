package com.arpitaajagekar.payflow.merchant.mapper;

import com.arpitaajagekar.payflow.merchant.dto.request.MerchantSignupRequest;
import com.arpitaajagekar.payflow.merchant.dto.response.MerchantResponse;
import com.arpitaajagekar.payflow.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {

    Merchant toEntityFromSignUpRequest(MerchantSignupRequest request);

    MerchantResponse toResponse(Merchant merchant);
}
