package com.axue.solution.order.service.impl;

import com.axue.solution.order.entity.po.OrderInfo;
import com.axue.solution.order.mapper.OrderInfoMapper;
import com.axue.solution.order.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
