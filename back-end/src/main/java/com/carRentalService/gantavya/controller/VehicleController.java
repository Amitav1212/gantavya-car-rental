package com.carRentalService.gantavya.controller;

import com.carRentalService.gantavya.constants.PathConstant;
import com.carRentalService.gantavya.request.vehicle.VehicleCreateRequest;
import com.carRentalService.gantavya.request.vehicle.VehicleModifyRequest;
import com.carRentalService.gantavya.response.SearchResponse;
import com.carRentalService.gantavya.response.ServerResponse;
import com.carRentalService.gantavya.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Validated
@RequestMapping(PathConstant.GANTAVYA_ADMIN + PathConstant.VEHICLE)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(PathConstant.FETCH_ALL_VEHICLES)
    public  ResponseEntity<SearchResponse> fetchAllVehicle(
            @RequestParam Map<String, String> allRequestParams,
            @RequestParam(required = false) String vehicleType
    ){
        return vehicleService.fetchAllVehicle(allRequestParams);
    }

    @PostMapping(PathConstant.CREATE_VEHICLE)
    public ResponseEntity<ServerResponse> createVehicle(
            @RequestBody VehicleCreateRequest vehicleCreateRequest) {
        return vehicleService.createVehicle(vehicleCreateRequest);
    }

    @PostMapping(PathConstant.MODIFY_VEHICLE)
    public ResponseEntity<ServerResponse> modifyVehicle(
            @RequestBody VehicleModifyRequest vehicleModifyRequest){
        return vehicleService.modifyVehicle(vehicleModifyRequest);
    }
}
