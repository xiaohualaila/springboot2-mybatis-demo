package com.winterchen.demo.dao;


import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.DeviceDomain;

import java.util.List;

public interface BoxDeviceDao {

    int insert(BoxDeviceDomain boxDeviceDomain);

    List<BoxDeviceDomain> selectDevices();
}