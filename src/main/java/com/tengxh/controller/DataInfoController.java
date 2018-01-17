package com.tengxh.controller;

import com.tengxh.entity.DataInfo;
import com.tengxh.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class DataInfoController {

    @Autowired
    public DataInfoService dataInfoService;

    //@Autowired
    //public OrderEsCommonRepository orderEsCommonRepository;


    @RequestMapping("/")
    public ModelAndView getIndex() {

//
//        String queue_key = "test_queue_key";
//        Map<String,Object> msg = new HashMap();
//        msg.put("data","hello,rabbmitmq!");
//        mqProducer.sendDataToQueue(queue_key,msg);
//        mqProducer.sendDataToQueue(queue_key,msg);

//        orderEsCommonRepository = new OrderRepositoryImpl();

//        orderEsCommonRepository.createOrderIndex();

        ModelAndView mav = new ModelAndView("index");

        List<DataInfo> list = dataInfoService.selectInfo();
        mav.addObject("list", list);
        return mav;
    }
}
