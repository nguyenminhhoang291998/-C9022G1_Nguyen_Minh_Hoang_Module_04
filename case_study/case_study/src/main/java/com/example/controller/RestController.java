package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.service.IContractDetailDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("api")
public class RestController {
    @Autowired
    private IContractDetailDtoService contractDetailDtoService;

    @GetMapping("contractDetail")
    public ResponseEntity<List<ContractDetailDto>> findAll(@RequestParam int contractId){
        List<ContractDetailDto> contractDetailDtoList = contractDetailDtoService.findAll(contractId);
        if(contractDetailDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailDtoList,HttpStatus.OK);
    }
//
//    @PostMapping("getTotal")
//    public ResponseEntity<Double> getTotal(@RequestBody){
//
//    }


}
