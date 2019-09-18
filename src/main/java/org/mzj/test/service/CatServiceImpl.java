package org.mzj.test.service;

import org.springframework.stereotype.Service;

/**
 * @author mzj
 * @date 2018/12/14
 */
@Service
public class CatServiceImpl implements AnimalService {
    @Override
    public void call() {
        System.out.println("喵喵喵");
    }
}
