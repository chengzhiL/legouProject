package com.lcz.legou.item.dao;

import com.lcz.legou.core.dao.ICrudDao;
import com.lcz.legou.item.po.SpecGroup;

import java.util.List;

public interface SpecGroupDao extends ICrudDao<SpecGroup> {

    /**
     * 根据实体类的条件生成动态sql语句查询规格分组
     * @param specGroup
     * @return
     */
    public List<SpecGroup> selectList(SpecGroup specGroup);

}
