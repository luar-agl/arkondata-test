package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;

import java.util.List;

public interface VehicleService {

    List<ResponseVehicleDTO> getAllVehiclesAvailable();
}
