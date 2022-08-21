package com.lcz.legou.item.service;

import com.lcz.legou.core.service.ICrudService;
import com.lcz.legou.item.po.Brand;
import com.lcz.legou.item.po.Category;

import java.util.List;

public interface IBrandService extends ICrudService<Brand> {

    /**
     * 根据商品id查询分类
     * @param id
     * @return
     */
    public List<Category> selectCategoryByBrand(Long id);

    /**
     * 根据品牌Id查询全部信息
     */
    public Object getBrandId(Long id);



}
