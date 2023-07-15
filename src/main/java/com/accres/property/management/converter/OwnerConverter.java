package com.accres.property.management.converter;

import com.accres.property.management.entity.OwnerEntity;
import com.accres.property.management.model.OwnerDTO;

public class OwnerConverter {

    public static OwnerEntity dto2EntityConverter(OwnerDTO dto)
    {
        OwnerEntity entity = new OwnerEntity();
        entity.setOwnerId(dto.getOwnerId());
        entity.setOwnerName(dto.getOwnerName());
        entity.setOwnerEmail(dto.getOwnerEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public static OwnerDTO entity2DTOConverter(OwnerEntity entity)
    {
        OwnerDTO dto = new OwnerDTO();
        dto.setOwnerId(entity.getOwnerId());
        dto.setOwnerName(entity.getOwnerName());
        dto.setOwnerEmail(entity.getOwnerEmail());
       // dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());

        return dto;

    }
}
