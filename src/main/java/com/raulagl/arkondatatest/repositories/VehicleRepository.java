package com.raulagl.arkondatatest.repositories;

import com.raulagl.arkondatatest.domain.Vehicle;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> { }
