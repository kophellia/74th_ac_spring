package kr.co.seoulit.account.posting.business.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.sys.common.util.BeanCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class JournalController {

	@Autowired
	private BusinessService businessService;

	@GetMapping("/singlejournallist")
	public ArrayList<JournalBean> findSingleJournalList(@RequestParam("slipNo") String slipNo) {

		ArrayList<JournalBean> journalList = businessService.findSingleJournalList(slipNo);

		return journalList;
	}

	@GetMapping("/rangedjournallist")
	public HashMap<String, Object> findRangedJournalList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate) {
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<JournalBean> journalList = businessService.findRangedJournalList(fromDate, toDate);

		map.put("journalList", journalList);
		return map;
	}

	@GetMapping("/journalremoval")
	public void removeJournal(@RequestParam String journalNo) {

		businessService.removeJournal(journalNo);

	}

	@PostMapping("/modifJour")
	public void modifJour(@RequestParam String slipNo) {
		System.out.println("modifJour에 잡힘");
		System.out.println(slipNo);
	}

	@PostMapping("/modifyJournal")
	public void modifyJournal(@RequestParam String slipNo, @RequestParam String journalObj) {
		System.out.println(slipNo);
		JSONArray journalObjs = JSONArray.fromObject(journalObj);

		ArrayList<JournalBean> journalBeanList = new ArrayList<>();

		for (Object journalObjt : journalObjs) {
			JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt),
					JournalBean.class);
			journalBean.setStatus(((JSONObject) journalObjt).getString("status"));
			journalBeanList.add(journalBean);
		}
		businessService.modifyJournal(slipNo, journalBeanList);
	}

	/*
	 * @PostMapping("/updateJournalList") public void updateJournalList(@RequestBody
	 * HashMap<String , ArrayList<JournalBean>> journalList){
	 * 
	 * businessService.updateJournalList(journalList); }
	 */
}
