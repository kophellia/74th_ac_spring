package kr.co.seoulit.account.sys.base.controller;


import kr.co.seoulit.account.sys.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class PeriodNoController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/periodNoList")
    public HashMap<String, Object> findPeriodNo(){
        HashMap<String , Object> map = new HashMap<>();
        map.put("periodNoList" , baseService.findPeriodNo());
        return map;
    }
}
