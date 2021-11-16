package com.axue.solution.stock.service.impl;

import com.axue.solution.stock.entity.po.StockInfo;
import com.axue.solution.stock.mapper.StockInfoMapper;
import com.axue.solution.stock.service.IStockInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author axue
 * @since 2021-11-13
 */
@Service
public class StockInfoServiceImpl extends ServiceImpl<StockInfoMapper, StockInfo> implements IStockInfoService {

}
