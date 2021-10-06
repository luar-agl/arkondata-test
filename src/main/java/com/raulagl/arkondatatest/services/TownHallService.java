 package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.dto.ResponseTownHallDTO;

import java.util.List;

public interface TownHallService {

    List<ResponseTownHallDTO> getAll();

    /**
     * method in charge of save the public data of cdmx in the database
     */
    void loadDataTownHalls();

    /**
     * get number of registers in the table vehicle
     * @return long
     */
    long count();
}
