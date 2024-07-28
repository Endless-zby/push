package cn.byzhao.push.controller;

import cn.byzhao.push.config.PushException;
import cn.byzhao.push.entity.ApiResponse;
import cn.byzhao.push.entity.ClientDrive;
import cn.byzhao.push.entity.FailEnum;
import cn.byzhao.push.entity.MessageHistory;
import cn.byzhao.push.service.ClientDriveService;
import cn.byzhao.push.service.MessageHistoryService;
import cn.byzhao.push.service.PushService;
import org.springframework.data.domain.Page;
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
    public ApiResponse<Object> send(@RequestParam(defaultValue = "title") String title,
                                      @RequestParam(defaultValue = "Example!") String body,
                                      @RequestParam(defaultValue = "123456") String clientId,
                                      @RequestParam(defaultValue = "8a5c16959ae103b643bfe32c4af80b3b1d55f07f732f5ee600a67a6cf53d9aab") String token) throws Exception {

        ClientDrive clientDrive = clientDriveService.findByClientId(clientId);
        if(clientDrive == null){
            throw new PushException(FailEnum.PARMETER_EXCEPTION);
        }
        MessageHistory messageHistory = MessageHistory.builder().body(body).title(title).clientId(clientId).driveId(clientDrive.getDriveId()).build();
        pushService.sendAndSave(messageHistory);
        return ApiResponse.isSuccess();
    }

    @ResponseBody
    @PostMapping(value = "/send")
    public ApiResponse<Object> send(@RequestBody MessageHistory message) throws Exception {

        ClientDrive clientDrive = clientDriveService.findByClientId(message.getClientId());
        if(clientDrive == null){
            throw new PushException(FailEnum.PARMETER_EXCEPTION);
        }
        message.setDriveId(clientDrive.getDriveId());
        pushService.sendAndSave(message);
        return ApiResponse.isSuccess();
    }


    /**
     * 保存客户端id和token
     * @param clientDrive
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/saveDrive")
    public ApiResponse<Object> create(@RequestBody ClientDrive clientDrive) throws Exception {

        ClientDrive save = clientDriveService.save(clientDrive);
        return ApiResponse.isSuccess(save);
    }

    @ResponseBody
    @GetMapping(value = "/saveDrive")
    public ApiResponse<Object> create(@RequestParam String driveId, @RequestParam String clientId) throws Exception {

        ClientDrive save = clientDriveService.save(new ClientDrive(null, clientId, driveId));
        return ApiResponse.isSuccess(save);
    }

    @ResponseBody
    @GetMapping(value = "/getHistory")
    public ApiResponse<Page<MessageHistory>> getHistory(@RequestParam String clientId,
                                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {

        Page<MessageHistory> messageHistories = messageHistoryService.findAllByClientId(clientId, page, size);
        return ApiResponse.isSuccess(messageHistories);
    }
}
