package org.mzj.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzj
 */
@RestController
@RequestMapping("")
public class RootController {

    @RequestMapping("")
    public String test() {
        return "success";
    }
}
