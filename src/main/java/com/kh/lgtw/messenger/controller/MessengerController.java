package com.kh.lgtw.messenger.controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lgtw.messenger.model.service.MessengerService;
import com.kh.lgtw.messenger.model.vo.Messenger;

@Controller
public class MessengerController {
	@Autowired
	private MessengerService ms;
	
	//쪽지 전송 or 저장(페이지전환)
	@PostMapping("sendMessenger.me")
	public String sendMessenger(@RequestBody Map<String, String> params) {
		//ms.sendMessenger(params);
		return "";
	}
	//쪽지 조회(ajax)
	@GetMapping(value="selectMessenger.me") 
	public @ResponseBody ArrayList<Messenger> selectMessenger(String currentPage, @RequestBody Map<String, String> params) {
		//ms.selectMessenger(params);
		return null;
	}
	//쪽지 전송페이지(페이지전환)
	@RequestMapping("showMessenger.me")
	public String showMessenger(Model model) {
		return "";
	}
	//쪽지 삭제(휴지통)(페이지전환)
	@Update("deleteMessenger.me")
	public String deleteMessenger(@RequestBody Map<String, String> params, Model model) {
		//ms.deleteMessenger(params);
		return "";
	}
	//임지저장 쪽지 조회(ajax)
	@GetMapping("selectStorageMessenger.me/{msgGno}")
	public @ResponseBody ArrayList<Messenger> selectStorageMessenger(@PathVariable String msgGno , Model model) {
		//ms.selectStorageMessenger(msgGno);
		
		return null;
	}
	//쪽지 디테일(페이지전환)
	@GetMapping("selectDetailMessenger.me")
	public String selectDetailMessneger(@RequestBody Map<String, String> params, Model model) {
		//ms.selectDetailMessneger(params);
		return "";
	}
	
}
