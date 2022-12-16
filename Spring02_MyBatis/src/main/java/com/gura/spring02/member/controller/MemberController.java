package com.gura.spring02.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;

@Controller
public class MemberController {
	
	//필요한 핵심 의존 객체를 주입 받는다.
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/update")
	public String update(MemberDto dto) {
		dao.update(dto);
		return "member/update";
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {//ModelAndView 객체도 받을 수 있다.
		//수정할 회원의 정보를 DB 에서 불러온다.
		MemberDto dto = dao.getData(num);
		//ModelAndView 객체를 담고
		mView.addObject("dto",dto);
		//view page 의 정보도 담아서
		mView.setViewName("member/updateform");
		//리턴해준다.
		return mView;
		
	}
	
	@RequestMapping("/member/delete")
	public String delets(int num) { // get 방식 전송 파라미터도 추출 가능 ?num=x
		dao.delete(num);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) { //폼전송되는 name, addr 이 자동으로 추출되어서 MemberDto 에 담겨서 전달된다.
		dao.insert(dto);
		return "member/insert";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		// /WEB-INF/views/member/insertform.jsp 로 forward 이동해서 응답
		return "member/insertform";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView getList(ModelAndView mView) {
		//주입받은 MemberDao 객체를 이용해서 회원 목록을 얻어온다.
		List<MemberDto> list = dao.getList();
		
		//view page 에 전달할 Model 을 담는다.
		mView.addObject("list", list);
		//view page 정보도 담아서
		mView.setViewName("member/list");
		
		//리턴해 준다.
		return mView;
	}
}
