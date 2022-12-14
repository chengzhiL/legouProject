package com.lcz.legou.item.controller;

import com.lcz.legou.core.controller.BaseController;
import com.lcz.legou.core.po.ResponseBean;
import com.lcz.legou.item.po.Spu;
import com.lcz.legou.item.service.ISpuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item/spu")
@CrossOrigin
public class SpuController extends BaseController<ISpuService, Spu> {

    @ApiOperation(value = "保存商品信息", notes = "保存商品")
    @PostMapping("/save-spu")
    public ResponseBean saveSpu(@RequestBody Spu spu) {
        ResponseBean rm = new ResponseBean();
        try {
            service.saveSpu(spu);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMsg("保存失败");
        }
        return rm;
    }

}
