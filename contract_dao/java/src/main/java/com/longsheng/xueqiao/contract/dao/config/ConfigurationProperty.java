package com.longsheng.xueqiao.contract.dao.config;

import java.util.Properties;

import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.id_maker.IdMaker;
import org.soldier.platform.id_maker.IdMakerFactory;

import net.qihoo.qconf.QconfException;

public class ConfigurationProperty {

    private String roleName;

    private static ConfigurationProperty config;

    private IdMaker sleCommodityIdMaker;
    private IdMaker sledContractIdMaker;
    private IdMaker sledExchangeIdMaker;
    private IdMaker commodityMapIdMaker;
    private IdMaker specTradeTimeIdMaker;
    private IdMaker sledTradingSessionIdMaker;
    private IdMaker sledTradingSessionTimeSpanIdMaker;

    private ConfigurationProperty() {
    }

    public static ConfigurationProperty instance() {
        if (config == null) {
            synchronized (ConfigurationProperty.class) {
                if (config == null) {
                    config = new ConfigurationProperty();
                }
            }
        }
        return config;
    }

    public void init(Properties props) throws IdException, QconfException {
        this.roleName = props.getProperty("contract_dao_role", "role_xueqiao_contract");
        int commodityIdMakerNum = Integer.parseInt(props.getProperty("sledCommodityIdMaker", "25"));
        int contractIdMakerNum = Integer.parseInt(props.getProperty("sledContractIdMaker", "26"));
        int sledExchangeIdMakerNum = Integer.parseInt(props.getProperty("sledExchangeIdMaker", "29"));
        int commodityMapIdMakerNum = Integer.parseInt(props.getProperty("commodityMapIdMaker", "30"));
        int specTradeTimeIdMakerNum = Integer.parseInt(props.getProperty("specTradeTimeIdMaker", "31"));
        int sledTradingSessionIdMakerNum = Integer.parseInt(props.getProperty("sledTradingSessionIdMaker", "36"));
        int sledTradingSessionTimeSpanIdMakerNum = Integer.parseInt(props.getProperty("sledTradingSessionTimeSpanIdMaker", "37"));

        this.sleCommodityIdMaker = IdMakerFactory.getInstance().getIdMaker(commodityIdMakerNum);
        this.sledContractIdMaker = IdMakerFactory.getInstance().getIdMaker(contractIdMakerNum);
        this.sledExchangeIdMaker = IdMakerFactory.getInstance().getIdMaker(sledExchangeIdMakerNum);
        this.commodityMapIdMaker = IdMakerFactory.getInstance().getIdMaker(commodityMapIdMakerNum);
        this.specTradeTimeIdMaker = IdMakerFactory.getInstance().getIdMaker(specTradeTimeIdMakerNum);
        this.sledTradingSessionIdMaker = IdMakerFactory.getInstance().getIdMaker(sledTradingSessionIdMakerNum);
        this.sledTradingSessionTimeSpanIdMaker = IdMakerFactory.getInstance().getIdMaker(sledTradingSessionTimeSpanIdMakerNum);

        System.out.println("roleName=" + roleName);
        System.out.println("commodityIdMakerNum=" + commodityIdMakerNum);
        System.out.println("contractIdMakerNum=" + contractIdMakerNum);
        System.out.println("sledExchangeIdMakerNum=" + sledExchangeIdMakerNum);
        System.out.println("commodityMapIdMakerNum=" + commodityMapIdMakerNum);
        System.out.println("specTradeTimeIdMaker=" + specTradeTimeIdMakerNum);
        System.out.println("sledTradingSessionIdMaker=" + sledTradingSessionIdMakerNum);
        System.out.println("sledTradingSessionTimeSpanIdMaker=" + sledTradingSessionTimeSpanIdMakerNum);

        if (this.sleCommodityIdMaker == null) {
            throw new IdException("sleCommodityIdMaker create failed!");
        }
        if (this.sledContractIdMaker == null) {
            throw new IdException("sledContractIdMaker create failed!");
        }

        if (this.sledExchangeIdMaker == null) {
            throw new IdException("sledExchangeIdMaker create failed!");
        }
        if (this.commodityMapIdMaker == null) {
            throw new IdException("commodityMapIdMaker create failed!");
        }

        if (this.specTradeTimeIdMaker == null) {
            throw new IdException("specTradeTimeIdMaker create failed!");
        }

        if (roleName == null || "".equals(roleName)) {
            throw new IllegalArgumentException("role name not found.");
        }

        if (this.sledTradingSessionIdMaker == null) {
            throw new IdException("sledTradingSessionIdMaker create failed!");
        }

        if (this.sledTradingSessionTimeSpanIdMaker == null) {
            throw new IdException("sledTradingSessionTimeSpanIdMaker create failed!");
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public IdMaker getSleCommodityIdMaker() {
        return sleCommodityIdMaker;
    }

    public IdMaker getSledContractIdMaker() {
        return sledContractIdMaker;
    }

    public IdMaker getSledExchangeIdMaker() {
        return sledExchangeIdMaker;
    }

    public IdMaker getCommodityMapIdMaker() {
        return commodityMapIdMaker;
    }

    public IdMaker getSpecTradeTimeIdMaker() {
        return specTradeTimeIdMaker;
    }

    public void setSpecTradeTimeIdMaker(IdMaker specTradeTimeIdMaker) {
        this.specTradeTimeIdMaker = specTradeTimeIdMaker;
    }

    public IdMaker getSledTradingSessionIdMaker() {
        return sledTradingSessionIdMaker;
    }

    public IdMaker getSledTradingSessionTimeSpanIdMaker() {
        return sledTradingSessionTimeSpanIdMaker;
    }
}
