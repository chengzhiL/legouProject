package com.lcz.legou.item.controller;

import com.lcz.legou.core.controller.BaseController;
import com.lcz.legou.item.po.SpuDetail;
import com.lcz.legou.item.service.ISpuDetailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Des 新职课商城项目
 * @Author 雪松
 * @Date 2020/11/3 14:51
 */
@RestController
@RequestMapping("/item/spu-detail")
@CrossOrigin
public class SpuDetailController extends BaseController<ISpuDetailService, SpuDetail> {

}
