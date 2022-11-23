package com.heidelberg.screen.util;


import com.heidelberg.screen.service.ScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
@Slf4j
public class ScheduleJob {

    @Autowired
    private ScreenService screenService;

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?")
    public void yesterdayData() {
        //获取昨天日期
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        try {
            screenService.findScreenData(yesterday, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
