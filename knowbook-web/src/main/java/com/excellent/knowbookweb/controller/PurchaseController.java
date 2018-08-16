package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.pojo.Address;
import com.excellent.knowbookcommon.model.vo.AddressTotal;
import com.excellent.knowbookcommon.model.vo.PurchasePage;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author User wxxu
 * @description: 购买控制层
 * @create 2018/8/7 23:13
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/queryPurchase")
    public ResultVo<List<PurchasePage>> queryPurchase(@RequestParam("userId") String userId,@RequestParam("bookId") String bookId) {
        ResultVo resultVo;

        PurchasePage purchasePage = purchaseService.queryPurchase(userId,bookId);

        if(purchasePage != null){
            resultVo = ResultUtils.success(purchasePage);
        }else{
            resultVo = ResultUtils.fail();
        }

        return resultVo;
    }

    @RequestMapping(value = "/queryAddress", method = RequestMethod.GET)
    public ResultVo<List<AddressTotal>> queryAddress(@RequestParam("userId") String userId){

        List<AddressTotal> addressTotalList = purchaseService.queryAddressTotal(userId);
        ResultVo resultVo;
        if(addressTotalList != null){
            resultVo = ResultUtils.success(addressTotalList);
        }else {
            resultVo = ResultUtils.fail();
        }
        return resultVo;
    }

    @PostMapping(value = "/updateAddress")
    public ResultVo<Integer> updateAddress(@Valid Address address,@RequestParam(value = "userDefaultAddressId",defaultValue = "0") String userDefaultAddressId){

        //得到前端传的值
        address.setUserId(address.getUserId());
        address.setAddressId(address.getAddressId());
        address.setAddresseeInfo(address.getAddresseeInfo());
        address.setAddresseeName(address.getAddresseeName());
        address.setAddresseePhone(address.getAddresseePhone());

        Integer i = purchaseService.updateAddress(address,userDefaultAddressId);

        ResultVo resultVo;

        if(i != 0){
            resultVo = ResultUtils.success(i);
        }else{
            resultVo = ResultUtils.fail();
        }

        return resultVo;
    }


    @PostMapping("/payment")
    public ResultVo<Integer> paymentSuccess(@RequestParam("userId") String userId,@RequestParam(value = "bookId",defaultValue = "0")String bookId){
        ResultVo resultVo;

        Integer i = purchaseService.payment(userId,bookId);
        if( i!= null && i!= 0){
            resultVo = ResultUtils.success(i);
        }else {
            resultVo = ResultUtils.fail();
        }

        return resultVo;
    }

}
