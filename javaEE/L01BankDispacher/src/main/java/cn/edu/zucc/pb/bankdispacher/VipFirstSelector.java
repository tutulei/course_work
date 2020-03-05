package cn.edu.zucc.pb.bankdispacher;

import java.util.List;

import static cn.edu.zucc.pb.bankdispacher.EUserCategory.VIP;

/**
 * Vip优先选择器，队列中如果有vip，优先处理，其他按照到达时间顺序处理
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:21
 */
public class VipFirstSelector implements IUserSelector {
    public UserEvent select(List<UserEvent> events) {
        //TODO 实现vip优先算法的用户选择器
        for(int i = 0;i<events.size();i++){
            if(events.get(i).getCategory() == VIP){
                return events.get(i);
            }
        }
        return events.get(0);
    }
}
