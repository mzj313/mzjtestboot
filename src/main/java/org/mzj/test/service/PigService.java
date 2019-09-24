package org.mzj.test.service;

import org.springframework.stereotype.Service;

/**
 * @author mzj
 * @date 2018/12/17
 */
@Service("pig")
public class PigService implements AnimalService {
    @Override
    public String call() {
        String msg = "哼哼哼";
        System.out.println(msg);
        return msg;
    }
}
