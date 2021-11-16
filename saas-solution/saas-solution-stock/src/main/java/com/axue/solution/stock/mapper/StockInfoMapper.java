package com.axue.solution.stock.mapper;

import com.axue.solution.stock.entity.po.StockInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 库存表 Mapper 接口
 * </p>
 *
 * @author axue
 * @since 2021-11-13
 */
@Mapper
public interface StockInfoMapper extends BaseMapper<StockInfo> {

}
