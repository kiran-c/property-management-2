package com.accres.property.management.controller;

import com.accres.property.management.model.PropertyDTO;
import com.accres.property.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    PropertyService service;

    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello";
    }

    @PostMapping("/property")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {

        propertyDTO = service.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }


   @GetMapping("/property")
    public ResponseEntity<List<PropertyDTO>> getAllProperty()
    {
        List<PropertyDTO> propertyList = service.getAllProperty();
        ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return response;
    }


    @PutMapping("/property/{pid}")
    public ResponseEntity<PropertyDTO> updatePropertyById(@RequestBody PropertyDTO propertyDTO, @PathVariable Long pid)
    {
        PropertyDTO property = service.updatePropertyById(propertyDTO, pid);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(property, HttpStatus.CREATED);
        return response;
    }


     @GetMapping("/property/{pid}")
    public ResponseEntity<PropertyDTO> getPropertyById(@RequestBody PropertyDTO propertyDTO, @PathVariable Long pid)
    {
        PropertyDTO property = service.getPropertyById(pid);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(property, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/property/{pid}")
    public ResponseEntity deletePropertyById(@PathVariable Long pid)
    {
        service.deletePropertyById(pid);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/property/update-propertyprice/{pid}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@PathVariable Long pid, @RequestBody PropertyDTO propertyDTO)
    {
        PropertyDTO dto = service.updatePropertyPrice(pid, propertyDTO);
        ResponseEntity response = new ResponseEntity<>(dto, HttpStatus.CREATED);
        return response;
    }
}
