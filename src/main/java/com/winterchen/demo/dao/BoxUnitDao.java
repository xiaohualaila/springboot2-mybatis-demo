package com.winterchen.demo.dao;


import com.winterchen.demo.model.BoxUnit;

import java.util.List;

public interface BoxUnitDao {

    int insert(BoxUnit boxUnit);

    List<BoxUnit> selectDevices();

    BoxUnit selectBoxUnit(String ccid);

    int updateBoxUnit(BoxUnit boxUnit);
}