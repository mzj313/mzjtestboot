package org.mzj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mzj.test.MyApplication;
import org.mzj.test.controller.AnimalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mzj
 * @date 2018/12/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class, properties = {"spring.profiles.active=local"})
public class AnimalTest {
    @Autowired
    AnimalController controller;

    @Test
    public void testByNameType() {
        controller.call();
    }
}
