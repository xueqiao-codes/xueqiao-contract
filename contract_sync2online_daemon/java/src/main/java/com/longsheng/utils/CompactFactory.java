package com.longsheng.utils;

import org.apache.thrift.protocol.TCompactProtocol;

public class CompactFactory {
    private static CompactFactory ourInstance = new CompactFactory();

    public static CompactFactory getInstance() {
        return ourInstance;
    }

    private TCompactProtocol.Factory factory;

    private CompactFactory() {
        factory = new TCompactProtocol.Factory();
    }

    public TCompactProtocol.Factory getFactory() {
        return factory;
    }
}
