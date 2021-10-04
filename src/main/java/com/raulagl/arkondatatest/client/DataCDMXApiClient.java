package com.raulagl.arkondatatest.client;

import com.raulagl.arkondatatest.dto.ResponseDataCDMXDTO;

import com.raulagl.arkondatatest.dto.VehicleDTO;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("https://datos.cdmx.gob.mx/api/3/action")
public interface DataCDMXApiClient {

    @Get( "/datastore_search_sql?sql=SELECT%20*%20from%20%22ad360a0e-b42f-482c-af12-1fd72140032e%22" )
    ResponseDataCDMXDTO<VehicleDTO> getDataOfBuses();


}

