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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.messenger.model.service.MessengerService;

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
		
		return "redirect:/messenger";
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
	
	
	//쪽지 답장
	@PostMapping(value="/reSendMessenger", produces="application/text; charset=utf8") 
	public @ResponseBody ResponseEntity<String> reSendMessenger(@RequestBody Map<String,Object> params) {
		System.out.println(params);
		
		int result = ms.reSendMessneger(params);
		
		System.out.println();
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	//쪽지 삭제(휴지통)(페이지전환)
	@RequestMapping(value="/deleteMessenger", method=RequestMethod.PUT, produces="application/json; charset=utf8")
	public ResponseEntity<Integer> deleteMessenger(@RequestBody Map<String, Object> params) {
		System.out.println(params);
//		System.out.println(params.get("msgNoList").getClass());
//		String str = params.get("msgNoList").toString();
//		String setMsg = str.substring(1, str.length()-1);
//		
//		String[] strArr = setMsg.split(", ");
//		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i=0; i<strArr.length; i++) {
//			list.add(Integer.parseInt(strArr[i]));
//		}
//		params.put("msgNoList", list);
		
		int result = ms.deleteMessenger(params);

		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateMessenger", method=RequestMethod.PUT, produces="application/json; charset=utf8")
	public ResponseEntity<Integer> updateMessenger(@RequestBody Map<String, Object> params) {
		System.out.println(params);
		
		int result = ms.updateMessenger(params);
		
		return  new ResponseEntity<Integer>(1,HttpStatus.OK);
	}
	
	@GetMapping("/getStoDetail/{msgNo}")
	public ResponseEntity<ArrayList<HashMap<String,Object>>> getStoDetail(@PathVariable Map<String, Object> params) {
		System.out.println(params);
		
		
		ArrayList<HashMap<String,Object>> list = (ArrayList<HashMap<String,Object>>) ms.getStoDetail(params);
		
		return new ResponseEntity<ArrayList<HashMap<String,Object>>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/stoSendMessenger", method=RequestMethod.PUT, produces="application/json; charset=utf8")
	public ResponseEntity<Integer> stoSendMessenger(@RequestBody Map<String, Object> params) {
		System.out.println(params);
		
		int result = ms.stoSendMessenger(params);
		
		return  new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value="/resDelMessenger", method=RequestMethod.PUT, produces="application/json; charset=utf8")
	public ResponseEntity<Map<String, Object>> resDelMessenger(@RequestBody Map<String, Object> params) {
		System.out.println(params);
		
		int result = ms.delMessenger(params);
		
		return new ResponseEntity<Map<String, Object>>(params,HttpStatus.OK);
	}

}
