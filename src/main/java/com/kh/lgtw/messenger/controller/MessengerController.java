package com.kh.lgtw.messenger.controller;

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

import com.kh.lgtw.messenger.model.service.MessengerService;
import com.kh.lgtw.messenger.model.vo.Messenger;

@Controller
@RequestMapping("messenger")
public class MessengerController {
	@Autowired
	private MessengerService ms;
	
	@GetMapping("/new1/{bno}")
	public @ResponseBody ResponseEntity<String> test(@PathVariable String bno) {
		
		return new ResponseEntity<String>(bno, HttpStatus.OK);
	}
	
	//쪽지 전송 or 저장(페이지전환)
	@PostMapping(value="/sendMessenger")
	public String sendMessenger(@RequestBody Map<String, Object> params) {
		ms.sendMessenger(params);
		return "";
	}
	//쪽지 조회(ajax) - restful
	@GetMapping(value="/selectMessenger/{SearchCondtion}/{currentPage}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<List<Messenger>> selectMessenger(@PathVariable Map<String,Object> SearchCondtion, @PathVariable String currentPage) {
		//ms.selectMessenger(SearchCondtion);
		return null;
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
	
	//페이지 전환
	//쪽지 디테일(페이지전환)
	@GetMapping("/selectDetailMessenger")
	public String selectDetailMessneger(@RequestParam("msgNo")String msgNo, Model model) {
		ms.selectDetailMessneger(msgNo);
		return "";
	}
	//쪽지 전송페이지(페이지전환)
		@RequestMapping("showMessenger.me")
		public String showMessenger(Model model) {
			return "";
		}
	
}
