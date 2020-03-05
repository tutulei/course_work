package cn.edu.zucc.pb.bankdispacher.simulator;

import cn.edu.zucc.pb.bankdispacher.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.UserEvent;
import cn.edu.zucc.pb.bankdispacher.UserEventQue;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行柜台办理业务仿真程序
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:49
 */
public class BankCounter {
    public static List<Thread> Counts = new ArrayList<Thread>();//修改：添加一个柜台列表，方便查看
    private static int Remainingplaces = 100; //修改：设定剩余可办理业务数量
    /**
     * 模拟柜台开始办理业务
     */
    public void start() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开放，可以开始处理业务……");
        //TODO 增加柜台下班的控制
        //while(true)柜台一直不下班
        //修改：当剩余可办理业务数量大于0时，继续为客户办理
        while(Remainingplaces>0){
            UserEvent userEvent = UserEventQue.getInstance().dispatchUser();
            if(userEvent == null){//没有用户时，等待5秒再次寻找用户
                Thread.sleep(5000);
                continue;
            }
            //等待一点时间,模拟在办理或者等待
            //TODO 实现不同业务类型等待不同时间
            System.out.println(Thread.currentThread().getName()+"接到一项业务.");
            waitSomeTime(userEvent.getCategory());
            //修改：办理完一个用户之后剩余可办理业务数量减一
            Remainingplaces= Remainingplaces-1;
            System.out.println(Thread.currentThread().getName()+"已处理完一项业务，还可处理"+Remainingplaces+"项业务");
        }
    }

    private void waitSomeTime(EUserCategory category){
//        修改：企业业务时间波动（10~20秒），
//        修改：vip用户时间波动（5~15秒），
//        修改：个人业务时间波动（1~10秒）
        System.out.println(Thread.currentThread().getName()+"为"+category+"用户处理业务中……");
        try {
            switch (category){
                case VIP :
                    Thread.sleep(RandomUtils.nextInt(5000, 15000));
                    break;
                case PRIVATE :
                    Thread.sleep(RandomUtils.nextInt(1000, 10000));
                    break;
                case ENTERPRISE:
                    Thread.sleep(RandomUtils.nextInt(10000, 20000));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
