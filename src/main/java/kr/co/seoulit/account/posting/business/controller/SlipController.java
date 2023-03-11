package kr.co.seoulit.account.posting.business.controller;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.account.posting.business.service.JpaSlipService;
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

	@Autowired
	JpaSlipService jpaSlipService;

	ModelAndView mav = null;
	ModelMap map = new ModelMap();

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
	@DeleteMapping("/deleteSlip")
	public void removeSlip(@RequestParam String slipNo) {
		businessService.removeSlip(slipNo);
	}

// ====================전표 삭제 JPA Journal삭제 생각안함. FK부터 지워야됨.======================

//	@DeleteMapping("/deleteSlip")
//	public void removeSlip(@RequestParam String slipNo){
//		System.out.println("여기 슬립엔티티 슬립넘버있어요!!!!!!!!!!!+"+slipNo);
//		SlipEntity test = new SlipEntity();
//		test.setSlipNo(slipNo);
//		jpaSlipService.removeSlip(test.getSlipNo());
//}

	// =======================전표 저장==========================
	@PostMapping("/registerslip")
	public void registerSlip(@RequestBody SlipBean slipBean) {
		slipBean.setSlipStatus(slipBean.getSlipStatus());

		for (JournalBean journalBean : slipBean.getJournalBean()) {
			journalBean.setSlipNo(slipBean.getSlipNo());// journal에 slipNo세팅
			if (journalBean.getLeftDebtorPrice() == null) {
				journalBean.setLeftDebtorPrice("0");
			} else if (journalBean.getRightCreditsPrice() == null) {
				journalBean.setRightCreditsPrice("0");
			}
		}
		businessService.registerSlip(slipBean);
	}

	// =======================전표 수정==========================
	@PutMapping("/updateSlip")
	public void updateSlip(@RequestBody SlipBean slipBean) {
		System.out.println(slipBean);
		businessService.updateSlip(slipBean);
	}

	// =======================전표 승인 요청==========================
	@PatchMapping("/approvalSlipRequest")
	public void approvalSlipRequest(@RequestBody SlipBean slipBean) {
		System.out.println(slipBean);
		businessService.approvalSlipRequest(slipBean);

	}

//병합
	@GetMapping("/approvalsliplist")
	public ArrayList<SlipBean> findApprovalSlipList(@RequestParam("startDate") String fromDate,
			@RequestParam("endDate") String toDate, @RequestParam("slipStatus") String status) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("status", status);
		ArrayList<SlipBean> approvalSlipList = businessService.findApprovalSlipList(map);

		return approvalSlipList;
	}

	// ============ 이거 없음 ============ //
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