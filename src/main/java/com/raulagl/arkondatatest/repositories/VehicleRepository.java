package com.raulagl.arkondatatest.repositories;

import com.raulagl.arkondatatest.domain.Vehicle;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /**
     *
     * @param status
     * In charge of get all vehicle by current status:  1 available 2 unavailable
     * @return List<Vehicle>
     */
    List<Vehicle> findByVehicleCurrentStatus( Integer status );

    /**
     *
     * @param townHallId
     * in charge of get all vehicle by id of town hall
     * @return List<Vehicle>
     */
    List<Vehicle> findByTownHallId( Long townHallId );


    /**
     *
     * @param idProvided
     * in charge of search by id provided by api of public data cdmx
     * @return Optional<Vehicle>
     */
    Optional<Vehicle> findByIdProvided( Long idProvided );
}
