package org.mzj.test.service;

import org.springframework.stereotype.Service;

/**
 * @author mzj
 * @date 2018/12/17
 */
@Service("pig")
public class PigService implements AnimalService {
    @Override
    public void call() {
        System.out.println("哼哼哼");
    }
}
