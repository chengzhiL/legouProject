package com.lcz.legou.item.controller;

import com.lcz.legou.core.controller.BaseController;
import com.lcz.legou.item.po.Category;
import com.lcz.legou.item.service.ICategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item/category")
@CrossOrigin
public class CategoryController extends BaseController<ICategoryService, Category> {


}
