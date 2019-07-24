package net.huayiyun.eureka_client.service.impl;

import net.huayiyun.commom.util.CommonCodeEnum;
import net.huayiyun.commom.util.ResultEntity;
import net.huayiyun.commom.util.ResultStausEnum;
import net.huayiyun.eureka_client.service.BloodGlucoseOpenFeignService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.service.impl
 * @Description : 服务降级处理
 * @Author : zlj
 * @Creation Date : 2019年06月28日 14:47
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Service
public class BloodGlucoseOpenFeignServiceImpl implements BloodGlucoseOpenFeignService {

    @Override
    public ResultEntity save8001(String data) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus(ResultStausEnum.FALT.getCode());
        resultEntity.setCode(CommonCodeEnum.ERROR.getCode());
        resultEntity.setMessage("伟大的尝试，即使失败了，也是壮美的");
        return resultEntity;
    }

    @Override
    public ResultEntity query8001(String data) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus(ResultStausEnum.FALT.getCode());
        resultEntity.setCode(CommonCodeEnum.ERROR.getCode());
        resultEntity.setMessage("失败也是我需要的，它和成功对我一样有价值。");
        return resultEntity;
    }

    @Override
    public String getIt() {
        return "It's impossible.";
    }
}
