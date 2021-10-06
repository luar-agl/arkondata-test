package com.raulagl.arkondatatest.services.impl;

import com.raulagl.arkondatatest.client.DataCDMXApiClient;
import com.raulagl.arkondatatest.domain.TownHall;
import com.raulagl.arkondatatest.dto.ResponseTownHallDTO;
import com.raulagl.arkondatatest.dto.TownHallDTO;
import com.raulagl.arkondatatest.mapper.util.ModelMapperUtils;
import com.raulagl.arkondatatest.repositories.TownHallRepository;
import com.raulagl.arkondatatest.services.TownHallService;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class TownHallServiceImpl implements TownHallService {

    private final TownHallRepository townHallRepository;
    private final DataCDMXApiClient dataCDMXApiClient;

    public TownHallServiceImpl(
            TownHallRepository townHallRepository,
            DataCDMXApiClient dataCDMXApiClient) {
        this.townHallRepository = townHallRepository;
        this.dataCDMXApiClient = dataCDMXApiClient;
    }


    @Override
    public List<ResponseTownHallDTO> getAll() {
        List<TownHall> townHalls = this.townHallRepository.findAll();
        return ModelMapperUtils.mapAll( townHalls, ResponseTownHallDTO.class );
    }

    @Override
    public void loadDataTownHalls() {
        long size = this.count();
        if ( size == 0 ) {
            this.dataCDMXApiClient
                    .getDataOfTownHall()
                    .getResult()
                    .getRecords()
                    .forEach( this::save );
        }
    }

    @Override
    public long count() {
        return this.townHallRepository.count();
    }

    private void save(TownHallDTO townHallDTO) {
        final TownHall townHall = ModelMapperUtils
                .map( townHallDTO, TownHall.class );
        this.townHallRepository.save( townHall );
    }
}
