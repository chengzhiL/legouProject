package com.lcz.legou.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lcz.legou.item.service.ISpecParamService;
import com.lcz.legou.core.service.impl.CrudServiceImpl;
import com.lcz.legou.item.po.SpecParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecParamServiceImpl extends CrudServiceImpl<SpecParam> implements ISpecParamService {

    @Override
    public List<SpecParam> list(SpecParam entity) {
        QueryWrapper<SpecParam> queryWrapper = Wrappers.<SpecParam>query();
        //根据分类id查询规格参数
        if (null != entity.getCid()) {
            queryWrapper.eq("cid_", entity.getCid());
        }
        if (null != entity.getSearching()) {
            queryWrapper.eq("searching_", entity.getSearching());
        }
        return getBaseMapper().selectList(queryWrapper);
    }
}