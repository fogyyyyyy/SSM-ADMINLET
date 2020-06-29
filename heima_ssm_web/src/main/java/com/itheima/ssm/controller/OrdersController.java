package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService orderService;
    //查询全部订单--未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv =new ModelAndView();
//        List<Orders> ordersList=orderService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//
//    }

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name ="page",required = true,defaultValue = "1") Integer page,@RequestParam(name ="size",required = true,defaultValue = "4" ) Integer size) throws Exception {
        ModelAndView mv =new ModelAndView();
        List<Orders> ordersList =orderService.findAll(page,size);
        //PageInfo就是一个分页的BEAN
        PageInfo pageInfo =new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true) String ordersId) throws Exception {
        ModelAndView mv =new ModelAndView();
        Orders orders =orderService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/deleteOrders.do")
    public String deleteOrders(@RequestParam(name ="id",required = true) String id) throws Exception {
        orderService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    public String save(Orders orders) throws Exception {
        orderService.save(orders);
        return "redirect:findAll.do";

    }

}
