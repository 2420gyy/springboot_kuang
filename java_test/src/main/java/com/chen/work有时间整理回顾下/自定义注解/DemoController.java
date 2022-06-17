package com.chen.work有时间整理回顾下.自定义注解;

//@Slf4j
// @RestController
// @RequestMapping("/demo")
public class DemoController {

    @MyLog("test-hello")
    // @GetMapping("/hello")
    public String hello() {
//        log.info("真实的方法执行");
        return "sss";
    }
}