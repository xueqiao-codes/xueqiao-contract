package com.longsheng.xueqiao.util.esunny9;

/**
 * Created by Jason on 2018/7/19.
 */
import com.longsheng.xueqiao.util.esunny9.swig.*;

public class EsunnyTradeSwigCallback extends IEsunnyTradeSwigCallback{
    EsunnyTradeSwig esunnyTradeSwig;
    int commodityCount = 0;
    int contractCount = 0;

    public void setEsunnyTradeSwig(EsunnyTradeSwig esunnyTradeSwig) {
        this.esunnyTradeSwig = esunnyTradeSwig;
    }

    @Override
    public void onInitFinish(boolean isFinish) {
        commodityCount = 0;
        contractCount = 0;
        esunnyTradeSwig.GetCommodityList();

        //ȡ�����еĺ�Լ -- ��ʽ1
        //esunnyTradeSwig.GetContractList();

        //ȡ����Ʒ�������ڻ��ĺ�Լ -- ��ʽ2
        esunnyTradeSwig.GetContractList('F');
        //ȡ����Ʒ�����ǿ��ڵĺ�Լ -- ��ʽ2
        esunnyTradeSwig.GetContractList('S');
        //ȡ����Ʒ�����ǿ�Ʒ�ֵĺ�Լ -- ��ʽ2
        esunnyTradeSwig.GetContractList('M');
    }

    @Override
    public void onCommodity(EsCommodityInfo esCommodityInfo, boolean isFinish) {
        commodityCount++;
        System.out.println(esCommodityInfo.getExchangeNo() + "\t" + esCommodityInfo.getCommodityNo() + "\t" + esCommodityInfo.getCommodityName() + "\t" + isFinish + "\t" + commodityCount);
    }

    @Override
    public void onContract(EsContractInfo esContractInfo, boolean isFinish) {
        contractCount++;
        System.out.println(esContractInfo.getExchangeNo() + "\t" + esContractInfo.getCommodityNo() + "\t" + esContractInfo.getContractNo1() + "\t" + isFinish + "\t" + contractCount);

        if(isFinish)
        {
            System.out.println("Finish");
            esunnyTradeSwig.Uninit();
        }

    }

}
