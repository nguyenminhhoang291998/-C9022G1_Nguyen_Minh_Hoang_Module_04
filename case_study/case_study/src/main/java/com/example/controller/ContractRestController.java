package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.IContractDetailDto;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.service.IContractDetailService;
import com.example.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class ContractRestController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("contractDetail")
    public ResponseEntity<List<IContractDetailDto>> findAll(@RequestParam int contractId) {
        List<IContractDetailDto> contractDetailDtoList = contractService.findContractDetailByContractId(contractId);
        if (contractDetailDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "contract/save")
    public ResponseEntity save(@RequestBody List<ContractDetailDto> contractDetailDtoList) {
        if(contractDetailDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDetailDtoList.get(0).getContractDto(), contract);
        contractService.save(contract);
        for (ContractDetailDto ct: contractDetailDtoList) {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(ct,contractDetail);
            contractDetail.setContract(contract);
            contractDetailService.save(contractDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
