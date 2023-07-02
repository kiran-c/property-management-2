package com.accres.property.management.controller;

import com.accres.property.management.model.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping("/dummyurl")
public class TestController {

    //http://localhost:8080/dummyurl/v1/10.0/10.0
    @GetMapping("/v1/{p1}/{p2}")
    public Double addv1(@PathVariable("p1") Double var1, @PathVariable("p2") Double var2)
    {
        return var1 + var2;
    }

    //http://localhost:8080/dummyurl/v2?p1=10.0&p2=20.0
    @GetMapping("/v2")
    public Double addv2(@RequestParam("p1") Double var1, @RequestParam("p2") Double var2)
    {
        return var1 + var2;
    }


    @GetMapping("/v3/{p1}")
    public Double mul(@PathVariable("p1") Double var1, @RequestParam("p2") Double var2)
    {
        return var1 * var2;
    }

    @PostMapping("/v1")
    public ResponseEntity postTest(@RequestBody CalculatorDTO dto)
    {
           Double  res = dto.getNum1() + dto.getNum2() + dto.getNum3();
        ResponseEntity<Double> resEn = new ResponseEntity<>(res, HttpStatus.CREATED);

        return resEn;
    }
}
