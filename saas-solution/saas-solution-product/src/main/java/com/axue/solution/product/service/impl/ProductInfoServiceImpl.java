package com.axue.solution.product.service.impl;

import com.axue.solution.product.entity.po.ProductInfo;
import com.axue.solution.product.mapper.ProductInfoMapper;
import com.axue.solution.product.service.IProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author axue
 * @since 2021-11-11
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {

}
