package com.qiyemodu.springbootpoi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiYeMoDu
 * @version 1.0
 * ===========================================================
 * @function 这个类用来测试新建的springboot工程是否可用
 * ===========================================================
 * @date 2019/12/20 22:14
 */
@RestController
public class StartTest {

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

}
