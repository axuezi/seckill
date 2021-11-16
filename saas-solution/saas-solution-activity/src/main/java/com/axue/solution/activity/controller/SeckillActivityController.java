package com.axue.solution.activity.controller;

import com.axue.rpc.stock.StockFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 秒杀活动 前端控制器
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Slf4j
@RestController
@RequestMapping("/solution/activity/seckill-activity")
public class SeckillActivityController {

    @Resource
    StockFeignClient stockFeignClient;

    @GetMapping("/getSeckill")
    public void getSeckill() {
        stockFeignClient.getStock();
        log.info("--->{}", "秒杀活动成功");
    }

}
