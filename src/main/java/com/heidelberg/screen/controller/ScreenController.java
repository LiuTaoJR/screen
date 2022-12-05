package com.heidelberg.screen.controller;


import com.heidelberg.screen.service.ScreenService;
import com.heidelberg.screen.vo.ResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @GetMapping("/findOrderInfo")
    public Object findOrderInfo(@RequestBody String time) {
        return screenService.findOrderInfo(time, 0);
    }

    @GetMapping("/findProduceInfo")
    public Object findProduceInfo(@RequestBody String time) {
        return screenService.findProduceInfo();
    }

    @GetMapping("/findFlowInfo")
    public Object findFlowInfo(@RequestBody String time) {
        return screenService.findFlowInfo(time, 0);
    }

    @GetMapping("/findOrderMonth")
    public Object findOrderMonth(@RequestBody String time) {
        return screenService.findOrderMonth(time, 0);
    }

    @GetMapping("/findScreenData")
    public ResVo findScreenData(String time) {
        try {
            return new ResVo("1", "success", screenService.findScreenData(time, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResVo("-1", "fail", null);
        }
    }

}
