package com.lcz.legou.item.service.impl;

import com.lcz.legou.item.dao.BrandDao;
import com.lcz.legou.core.service.impl.CrudServiceImpl;
import com.lcz.legou.item.po.Brand;
import com.lcz.legou.item.po.Category;
import com.lcz.legou.item.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl extends CrudServiceImpl<Brand> implements IBrandService {
    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    @Transactional(readOnly = false)
    public boolean saveOrUpdate(Brand entity) {
        boolean result = super.saveOrUpdate(entity);

        //删除商品和分类的关联
        ((BrandDao) getBaseMapper()).deleteCategoryByBrand(entity.getId());

        //添加商品和分类的关联
        Long[] categoryIds = entity.getCategoryIds();
        if (null != categoryIds) {
            for (Long categoryId : categoryIds) {
                ((BrandDao) getBaseMapper()).insertCategoryAndBrand(categoryId, entity.getId());
            }
        }

        return result;
    }

    @Override
    public List<Category> selectCategoryByBrand(Long id) {
        return ((BrandDao) getBaseMapper()).selectCategoryByBrand(id);
    }

    @Override
    public Object getBrandId(Long id) {
        //1. 先从缓存中取，如果有则直接返回
        //2. 如果无， 则查询mysql,并将数据设置到缓存
        String key = "route:" + id;
        Object brandObj = redisTemplate.opsForValue().get(key);
        if (brandObj == null) {
            synchronized (this.getClass()) {
                brandObj = redisTemplate.opsForValue().get(key);
                if (brandObj == null) {
                    log.debug("----> 查询数据库..............");
                    // 查数据库
                    Brand brand = ((BrandDao) getBaseMapper()).selectById(id);
                    redisTemplate.opsForValue().set(key, brand);
                    return brand;
                } else {
                    log.debug("----> 查询缓存(同步代码块)>>>>>>>>>>>>>>>>>");
                    return brandObj;
                }
            }
        }else{
            log.debug("----> 查询缓存>>>>>>>>>>>>>>>>>");
        }
        return brandObj;

    }
}
