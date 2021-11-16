package com.axue.solution.stock.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author axue
 * @since 2021-11-13
 */
@Slf4j
@RestController
@RequestMapping("/solution/stock/stock-info")
public class StockInfoController {

    /**
     * 查看库存
     */
    @GetMapping("/getStock")
    public void getStock() {
        log.info("查看库存:{}", "11111111111");
    }

    /**
     * 减去库存
     */
    @PostMapping("/subtractStock")
    public void subtractStock() {
        log.info("减去库存:{}", "11111111111");
    }

}
