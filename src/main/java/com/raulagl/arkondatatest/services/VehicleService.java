package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> getAllVehiclesAvailable();
}
