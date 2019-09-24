package org.mzj.test.controller;

import org.mzj.test.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> msgs = new ArrayList<>();
        msgs.add(catServiceImpl.call());
        msgs.add(dogService.call());
        msgs.add(pig.call());
        msgs.add(pig1.call());
        return msgs.stream().collect(Collectors.joining("\n")) + "\n";
    }
}
