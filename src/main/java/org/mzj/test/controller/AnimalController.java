package org.mzj.test.controller;

import org.mzj.test.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzj
 * @date 2018/12/14
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService catServiceImpl;
    @Autowired
    private AnimalService dogService;
    @Autowired
    private AnimalService pig;
    @Autowired
    @Qualifier("pig")
    private AnimalService pig1;

    @RequestMapping("/call")
    public String call(){
        catServiceImpl.call();
        dogService.call();
        pig.call();
        pig1.call();
        return "success";
    }
}
