package com.raulagl.arkondatatest.services;

public interface LoadDataVehicleService {

    /**
     * consult data public from api and insert all data (vehicles, town halls)
     */
    void loadDataVehicles();

    /**
     * in charge of consulting the data from api and validate if this data exists in the database, if not exists
     * create a new record with the new data and if exists do nothing
     */
    void loadDataVehiclesJob();
}
