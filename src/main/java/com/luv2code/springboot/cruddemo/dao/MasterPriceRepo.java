package com.luv2code.springboot.cruddemo.dao;


import com.luv2code.springboot.cruddemo.entity.ItemCompanyPrice;
import java.util.List;

import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import com.luv2code.springboot.cruddemo.entity.ItemStoreCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterPriceRepo extends JpaRepository<ItemCompanyPrice,Double>{
//public ItemCompanyPrice findItemCompanyPriceByIcpRemarks(String icpRemarks);
    public ItemCompanyPrice findItemCompanyPriceByItmSerial(double itmSerial);
	
}
