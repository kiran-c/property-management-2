package com.accres.property.management.converter;

import com.accres.property.management.entity.PropertyEntity;
import com.accres.property.management.model.PropertyDTO;

public class PropertyConverter {

    public static PropertyEntity dto2EntityConverter(PropertyDTO propertyDTO)
    {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setPid(propertyDTO.getPid());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setPropertyType(propertyDTO.getPropertyType());
        propertyEntity.setLocation(propertyDTO.getLocation());

        return propertyEntity;
    }


    public static PropertyDTO entity2DtoConverter( PropertyEntity propertyEntity)
    {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPid(propertyEntity.getPid());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setPropertyType(propertyEntity.getPropertyType());
        propertyDTO.setLocation(propertyEntity.getLocation());

        return propertyDTO;
    }
}
