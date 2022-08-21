package com.lcz.legou.item.service;

import com.lcz.legou.core.service.ICrudService;
import com.lcz.legou.item.po.Spu;

public interface ISpuService extends ICrudService<Spu> {

    /**
     * 保存spu
     * @param spu
     *   - spu
     *   - spuDetail
     *   - skus
     */
    public void saveSpu(Spu spu);

}
