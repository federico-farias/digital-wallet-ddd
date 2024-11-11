package com.bintics.adapters.in.apis.rest.controller;

import com.bintics.adapters.in.apis.rest.dto.response.CustomResponseDTO;
import org.springframework.http.ResponseEntity;

import static com.bintics.adapters.in.apis.rest.controller.constants.MessageConstants.MSG_RESPONSE_ERROR;

public abstract class GenericController {

    public ResponseEntity<CustomResponseDTO> ok(){
        CustomResponseDTO customResponseDTO = new CustomResponseDTO("/api/v1/customer", "200", "", null);
        return ResponseEntity.ok(customResponseDTO);
    }

    public ResponseEntity<CustomResponseDTO> error(){
        CustomResponseDTO customResponseDTO = new CustomResponseDTO("/api/v1/customer", "500", MSG_RESPONSE_ERROR, null);
        return ResponseEntity.internalServerError().body(customResponseDTO);
    }

    public ResponseEntity<CustomResponseDTO> created(Object response){
        CustomResponseDTO customResponseDTO = new CustomResponseDTO("/api/v1/customer", "201", "", response);
        return ResponseEntity.ok(customResponseDTO);
    }
}
