package com.raulagl.arkondatatest.listener;

import com.raulagl.arkondatatest.services.LoadDataTownHallService;
import com.raulagl.arkondatatest.services.LoadDataVehicleService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Singleton
@Requires(notEnv = Environment.TEST) // Don't load data in tests.
class LoaderListener {



    private final LoadDataTownHallService loadDataTownHallService;
    private final LoadDataVehicleService loadDataVehicleService;

    LoaderListener(
            LoadDataTownHallService loadDataTownHallService,
            LoadDataVehicleService loadDataVehicleService ) {
        this.loadDataTownHallService = loadDataTownHallService;
        this.loadDataVehicleService = loadDataVehicleService;
    }


    @Async
    @EventListener
    public void loadDataOfCDMX(final StartupEvent event) {
        log.info("Loading data at startup " + event);
        this.loadDataTownHallService.loadDataTownHalls();
        this.loadDataVehicleService.loadDataVehicles();
    }


}
