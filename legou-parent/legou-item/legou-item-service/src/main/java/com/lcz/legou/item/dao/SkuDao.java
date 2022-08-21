package com.lcz.legou.item.dao;

import com.lcz.legou.core.dao.ICrudDao;
import com.lcz.legou.item.po.Sku;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SkuDao extends ICrudDao<Sku> {

    @Select("select * from sku_ where spu_id_ = #{skuId}")
    public List<Sku> findBySkuId(Integer spuId);
    
}
