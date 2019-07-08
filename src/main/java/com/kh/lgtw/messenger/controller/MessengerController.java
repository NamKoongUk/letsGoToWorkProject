package com.kh.lgtw.messenger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.messenger.model.service.MessengerService;
import com.kh.lgtw.messenger.model.vo.Messenger;

@Controller
@RequestMapping("messenger")
public class MessengerController {
	@Autowired
	private MessengerService ms;
	
	//메인 페이지 리턴
	@RequestMapping("")
	public String showMain() {
		return "messenger/messengerMain";
	}
	
	//쪽지 전송페이지(페이지전환)
	@RequestMapping("/showMessenger")
	public String showMessenger(Model model) {
		return "messenger/messengerSend";
	}
	
	//쪽지 전송 or 저장(페이지전환)
	@PostMapping(value="/sendMessenger")
	public String sendMessenger(@RequestParam Map<String,Object> params, @RequestParam("sendEmp") List<Integer> sendEmp) {
		
		params.put("sendEmp", sendEmp);
		System.out.println(params);
		
		ms.sendMessenger(params);
		
		return "";
	}
	//쪽지 조회(ajax)
	@GetMapping(value="/selectMessenger/{currentPage}/{status}/{startDate}/{endDate}/{empNo}/{content}/{searchCondition}")
	public @ResponseBody ResponseEntity<HashMap<String,Object>> selectMessenger(@PathVariable Map<String,Object> params) {
		System.out.println(params);
		
		int listCount = ms.selectMessengerCount(params);
		PageInfo pi = Pagination.getPageInfo(Integer.parseInt(params.get("currentPage").toString()), listCount);
		
		params.put("pi", pi);
		
		ArrayList<HashMap<String,Object>> list = ms.selectMessenger(params);
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		
		hmap.put("pi", pi);
		hmap.put("list", list);
		
		return new ResponseEntity<HashMap<String,Object>>(hmap,HttpStatus.OK);
	}
	
	//쪽지 디테일
	@GetMapping("/selectDetailMessenger/{msgNo}/{messageType}/{empNo}")
	public ResponseEntity<HashMap<String, Object>> selectDetailMessneger(@PathVariable Map<String, Object> params) {
		System.out.println(params);
		HashMap<String, Object> hmap = (HashMap<String, Object>) ms.selectDetailMessneger(params);
		return new ResponseEntity<HashMap<String,Object>>(hmap, HttpStatus.OK);
	}
	
	//쪽지 삭제(휴지통)(페이지전환)
	@PutMapping("/deleteMessenger")
	public String deleteMessenger(@RequestBody String msgNo, Model model) {
		ms.deleteMessenger(msgNo);
		return "";
	}
	
	//임지저장 쪽지 조회(ajax)
	@GetMapping(value="/selectStorageMessenger/{msgGno}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Messenger selectStorageMessenger(@PathVariable("msgGno") String msgGno , Model model) {
		ms.selectStorageMessenger(msgGno);
		return null;
	}
	//쪽지 답장
	@PostMapping(value="/reSendMessenger")
	public void reSendMessenger(@RequestBody Map<String,Object> params) {
		System.out.println(params);
	}

}
