package com.accres.property.management.service;

import com.accres.property.management.model.OwnerDTO;

public interface OwnerService {

    OwnerDTO register(OwnerDTO ownerDTO);
    OwnerDTO login(String ownerEmail, String password);
}
