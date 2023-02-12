package kr.co.seoulit.account.sys.base.controller;

import kr.co.seoulit.account.posting.business.to.SlipBean;
import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.to.PeriodNoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin("*")
@RestController
@RequestMapping("/settlement")
public class PeriodNoController {

	@Autowired
	private BaseService baseService;

	@GetMapping("/periodNoList")
	public HashMap<String, Object> findPeriodNo() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("periodNoList", baseService.findPeriodNo());
		return map;
	}

	@GetMapping("/tPeriodNoList")
	public ArrayList<PeriodNoBean> findPeriodNo(@RequestParam("yearFirst") String yearFirst,
			@RequestParam("yearLast") String yearLast) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("yearFirst", yearFirst);
		map.put("yearLast", yearLast);
		ArrayList<PeriodNoBean> PeriodNoBean = baseService.findTPeriodNo(map);
		return PeriodNoBean;
	}
}