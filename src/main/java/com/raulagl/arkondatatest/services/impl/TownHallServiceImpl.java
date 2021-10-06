package com.raulagl.arkondatatest.services.impl;

import com.raulagl.arkondatatest.domain.TownHall;
import com.raulagl.arkondatatest.dto.ResponseTownHallDTO;
import com.raulagl.arkondatatest.mapper.util.ModelMapperUtils;
import com.raulagl.arkondatatest.repositories.TownHallRepository;
import com.raulagl.arkondatatest.services.TownHallService;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class TownHallServiceImpl implements TownHallService {

    private final TownHallRepository townHallRepository;

    public TownHallServiceImpl(
            TownHallRepository townHallRepository ) {
        this.townHallRepository = townHallRepository;
    }


    @Override
    public List<ResponseTownHallDTO> getAll() {
        List<TownHall> townHalls = this.townHallRepository.findAll();
        return ModelMapperUtils.mapAll( townHalls, ResponseTownHallDTO.class );
    }
}
