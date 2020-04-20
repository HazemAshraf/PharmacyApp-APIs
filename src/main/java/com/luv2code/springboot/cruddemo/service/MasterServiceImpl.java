package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MasterPriceRepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.MasterRepo;
import com.luv2code.springboot.cruddemo.dao.MasterStoreRepo;
import com.luv2code.springboot.cruddemo.entity.ItemCompanyPrice;
import com.luv2code.springboot.cruddemo.entity.ItemDetails;
import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import com.luv2code.springboot.cruddemo.entity.ItemStoreCompany;
import java.util.ArrayList;

@Service
public class MasterServiceImpl {

    private MasterRepo masterDAO;
    private MasterPriceRepo MasterPriceDAO;
    private MasterStoreRepo MasterStoreDAO;

    @Autowired
    public MasterServiceImpl(MasterRepo theItemCompanyPriceDAO, MasterPriceRepo myMasterPriceDAO, MasterStoreRepo myMasterStoreDAO) {
        masterDAO = theItemCompanyPriceDAO;
        MasterPriceDAO = myMasterPriceDAO;
        MasterStoreDAO = myMasterStoreDAO;
    }

    public List<ItemMaster> findAll() {
        return masterDAO.findAll();
    }

//	public ItemCompanyPrice findById(int theId) {
//		return masterDAO.findById(theId);
//	}
    public ItemMaster findByItemName(String itmName) {
        return masterDAO.findItemMasterByItmNameL1(itmName);
    }

    public List<ItemDetails> findItmByItemNameStartingWithName(String itmName) {
        
        List<ItemDetails> itemDetails = new ArrayList<>();
        
        List<ItemMaster> itemMasterList = masterDAO.findItemMasterByItmNameL1StartingWith(itmName);
        itemMasterList.stream().forEach(i -> {
            ItemDetails itemDetails1 = new ItemDetails();

            itemDetails1.setSerial(i.getItmSerial());
            itemDetails1.setName(i.getItmNameL1());
            itemDetails1.setPrice(MasterPriceDAO.findItemCompanyPriceByItmSerial(i.getItmSerial()).getIcpPrice());
            itemDetails1.setQty(MasterStoreDAO.findItemStoreCompanyByItmSerial(i.getItmSerial()).getIscCurrentBalance());
            itemDetails.add(itemDetails1);
        });

        
        return itemDetails;
    }

    public ItemDetails findItmByItemName(String itmName) {

        ItemDetails itemDetails = new ItemDetails();
        ItemMaster itemMaster = masterDAO.findItemMasterByItmNameL1(itmName);
        ItemCompanyPrice itemCompanyPrice = MasterPriceDAO.findItemCompanyPriceByItmSerial(Double.parseDouble(String.valueOf(itemMaster.getItmSerial())));
        ItemStoreCompany itemStoreCompany = MasterStoreDAO.findItemStoreCompanyByItmSerial(itemMaster.getItmSerial());
        System.err.println(itemCompanyPrice.getIcpPrice());
        System.err.println(itemStoreCompany.getIscCurrentBalance());
        itemDetails.setSerial(itemMaster.getItmSerial());
        itemDetails.setName(itemMaster.getItmNameL1());
        System.out.println("aaaaa " + itemMaster);
        System.out.println("bbbbbb " + itemDetails);
        itemDetails.setPrice(itemCompanyPrice.getIcpPrice());
        System.out.println("ccccccc " + itemCompanyPrice);
        itemDetails.setQty(itemStoreCompany.getIscCurrentBalance());

        return itemDetails;
    }

    public void save(ItemMaster theEmployee) {
        masterDAO.save(theEmployee);
    }

//	public void deleteById(Double theId) {
//		masterDAO.deleteById(theId);
//	}
}
