package org.mzj.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzj
 */
@RestController
@RequestMapping("")
public class RootController {
    /*
     使用 curl http://localhost:8280/mzjtestboot 无响应
     使用 curl http://localhost:8280/mzjtestboot/ 优先级为先"/"后""
     */
    /*
    @RequestMapping("/")
    public String index1() {
        return "success1";
    }
    */

    @RequestMapping("")
    public String index2() {
        return "success2";
    }
}
