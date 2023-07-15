package com.accres.property.management.impl;


import com.accres.property.management.converter.PropertyConverter;
import com.accres.property.management.entity.PropertyEntity;
import com.accres.property.management.model.PropertyDTO;
import com.accres.property.management.repository.PropertyRepository;
import com.accres.property.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
      PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = PropertyConverter.dto2EntityConverter(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        propertyDTO = PropertyConverter.entity2DtoConverter(propertyEntity);

        return propertyDTO;
    }


    @Override
   public List<PropertyDTO> getAllProperty()
    {

       List<PropertyEntity> entityList = (List<PropertyEntity>)propertyRepository.findAll();
       List<PropertyDTO> dtoList = new ArrayList<>();

       for(PropertyEntity entity : entityList)
       {
           dtoList.add(PropertyConverter.entity2DtoConverter(entity));
       }
        return dtoList;
    }

    @Override
    public PropertyDTO getPropertyById(Long pid) {

        Optional<PropertyEntity> optEntity = propertyRepository.findById(pid);
        PropertyDTO propertyDTO = null;

        if(optEntity.isPresent())
        {
            PropertyEntity entity = optEntity.get();
            propertyDTO = PropertyConverter.entity2DtoConverter(entity);
        }

        return propertyDTO;
    }

    @Override
    public void deletePropertyById(Long pid) {

        propertyRepository.deleteById(pid);
        System.out.println("Property with id: "+pid+" has been deleted" );

    }

    @Override
    public PropertyDTO updatePropertyById(PropertyDTO propertyDTO, Long pid)
    {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(pid);

        if(optEntity.isPresent())
        {
            PropertyEntity entity = optEntity.get();
            entity.setPropertyType(propertyDTO.getPropertyType());
            entity.setPrice(propertyDTO.getPrice());
            entity.setLocation(propertyDTO.getLocation());

            propertyDTO = PropertyConverter.entity2DtoConverter(entity);
            propertyRepository.save(entity);
        }

        return propertyDTO;
    }

    @Override
    public PropertyDTO updatePropertyPrice(Long pid, PropertyDTO propertyDTO)
    {
       Optional<PropertyEntity> entity =  propertyRepository.findById(pid);
        PropertyDTO dto = null;
       if(entity.isPresent())
       {
           PropertyEntity en = entity.get();
           en.setPrice(propertyDTO.getPrice());
           dto = PropertyConverter.entity2DtoConverter(en);
           propertyRepository.save(en);

       }

        return dto;
    }
}
