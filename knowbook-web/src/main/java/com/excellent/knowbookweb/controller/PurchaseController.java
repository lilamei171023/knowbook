package com.excellent.knowbookweb.controller;

import com.excellent.knowbookcommon.model.vo.PurchasePage;
import com.excellent.knowbookcommon.model.vo.ResultVo;
import com.excellent.knowbookcommon.utils.ResultUtils;
import com.excellent.knowbookcore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
