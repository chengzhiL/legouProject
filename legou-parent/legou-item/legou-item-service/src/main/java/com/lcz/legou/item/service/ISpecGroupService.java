package com.lcz.legou.item.service;

import com.lcz.legou.core.service.ICrudService;
import com.lcz.legou.item.po.SpecGroup;

import java.util.List;


public interface ISpecGroupService extends ICrudService<SpecGroup> {

    /**
     * 根据前端传递的规格参数列表，保存规格参数
     * @param cid 分类ID
     * @param groups 前端传递的分组列表[{}cid:1,name:'',params:[..]},....]
     */
    public void saveGroup(Long cid, List<SpecGroup> groups);

}
