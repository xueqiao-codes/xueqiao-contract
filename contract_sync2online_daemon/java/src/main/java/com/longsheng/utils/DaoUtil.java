package com.longsheng.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaoUtil {

    public static Set<Integer> map2Set(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for (Integer i : list){
            if (i!=null){
                set.add(i);
            }
        }
        return set;
    }
}
