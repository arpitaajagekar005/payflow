package com.arpitaajagekar.payflow.merchant.mapper;

import com.arpitaajagekar.payflow.merchant.dto.response.ApiKeyCreateResponse;
import com.arpitaajagekar.payflow.merchant.dto.response.ApiKeyResponse;
import com.arpitaajagekar.payflow.merchant.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {

    ApiKeyCreateResponse toCreateResponse(ApiKey apiKey);

    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
