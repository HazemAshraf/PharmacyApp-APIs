package com.luv2code.springboot.cruddemo.dao;


import java.util.List;

import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepo extends JpaRepository<ItemMaster,Integer>{

    //public ItemCompanyPrice findItemCompanyPriceByIcpRemarks(String icpRemarks);
    public ItemMaster findItemMasterByItmNameL1(String itmNameL1);
    public List<ItemMaster> findItemMasterByItmNameL1StartingWith(String itmNameL1);
    public ItemMaster save(ItemMaster itemMaster);
	
}
