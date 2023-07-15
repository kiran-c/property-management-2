package com.accres.property.management.impl;

import com.accres.property.management.converter.OwnerConverter;
import com.accres.property.management.entity.OwnerEntity;
import com.accres.property.management.model.OwnerDTO;
import com.accres.property.management.repository.OwnerRepository;
import com.accres.property.management.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public OwnerDTO register(OwnerDTO ownerDTO) {

        OwnerEntity entity  = OwnerConverter.dto2EntityConverter(ownerDTO);
        entity =  ownerRepository.save(entity);
        ownerDTO = OwnerConverter.entity2DTOConverter(entity);
        return ownerDTO;
    }

    @Override
    public OwnerDTO login(String ownerEmail, String password) {

        Optional<OwnerEntity> optionalOwnerEntity = ownerRepository.findByOwnerEmailAndPassword(ownerEmail, password);

        OwnerDTO dto = null;

        if(optionalOwnerEntity.isPresent())
        {
          /* dto.setOwnerId(optionalOwnerEntity.get().getOwnerId());
           dto.setOwnerName(optionalOwnerEntity.get().getOwnerName());
           dto.setOwnerEmail(optionalOwnerEntity.get().getOwnerEmail());
           dto.setPassword(optionalOwnerEntity.get().getPassword());
           dto.setPhone(optionalOwnerEntity.get().getPhone());*/

            OwnerEntity entity = optionalOwnerEntity.get();
            dto = OwnerConverter.entity2DTOConverter(entity);

        }

        return dto;
    }
}
