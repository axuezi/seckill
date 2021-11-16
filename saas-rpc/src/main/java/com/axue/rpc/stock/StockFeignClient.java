package com.axue.rpc.stock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 添加feign接口的方法
 * name 指定调用rest接口所对应的服务名
 * path 指定调用rest接口所在的StockInfoController指定的@RequestMapping
 *
 * @author axue
 */
@FeignClient(value = "saas-solution-stock", path = "/solution/stock")
public interface StockFeignClient {

    /**
     * 获取库存数量
     */
    @GetMapping("/stock-info/getStock")
    void getStock();

}
