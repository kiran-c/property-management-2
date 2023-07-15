package com.accres.property.management.controller;


import com.accres.property.management.model.OwnerDTO;
import com.accres.property.management.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<OwnerDTO> register(@RequestBody OwnerDTO ownerDTO)
    {
        ownerDTO = ownerService.register(ownerDTO);

        ResponseEntity<OwnerDTO> responseEntity = new ResponseEntity<>(ownerDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<OwnerDTO> login(@RequestBody OwnerDTO ownerDTO)
    {
        ownerDTO = ownerService.login(ownerDTO.getOwnerEmail(), ownerDTO.getPassword());

        ResponseEntity<OwnerDTO> responseEntity = new ResponseEntity<>(ownerDTO, HttpStatus.OK);

        return responseEntity;
    }
}
