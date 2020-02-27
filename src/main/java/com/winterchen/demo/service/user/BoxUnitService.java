package com.winterchen.demo.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.BoxUnit;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface BoxUnitService {

    int addDevice(BoxUnit boxUnit);

    PageInfo<BoxUnit> findAllDevices(int pageNum, int pageSize);
}
