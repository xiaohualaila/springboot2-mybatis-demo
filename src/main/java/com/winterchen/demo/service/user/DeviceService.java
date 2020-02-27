package com.winterchen.demo.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.demo.model.DeviceDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface DeviceService {

    int addDevice(DeviceDomain deviceDomain);

    PageInfo<DeviceDomain> findAllDevices(int pageNum, int pageSize);
}
