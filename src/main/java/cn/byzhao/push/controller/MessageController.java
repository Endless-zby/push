package cn.byzhao.push.controller;

import cn.byzhao.push.entity.ApiResponse;
import cn.byzhao.push.entity.ClientDrive;
import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.service.ClientDriveService;
import cn.byzhao.push.service.MessageHistoryService;
import cn.byzhao.push.service.PushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@RequestMapping("/king")
public class MessageController {

    @Resource
    private PushService pushService;
    @Resource
    private ClientDriveService clientDriveService;

    @Resource
    private MessageHistoryService messageHistoryService;


    @ResponseBody
    @GetMapping(value = "/send")
    public ApiResponse<Object> create(@RequestParam(defaultValue = "title") String title, @RequestParam(defaultValue = "Example!") String message, @RequestParam(defaultValue = "8a5c16959ae103b643bfe32c4af80b3b1d55f07f732f5ee600a67a6cf53d9aab") String token) throws Exception {
        pushService.send(title, message, token);
        return ApiResponse.isSuccess();
    }

    @ResponseBody
    @GetMapping(value = "/getDrive")
    public ApiResponse<ClientDrive> getDrive(@RequestParam() Integer id) throws Exception {
        ClientDrive one = clientDriveService.getOne(id);
        return ApiResponse.isSuccess(one);
    }

    @ResponseBody
    @GetMapping(value = "/getHistory")
    public ApiResponse<MessageHistory> create(@RequestParam() Integer id) throws Exception {
        MessageHistory one = messageHistoryService.getOne(id);
        return ApiResponse.isSuccess(one);
    }
}
