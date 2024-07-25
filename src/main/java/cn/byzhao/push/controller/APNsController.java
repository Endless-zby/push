package cn.byzhao.push.controller;

import cn.byzhao.push.entity.ApiResponse;
import cn.byzhao.push.service.PushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/apns")
public class APNsController {

    @Resource
    private PushService pushService;

    @ResponseBody
    @GetMapping(value = "/send")
    public ApiResponse<Object> create(@RequestParam(defaultValue = "title") String title, @RequestParam(defaultValue = "Example!") String message, @RequestParam(defaultValue = "8a5c16959ae103b643bfe32c4af80b3b1d55f07f732f5ee600a67a6cf53d9aab") String token) throws Exception {
        pushService.send(title, message, token);
        return ApiResponse.isSuccess();
    }
}
