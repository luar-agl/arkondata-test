package com.raulagl.arkondatatest.job;

import com.raulagl.arkondatatest.services.LoadDataVehicleService;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Singleton
public class LoadDataCDMXJob {


    private final LoadDataVehicleService loadDataVehicleService;

    public LoadDataCDMXJob(LoadDataVehicleService loadDataVehicleService) {
        this.loadDataVehicleService = loadDataVehicleService;
    }


    @Scheduled(fixedDelay = "60s", initialDelay = "60s")
    void execute() {
        log.info("Simple Job every 60 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        this.loadDataVehicleService.loadDataVehiclesJob();
    }

}
