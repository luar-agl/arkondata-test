package com.raulagl.arkondatatest.services.impl;

import com.raulagl.arkondatatest.client.DataCDMXApiClient;
import com.raulagl.arkondatatest.services.LoadDataTownHallService;
import com.raulagl.arkondatatest.services.TownHallService;
import jakarta.inject.Singleton;

@Singleton
public class LoadDataTownHallServiceImpl implements LoadDataTownHallService {

    private final TownHallService townHallService;
    private final DataCDMXApiClient dataCDMXApiClient;

    public LoadDataTownHallServiceImpl(TownHallService townHallService, DataCDMXApiClient dataCDMXApiClient) {
        this.townHallService = townHallService;
        this.dataCDMXApiClient = dataCDMXApiClient;
    }


    @Override
    public void loadDataTownHalls() {
        long size = this.townHallService.count();
        if ( size == 0 ) {
            this.dataCDMXApiClient
                    .getDataOfTownHall()
                    .getResult()
                    .getRecords()
                    .forEach(this.townHallService::save);
        }
    }
}
