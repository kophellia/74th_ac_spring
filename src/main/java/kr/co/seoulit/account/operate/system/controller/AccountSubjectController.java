package kr.co.seoulit.account.operate.system.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.operate.system.service.SystemService;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.operate.system.to.AccountControlBean;
import kr.co.seoulit.account.operate.system.to.PeriodBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/operate")
public class AccountSubjectController {
	
	@Autowired
    private SystemService systemService;

	
    ModelAndView mav = null;
    ModelMap map = new ModelMap();


    @GetMapping("/account")
    public ArrayList<AccountBean> findAccount(@RequestParam String accountCode
                                    , @RequestParam String accountName
                                ) {

            HashMap<String,Object> map = new HashMap<>();
            map.put("accountCode", accountCode);
            map.put("accountName", accountName);
            ArrayList<AccountBean> accountBean = systemService.findAccount(map);
            map.put("accountBean", accountBean);
        return accountBean;
    }

    @GetMapping("/accountcontrollist")
    public ArrayList<AccountControlBean> findAccountControlList(@RequestParam(value="accountCode", required=false) String accountCode) {

            ArrayList<AccountControlBean> accountControlList = systemService.findAccountControlList(accountCode);


        return accountControlList;
    }
    @GetMapping("/accountlistbyname")
    public ArrayList<AccountBean> findAccountListByName(@RequestParam String accountName) {
 

    	ArrayList<AccountBean> accountList = systemService.findAccountListByName(accountName);
 
        return accountList;
    }
    @GetMapping("/parentaccountlist") // 계정과목조회
    public HashMap<String, Object> getAccountList() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("accountCodeList" , systemService.findParentAccountList());
        return map;
    }




    @GetMapping("/detailaccountlist")
    public ArrayList<AccountBean> findDetailAccountList(@RequestParam("code") String code) {

            ArrayList<AccountBean> accountList = systemService.findDetailAccountList(code);
         
        return accountList;
    }

    @GetMapping("/accountmodification")
    public void modifyAccount(@RequestParam String accountInnerCode,
    						  @RequestParam String accountName) {

            AccountBean accountBean = new AccountBean();

            accountBean.setAccountInnerCode(accountInnerCode);
            accountBean.setAccountName(accountName);

    }

    @GetMapping("/detailbudgetlist")
    public HashMap<String, Object> findDetailBudgetList(@RequestParam("code") String code){
        HashMap<String , Object> map =new HashMap<>();
        ArrayList<AccountBean> budgetList = systemService.findDetailBudgetList(code);
        map.put("budgetList", budgetList);
        return map;
    }

    @GetMapping("/parentbudgetlist")
    public HashMap<String, Object> findParentBudgetList(){

        HashMap<String , Object> map =new HashMap<>();
        ArrayList<AccountBean> parentBudgetList = systemService.findParentBudgetList();
        map.put("parentBudgetList", parentBudgetList);
        return map;
    }

    @GetMapping("/parentbudgetlist2")
    public ArrayList<AccountBean> findParentBudgetList2(@RequestParam String workplaceCode,
                                                        @RequestParam String deptCode,
                                                        @RequestParam String accountPeriodNo) {
        System.out.println("workplaceCode:" +workplaceCode);
        System.out.println("deptCode:" +deptCode);
        ArrayList<AccountBean> parentBudgetList = systemService.findParentBudgetList2(workplaceCode,deptCode,accountPeriodNo);

        return parentBudgetList;
    }

    @GetMapping("/accountperiodlist")
    public ArrayList<PeriodBean> findAccountPeriodList() {
     
            ArrayList<PeriodBean> accountPeriodList = systemService.findAccountPeriodList();

        return accountPeriodList;
    }
}
