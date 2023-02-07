package kr.co.seoulit.account.posting.business.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.service.BusinessServiceImpl;
import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.JournalDetailBean;
import kr.co.seoulit.account.posting.business.to.SlipBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.util.BeanCreator;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import com.google.gson.Gson;

@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class SlipController {

	@Autowired
	private BusinessService businessService;

	ModelAndView mav = null;
	ModelMap map = new ModelMap();

//    @RequestMapping(value = "/slipmodification", method = {RequestMethod.POST, RequestMethod.GET})
//    public String modifySlip(@RequestParam(value = "slipObj", required = false) String slipObj,
//                             @RequestParam(value = "journalObj", required = false) String journalObj,
//                             @RequestParam(value = "slipStatus", required = false) String slipStatus) {
//
//        ArrayList<JournalBean> journalBeans;
//        JSONArray journalJSONArray;
//        SlipBean slipBean;
//        Gson gson = new Gson();
//
//        journalJSONArray = JSONArray.fromObject(journalObj); //遺꾧컻
//        slipBean = gson.fromJson(slipObj, SlipBean.class);
//        journalBeans = new ArrayList<>();
//        for (Object journalObjs : journalJSONArray) {
//
//            JournalBean journalBean = gson.fromJson(journalObjs.toString(), JournalBean.class);
//            journalBean.setSlipNo(slipBean.getSlipNo());
//            System.out.println(journalBean.getJournalNo() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//            System.out.println("customerName: ++" + journalBean.getCustomerName());
//            journalBeans.add(journalBean);
//        }
//
//        if (slipStatus.equals("승인요청")) {
//            slipBean.setSlipStatus("승인요청");
//        }
//
//        return businessService.modifySlip(slipBean, journalBeans);
//    }

//    @GetMapping("/registerslip")
//    public void registerSlip(
//			@RequestParam(value = "slipObj", required = false) String slipObj,
//			@RequestParam(value = "journalObj", required = false) String journalObj,
//			@RequestParam(value = "slipStatus", required = false) String slipStatus) 
//    		@RequestBody String slipObj, @RequestBody String journalObj, @RequestBody String slipStatus)
//    {
//    	System.out.println("registerslip 잡히나"); // 이까지는 잡히는 거 같음
//    	System.out.println(slipObj); 
//    	System.out.println(journalObj);
//    	System.out.println(slipStatus);
//        Gson gson = new Gson();
//        SlipBean slipBean = gson.fromJson(slipObj, SlipBean.class);//slipObj를 SlipBean 클래스로 변환
//        JSONArray journalObjs = JSONArray.fromObject(journalObj);//journalObj를 JSONArray로 변환
//        /*
//         * slipBean.setReportingEmpCode(request.getSession().getAttribute("empCode").
//         * toString()); // beanCreator에서 셋팅하는데 또함..(dong) //실제 결제신청하는 사람 정보로 바꿔주는 소스임 이름
//         * slipBean.setDeptCode(request.getSession().getAttribute("deptCode").toString()
//         * ); //부서번호
//         */
//        if (slipStatus.equals("승인요청")) {
//            slipBean.setSlipStatus("승인요청"); //처음에 전표저장을 하면 null이라서 안 바꾸고 승인요청이 오면 바꾼다
//        }
//
//        ArrayList<JournalBean> journalBeans = new ArrayList<>();
//
//
//        for (Object journalObjt : journalObjs) {
//            JournalBean journalBean = gson.fromJson(journalObjt.toString(), JournalBean.class);
//            System.out.println(slipBean.getSlipNo() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//
//            journalBean.setSlipNo(slipBean.getSlipNo()); //slipNo을 journalBean에 값이 없어서 세팅해줌
//            journalBeans.add(journalBean);
//
//        }
//        businessService.registerSlip(slipBean, journalBeans);
//    }

	/*
	 * @PostMapping("/registerslip") public HashMap<String, Object>
	 * addSlip(@RequestBody HashMap<String, SlipBean> slipData){ HashMap<String
	 * ,Object> map= new HashMap<>(); try{ String slipNo =
	 * businessService.addSlip(slipData); map.put("slipNo", slipNo);
	 * map.put("errorCode", 0); map.put("errorMsg", "등록완료"); } catch (Exception e2)
	 * { map.put("errorCode", -1); map.put("errorMsg", e2.getMessage());
	 * e2.printStackTrace(); } return map; };
	 */
// >>>>>>>>>>>>>>>>>>>여기서부터 하면 됨
	@PostMapping("/registerslip")
	public void registerSlip(@RequestBody JSONObject insertSlipData) {
//		System.out.println(insertSlipData);
//		System.out.println(insertSlipData.getClass().getName());
//		System.out.println(insertSlipData.get("insertSlipData"));
//		System.out.println(((JSONObject) insertSlipData.get("insertSlipData")).get("slipObj"));
//		System.out.println(((JSONObject) insertSlipData.get("insertSlipData")).get("slipObj").getClass().getName());
//		System.out.println(((JSONObject) insertSlipData.get("insertSlipData")).get("journalObj"));
//		System.out.println(((JSONObject) insertSlipData.get("insertSlipData")).get("journalObj").getClass().getName());
//		System.out.println(((JSONObject) insertSlipData.get(insertSlipData)).get("journalObj"));
//		System.out.println(((JSONObject) insertSlipData.get(insertSlipData)).get("slipStatus"));
		
		Object slipObj = ((JSONObject) insertSlipData.get("insertSlipData")).get("slipObj");
		Object journalObj = ((JSONObject) insertSlipData.get("insertSlipData")).get("journalObj");
		String slipStatus = ((JSONObject) insertSlipData.get("insertSlipData")).get("slipStatus").toString();
		
		System.out.println(slipObj.getClass().getName());
		System.out.println(journalObj.getClass().getName());
		System.out.println(slipStatus.getClass().getName());
		
		System.out.println(((Object) slipObj));
		System.out.println(journalObj);
		System.out.println(slipStatus);
		SlipBean slipBean = null;
      Gson gson = new Gson();
      JSONArray slipObjs = JSONArray.fromObject(slipObj);//journalObj를 JSONArray로 변환
		for(Object slipObjt: slipObjs) {
			slipBean = gson.fromJson(slipObjt.toString(), SlipBean.class);//slipObj를 SlipBean 클래스로 변환
		}
//      SlipBean slipBean = gson.fromJson(slipObj, SlipBean.class);//slipObj를 SlipBean 클래스로 변환
      JSONArray journalObjs = JSONArray.fromObject(journalObj);//journalObj를 JSONArray로 변환
//      /*
//       * slipBean.setReportingEmpCode(request.getSession().getAttribute("empCode").
//       * toString()); // beanCreator에서 셋팅하는데 또함..(dong) //실제 결제신청하는 사람 정보로 바꿔주는 소스임 이름
//       * slipBean.setDeptCode(request.getSession().getAttribute("deptCode").toString()
//       * ); //부서번호
//       */
//      if (slipStatus.equals("승인요청")) {
//          slipBean.setSlipStatus("승인요청"); //처음에 전표저장을 하면 null이라서 안 바꾸고 승인요청이 오면 바꾼다
//      }
//
      ArrayList<JournalBean> journalBeans = new ArrayList<>();
//
//
      for (Object journalObjt : journalObjs) {
          JournalBean journalBean = gson.fromJson(journalObjt.toString(), JournalBean.class);
          System.out.println(slipBean.getSlipNo() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

          journalBean.setSlipNo(slipBean.getSlipNo()); //slipNo을 journalBean에 값이 없어서 세팅해줌
          journalBeans.add(journalBean);

      }
      businessService.registerSlip(slipBean, journalBeans);
	}

	@GetMapping("/approvalslip")
	public void modifyapproveSlip(@RequestParam String approveSlipList, @RequestParam String isApprove) {

		JSONArray approveSlipLists = JSONArray.fromObject(approveSlipList); // slip_no만 가지고옴 //JSONArray.fromObject json
																			// 객체로 만들어줌
		String slipStatus = isApprove; // true 승인버튼 누르면 true 가 넘어옴
		ArrayList<SlipBean> slipBeans = new ArrayList<>(); // 담는 값이 여러개

		for (Object approveSlip : approveSlipLists) { // 승인일자를 자바로 만든다
			Calendar calendar = Calendar.getInstance(); // import함
			String year = calendar.get(Calendar.YEAR) + "";
			String month = "0" + (calendar.get(Calendar.MONTH) + 1); // 0~11까지
			String date = "0" + calendar.get(Calendar.DATE);
			String today = year + "-" + month.substring(month.length() - 2) + "-" + date.substring(date.length() - 2); 
			// 인덱스 0,1 에서 0부터 시작하기 위해서 -2를 해주는듯 만약에 1자리인 경우에는 -1이니까 앞자리0부터???
			// 2021-11-15
			System.out.println("approveSlip : " + approveSlip);
			SlipBean slipBean = new SlipBean();
			slipBean.setSlipNo(approveSlip.toString()); // 전표번호
			slipBean.setApprovalDate(today); // 승인데이터 오늘날짜
			slipBean.setSlipStatus(slipStatus); // 전표상태
			// slipBean.setApprovalEmpCode(request.getSession().getAttribute("empCode").toString());
			// //String 형식 세션 값 읽기
			slipBeans.add(slipBean);
		}

		businessService.modifyapproveSlip(slipBeans);

	}

	// ====================전표 조회 ======================
	@GetMapping("/rangedsliplist")
	public ArrayList<SlipBean> findRangedSlipList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate, @RequestParam("slipStatus") String slipStatus) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("slipStatus", slipStatus);
		ArrayList<SlipBean> slipFormList = businessService.findRangedSlipList(map);

		return slipFormList;
	}

	// ====================전표 삭제======================
	@GetMapping("/deleteSlip")
	public void removeSlip(@RequestParam String slipNo) {
		businessService.removeSlip(slipNo);

	}

	@GetMapping("/approvalsliplist")
	public ArrayList<SlipBean> findApprovalSlipList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		ArrayList<SlipBean> approvalSlipList = businessService.findApprovalSlipList(map);

		return approvalSlipList;
	}

	@GetMapping("/disapprovalsliplist")
	public ArrayList<SlipBean> findDisApprovalSlipList() {

		return businessService.findDisApprovalSlipList();
	}

	@GetMapping("/findSlip")
	public ArrayList<SlipBean> findSlip(@RequestParam String slipNo) {

		return businessService.findSlip(slipNo);
	}

	@GetMapping("/accountingsettlementstatus")
	public HashMap<String, Object> findAccountingSettlementStatus(@RequestParam String accountPeriodNo,
			@RequestParam String callResult) {
		JSONObject json = new JSONObject();
		HashMap<String, Object> params = new HashMap<>();

		params.put("accountPeriodNo", accountPeriodNo);
		params.put("callResult", callResult);

		json.put("errorCode", 0);
		json.put("errorMsg", "데이터 조회 성공");

		businessService.findAccountingSettlementStatus(params);

		return params;
	}

}