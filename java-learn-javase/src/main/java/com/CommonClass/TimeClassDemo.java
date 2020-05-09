package com.CommonClass;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @author KyrieXu
 * @date 2020/1/28 14:24
 **/
public class TimeClassDemo {

    /**
     *  LocalDate、LocalTime、LocalDateTime 三者的比较
     */
    @Test
    public void Jdk8TimeApi(){
//        now()获取当前的时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);  // 2020-01-28
        System.out.println(localTime);  // 14:30:02.251698800
        System.out.println(localDateTime);  // 2020-01-28T14:30:02.251698800

//        of()获取指定时间的日期

        // 高并发下使用这个时间API能解决system.currentmillions生成时间戳速度慢的问题
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
    }
}
