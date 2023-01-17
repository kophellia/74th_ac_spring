package kr.co.seoulit.account.posting.ledger.controller;

import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.to.GeneralLedgerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class GeneralLedgerController {

    @Autowired
    private LedgerService ledgerService;

    @GetMapping("/generalLedgers")
    public HashMap<String, Object> findGeneralAccountLedgerList(@RequestParam("startDate") String fromDate,
                                                                @RequestParam("endDate") String toDate){
        HashMap<String , Object> map = new HashMap<>();
        ArrayList<GeneralLedgerBean> generalAccountLedgerList = ledgerService.findGeneralAccountLedgerList(fromDate,toDate);
        map.put("generalAccountLedgerList" , generalAccountLedgerList);
        return map;
    }

    @GetMapping("/ledgers")
    public HashMap<String , Object> findAccountLedger (@RequestParam("startDate") String fromDate,
                                                       @RequestParam("endDate") String toDate,
                                                       @RequestParam("accountCode") String accountCode
                                                       ){
        HashMap<String , Object> map = new HashMap<>();
        ArrayList<GeneralLedgerBean> accountLedgerList = ledgerService.findAccountLedger(fromDate,toDate,accountCode);
        map.put("accountLedgerList", accountLedgerList);
        return map;
    }
}
