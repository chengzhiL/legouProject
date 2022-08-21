package com.lcz.legou.item.controller;

import com.lcz.legou.core.controller.BaseController;
import com.lcz.legou.item.po.Brand;
import com.lcz.legou.item.po.Category;
import com.lcz.legou.item.service.IBrandService;
import com.lcz.legou.item.service.impl.BrandServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/brand")
@CrossOrigin
public class BrandController extends BaseController<IBrandService, Brand> {

    @Override
    public void afterEdit(Brand entity) {
        //得到品牌的所属分类
        List<Category> categories = service.selectCategoryByBrand(entity.getId());
        Long[] ids = new Long[categories.size()];
        for (int i=0; i < categories.size(); i++) {
            ids[i] = categories.get(i).getId();
        }
        entity.setCategoryIds(ids);
    }

    /**
     * 根据品牌Id 查询
     */
    @GetMapping("/get/{id}")
    public Object getRouteById(@PathVariable("id") Long id) {
        Object obj = service.getBrandId(id);
        return obj;
    }





}
