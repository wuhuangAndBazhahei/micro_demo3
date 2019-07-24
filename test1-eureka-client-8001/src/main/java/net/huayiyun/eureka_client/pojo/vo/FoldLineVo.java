package net.huayiyun.eureka_client.pojo.vo;

import java.util.List;

/**
 * @Project : new_huayi
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.vo
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2018年05月21日 15:36
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class FoldLineVo {

    private List<String> legendData; //？？？
    private List<String> xAxisData; //X轴数据
    private List<SeriseVo> serise; //Y轴数据

    public List<String> getLegendData() {
        return legendData;
    }

    public void setLegendData(List<String> legendData) {
        this.legendData = legendData;
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<SeriseVo> getSerise() {
        return serise;
    }

    public void setSerise(List<SeriseVo> serise) {
        this.serise = serise;
    }
}
