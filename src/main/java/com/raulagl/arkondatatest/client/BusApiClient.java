package com.raulagl.arkondatatest.client;

import com.raulagl.arkondatatest.dto.ResponseBusDTO;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@Client("https://datos.cdmx.gob.mx/api")
public interface BusApiClient {

    @Get("/3/action/datastore_search_sql?sql=SELECT%20*%20from%20%22ad360a0e-b42f-482c-af12-1fd72140032e%22")
    Publisher<ResponseBusDTO> getDataOfBuses();
}

