package com.raulagl.arkondatatest.services.impl;

import com.raulagl.arkondatatest.domain.Vehicle;
import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;
import com.raulagl.arkondatatest.mapper.util.ModelMapperUtils;
import com.raulagl.arkondatatest.repositories.VehicleRepository;
import com.raulagl.arkondatatest.services.VehicleService;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<ResponseVehicleDTO> getAllVehiclesAvailable() {
        List<Vehicle> vehicles = this.vehicleRepository.findByVehicleCurrentStatus( 1 );
        return ModelMapperUtils.mapAll( vehicles, ResponseVehicleDTO.class );
    }

    @Override
    public List<ResponseVehicleDTO> getAllVehiclesByTownHall(Long id) {
        List<Vehicle> vehicles = this.vehicleRepository.findByTownHallId( id );
        return ModelMapperUtils.mapAll( vehicles, ResponseVehicleDTO.class );
    }
}

