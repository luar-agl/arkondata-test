package com.raulagl.arkondatatest.repositories;

import com.raulagl.arkondatatest.domain.Vehicle;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByVehicleCurrentStatus(Integer status);
}
