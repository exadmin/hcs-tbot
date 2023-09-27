package com.github.exadmin.hcstbot.services;

import com.github.exadmin.hcstbot.services.impl.IvSbytService;
import com.github.exadmin.hcstbot.services.impl.IvStarNetService;
import com.github.exadmin.hcstbot.services.impl.IvTeplosetService;
import com.github.exadmin.hcstbot.services.impl.MosenergoSbytService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HCServicesFactory {
    private static Map<String, Class<? extends AbstractService>> initMap = new HashMap<>();
    static {
        initMap.put(IvSbytService.SERVICE_ID, IvSbytService.class);
        initMap.put(IvStarNetService.SERVICE_ID, IvStarNetService.class);
        initMap.put(IvTeplosetService.SERVICE_ID, IvTeplosetService.class);
        initMap.put(MosenergoSbytService.SERVICE_ID, MosenergoSbytService.class);
    }

    private static final Map<String, Class<? extends AbstractService>> FINAL_MAP = Collections.unmodifiableMap(initMap);

    public static Map<String, Class<? extends AbstractService>> getServicesMap() {
        return FINAL_MAP;
    }
}
