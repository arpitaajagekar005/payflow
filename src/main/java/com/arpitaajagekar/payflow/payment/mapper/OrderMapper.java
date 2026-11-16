package com.arpitaajagekar.payflow.payment.mapper;

import com.arpitaajagekar.payflow.payment.dto.response.OrderResponse;
import com.arpitaajagekar.payflow.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toResponse(OrderRecord orderRecord);
}
