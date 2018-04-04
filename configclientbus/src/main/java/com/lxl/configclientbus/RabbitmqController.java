package com.lxl.configclientbus;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lxl lukas
 * @description from表单消息队列
 * @create 2018/1/26
 */
@Controller
public class RabbitmqController {

    @Autowired
    private Sender sender;

    @GetMapping("/editMessage")
    public String skipToPage(Model model){
        model.addAttribute("msg",new Message());
        return "edit";
    }

    @PostMapping("/postMessage")
    public String postMessage(Model model,@ModelAttribute Message msg){
        if(!StringUtils.isEmpty(msg.getMessage())) {
            sender.send(msg.toString());
        }else{
            System.out.println("message is null");
        }
        model.addAttribute("msg",msg);
        return "result";
    }

}
