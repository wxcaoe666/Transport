package com.controller;

import com.model.Introduce;
import com.service.IIntroduceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/introduce")
@Controller
public class IntroduceController {

    @Resource
    private IIntroduceService introduceService;

    @RequestMapping(value = "/getintroducebyuserid",method = RequestMethod.GET)
    @ResponseBody
    public Introduce getintroducebyuserid(int UserID){
        Introduce introduce = introduceService.getintroducebyuserid(UserID);
        if(introduce==null){
            Introduce introduce1= new Introduce();
            introduce1.setUserID(UserID);
            introduce1.setIntroOne("您还未创建个人说明！");
            introduce1.setIntroTwo("您还未创建个人说明！");
            introduce1.setIntroThree("您还未创建个人说明！");
            introduce1.setIntroFour("您还未创建个人说明！");
            introduce1.setIntroFive("您还未创建个人说明！");
            introduce1.setIntroSix("您还未创建个人说明！");
            introduce1.setIntroSeven("您还未创建个人说明！");
            introduce1.setIntroEight("您还未创建个人说明！");
            return introduce1;
        }else{
            return introduce;
        }
    }

    @RequestMapping(value = "/updateintroduce",method = RequestMethod.POST)
    @ResponseBody
    public int updateintroduce(@RequestBody Introduce introduce){
        int userID = introduce.getUserID();
        Introduce introduce1 = introduceService.getintroducebyuserid(userID);
        if (introduce1==null){
            return introduceService.addintroducen(introduce);
        }else {
            return introduceService.updateintroduce(introduce);
        }
    }


}
