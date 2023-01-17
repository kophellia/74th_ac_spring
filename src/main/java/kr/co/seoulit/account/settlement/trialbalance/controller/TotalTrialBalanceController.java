package kr.co.seoulit.account.settlement.trialbalance.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.account.settlement.trialbalance.service.TrialBalanceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class TotalTrialBalanceController {

	@Autowired
	private TrialBalanceService trialBalanceService;


	@PostMapping("/totaltrialbalance")
	public HashMap<String, Object> finddoClosing(@RequestParam("accountPeriodNo") String accountPeriodNo,
			                                     @RequestParam("callResult") String callResult) {

		HashMap<String,Object> params = new HashMap<>();
		params.put("accountPeriodNo",accountPeriodNo);
		params.put("callResult",callResult);


             HashMap<String, Object> closingResult = trialBalanceService.findEarlyStatements(params);

           return closingResult;
	}

	  @GetMapping("/totaltrialbalance")
	public HashMap<String,Object> findTotalTrialBalance(@RequestParam("accountPeriodNo") String accountPeriodNo
	  														, @RequestParam("callResult") String callResult
	  													) {

		HashMap<String,Object> map = new HashMap<>();
		  try{
			  HashMap<String, Object> totaltrialList = trialBalanceService.findTotalTrialBalance(accountPeriodNo,callResult);
		  		map.put("totaltrialList" , totaltrialList);
		  }catch (Exception e2){
			  map.put("errorCode", -1);
			  map.put("errorMsg", e2.getMessage());
		  }

        return map;
	}

	@PostMapping("/totaltrialbalancecancle")
	public void findcancelClosing(@RequestParam String accountPeriodNo,
										  @RequestParam String callResult) {

		trialBalanceService.findchangeAccountingSettlement(accountPeriodNo, callResult);
	}

}
