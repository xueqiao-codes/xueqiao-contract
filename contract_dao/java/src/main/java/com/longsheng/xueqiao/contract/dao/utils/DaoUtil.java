package com.longsheng.xueqiao.contract.dao.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaoUtil {

    public static Set<Integer> map2Set(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : list) {
            if (i != null) {
                set.add(i);
            }
        }
        return set;
    }

    public static String getConditionORString(List<String> columns) {
        boolean first = true;
        StringBuffer buffer = new StringBuffer(128);
        for (String column : columns) {
            if (first) {
                buffer.append(" ");
            } else {
                buffer.append(" OR ");
            }

            buffer.append("(");
            buffer.append(column);
            buffer.append(" like ? ");
            buffer.append(")");
            first = false;
        }
        return buffer.toString();
    }

    public static String[] getConditionORValues(List<String> values) {
        String[] array = new String[values.size()];
        int i = 0;
        for (String s : values) {
            array[i] = "%" + s + "%";
            i++;
        }
        return array;
    }
}
