package com.luv2code.springboot.cruddemo.dao;


import java.util.List;

import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import com.luv2code.springboot.cruddemo.entity.ItemStoreCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterStoreRepo extends JpaRepository<ItemStoreCompany,Integer>{
//public ItemCompanyPrice findItemCompanyPriceByIcpRemarks(String icpRemarks);
    public ItemStoreCompany findItemStoreCompanyByItmSerial(int itmSerial);
	
}
