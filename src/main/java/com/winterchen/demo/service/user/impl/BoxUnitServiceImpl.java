package com.winterchen.demo.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.demo.dao.BoxDeviceDao;
import com.winterchen.demo.dao.BoxUnitDao;
import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.BoxUnit;
import com.winterchen.demo.service.user.BoxDeviceService;
import com.winterchen.demo.service.user.BoxUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "boxUnitService")
public class BoxUnitServiceImpl implements BoxUnitService {

    @Autowired
    private BoxUnitDao boxUnitDao;

    @Override
    public int addDevice(BoxUnit boxUnit) {
        return boxUnitDao.insert(boxUnit);
    }

    @Override
    public PageInfo<BoxUnit> findAllDevices(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<BoxUnit> userDomains = boxUnitDao.selectDevices();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }


    @Override
    public BoxUnit selectBoxDevice(String ccid) {
        return boxUnitDao.selectBoxUnit(ccid);
    }

    @Override
    public int updateBoxUnit(BoxUnit boxUnit) {
        return boxUnitDao.updateBoxUnit(boxUnit);
    }
}
