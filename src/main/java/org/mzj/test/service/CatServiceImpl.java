package org.mzj.test.service;

import org.springframework.stereotype.Service;

/**
 * @author mzj
 * @date 2018/12/14
 */
@Service
public class CatServiceImpl implements AnimalService {
    @Override
    public String call() {
        String msg = "喵喵喵";
        System.out.println(msg);
        return msg;
    }
}
