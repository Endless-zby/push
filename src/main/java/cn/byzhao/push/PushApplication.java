package cn.byzhao.push;

import cn.byzhao.push.listener.MyCustomMetricsListener;
import com.eatthepath.pushy.apns.ApnsClient;
import com.eatthepath.pushy.apns.ApnsClientBuilder;
import com.eatthepath.pushy.apns.auth.ApnsSigningKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
public class PushApplication {

//    @Bean
//    public ApnsClient apnsClient() {
//        try {
//            return new ApnsClientBuilder()
//                    .setApnsServer(ApnsClientBuilder.PRODUCTION_APNS_HOST)
//                    .setSigningKey(ApnsSigningKey.loadFromInputStream(new ClassPathResource("AuthKey_LH4T9V5U4R_5U8LBRXG3A.p8").getInputStream(),
//                            "5U8LBRXG3A", "LH4T9V5U4R"))
//                    .setMetricsListener(new MyCustomMetricsListener())  // 监听器 统计指标用
//                    .build();
//        }catch (Exception e){
//            log.error("weiChatApplication init APNs error",e);
//        }
//        log.error("IOS APNs推送初始化失败！ APNs不可用！");
//        return null;
//    }


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PushApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
//                    apnsClient.close(); // 关闭apns客户端
                    log.error("pushApplication stop");
                }
        ));
    }

}
