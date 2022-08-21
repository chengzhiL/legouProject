package com.lcz.legou.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lcz.legou.core.service.impl.CrudServiceImpl;
import com.lcz.legou.item.po.Category;
import com.lcz.legou.item.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category> implements ICategoryService {

    @Override
    public List<Category> list(Category entity) {
        QueryWrapper<Category>  queryWrapper = Wrappers.query();
        if (StringUtils.isNotEmpty(entity.getTitle())) {
            queryWrapper.like("title_", entity.getTitle());
        }
        if (null != entity.getParentId()) {
            queryWrapper.eq("parent_id_", entity.getParentId());
        }
        if (null != entity.getIsRoot() && entity.getIsRoot().equals(1)) {
            queryWrapper.isNull("parent_id_");
        }

        return getBaseMapper().selectList(queryWrapper);
    }
}
