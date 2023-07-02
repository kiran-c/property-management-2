package com.accres.property.management.service;

import com.accres.property.management.model.PropertyDTO;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    public List<PropertyDTO> getAllProperty();

     public PropertyDTO updatePropertyById(PropertyDTO propertyDTO, Long pid);

    public PropertyDTO getPropertyById(Long pid);
    public void deletePropertyById(Long pid);

    public PropertyDTO updatePropertyPrice(Long pid, PropertyDTO propertyDTO);
}
