package com.winterchen.demo.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.demo.dao.DeviceDao;
import com.winterchen.demo.model.DeviceDomain;
import com.winterchen.demo.service.user.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "deviceService")
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;//这里会报错，但是并不会影响


    @Override
    public int addDevice(DeviceDomain deviceDomain) {
        return deviceDao.insert(deviceDomain);
    }

    @Override
    public PageInfo<DeviceDomain> findAllDevices(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<DeviceDomain> userDomains = deviceDao.selectDevices();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
