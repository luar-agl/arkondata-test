 package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.dto.ResponseTownHallDTO;
import com.raulagl.arkondatatest.dto.TownHallDTO;

import java.util.List;

public interface TownHallService {

    List<ResponseTownHallDTO> getAll();

    /**
     * get number of registers in the table vehicle
     * @return long
     */
    long count();

    void save(TownHallDTO townHallDTO);
}
