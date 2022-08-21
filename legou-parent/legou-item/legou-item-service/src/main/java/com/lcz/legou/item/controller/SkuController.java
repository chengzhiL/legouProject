package com.lcz.legou.item.controller;

import com.lcz.legou.core.controller.BaseController;
import com.lcz.legou.item.po.Sku;
import com.lcz.legou.item.service.ISkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item/sku")
@CrossOrigin
public class SkuController extends BaseController<ISkuService, Sku> {

}
