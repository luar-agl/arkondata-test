package com.raulagl.arkondatatest.repositories;

import com.raulagl.arkondatatest.domain.TownHall;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface TownHallRepository extends JpaRepository<TownHall, Long> {
}
