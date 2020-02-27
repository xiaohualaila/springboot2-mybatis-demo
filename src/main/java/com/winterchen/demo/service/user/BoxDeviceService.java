package com.winterchen.demo.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.DeviceDomain;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface BoxDeviceService {

    int addDevice(BoxDeviceDomain boxDeviceDomain);

    PageInfo<BoxDeviceDomain> findAllDevices(int pageNum, int pageSize);
}
