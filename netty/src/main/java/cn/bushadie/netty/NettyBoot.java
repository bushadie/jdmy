package cn.bushadie.netty;

import cn.bushadie.netty.websocket.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author jdmy
 * on 2018/11/12.
 **/
@Component
public class NettyBoot implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent()==null) {
            try {
                WSServer.getInstance().start();

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
