package com.winterchen.demo.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.demo.dao.BoxDeviceDao;
import com.winterchen.demo.dao.BoxUnitDao;
import com.winterchen.demo.dao.DeviceDao;
import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.DeviceDomain;
import com.winterchen.demo.service.user.BoxDeviceService;
import com.winterchen.demo.service.user.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "boxDeviceService")
public class BoxDeviceServiceImpl implements BoxDeviceService {

    @Autowired
    private BoxDeviceDao deviceDao;

    @Override
    public int addDevice(BoxDeviceDomain boxDeviceDomain) {
        return deviceDao.insert(boxDeviceDomain);
    }

    @Override
    public PageInfo<BoxDeviceDomain> findAllDevices(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<BoxDeviceDomain> userDomains = deviceDao.selectDevices();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public BoxDeviceDomain selectBoxDevice(String devId) {
        return deviceDao.selectBoxDevice(devId);
    }

    @Override
    public int updateBoxDevice(BoxDeviceDomain boxDeviceDomain) {
        return deviceDao.updateBoxDevice(boxDeviceDomain);
    }

}
