package com.raulagl.arkondatatest.services.impl;

import com.raulagl.arkondatatest.domain.Vehicle;
import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;
import com.raulagl.arkondatatest.mapper.util.ModelMapperUtils;
import com.raulagl.arkondatatest.repositories.VehicleRepository;
import com.raulagl.arkondatatest.services.VehicleService;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

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

    @Override
    public long count() {
        return this.vehicleRepository.count();
    }

    @Override
    public void save(Vehicle vehicle) {
        this.vehicleRepository.save( vehicle );
    }

    @Override
    public Optional<Vehicle> findByIdProvided(Long idProvided) {
        return this.vehicleRepository.findByIdProvided( idProvided );
    }

    @Override
    public List<ResponseVehicleDTO> findLocationsByVehicleId(Long vehicleId) {
        List<Vehicle> vehicles = this.vehicleRepository.findByVehicleId( vehicleId );
        return ModelMapperUtils.mapAll( vehicles, ResponseVehicleDTO.class );
    }
}

