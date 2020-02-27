package com.winterchen.demo.dao;


import com.winterchen.demo.model.DeviceDomain;

import java.util.List;

public interface DeviceDao {

    int insert(DeviceDomain device);

    List<DeviceDomain> selectDevices();
}