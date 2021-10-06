package com.raulagl.arkondatatest.controllers;


import com.raulagl.arkondatatest.dto.ResponseTownHallDTO;
import com.raulagl.arkondatatest.services.TownHallService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/townHall")
public class TownHallController {

    private final TownHallService townHallService;


    public TownHallController(TownHallService townHallService) {
        this.townHallService = townHallService;
    }

    @Get( value = "/available" )
    public List<ResponseTownHallDTO> getAllAvailable() {
        return this.townHallService.getAll();
    }

}
