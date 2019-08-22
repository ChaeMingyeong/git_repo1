package score.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreVO;

import score.helper.RegexHelper;

@Controller
public class ScoreController {
	
	@Autowired
	private ScoreServiceImpl scoreService;
	
	@RequestMapping(value="/score/scoreWriteForm.do")
	public ModelAndView scoreWriteForm() {
		System.out.println("새글쓰기");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../score/scoreWriteForm.jsp");
		modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreWrite.do")
	public ModelAndView scoreWrite(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("성적입력 처리");
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		String kor_str = request.getParameter("kor");
		String eng_str = request.getParameter("eng");
		String mat_str = request.getParameter("mat");

		int kor = 0;
		int eng = 0;
		int mat = 0;
		int result = 0;
		if (!RegexHelper.getInstance().isNum(kor_str)) {
			result = -1;
		} else if (!RegexHelper.getInstance().isNum(eng_str)) {
			result = -1;
		} else if (!RegexHelper.getInstance().isNum(mat_str)) {
			result = -1;
		} else {
			kor = Integer.parseInt(kor_str);
			eng = Integer.parseInt(eng_str);
			mat = Integer.parseInt(mat_str);
			
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setStudNo(studNo);
			scoreVO.setName(name);
			scoreVO.setKor(kor);
			scoreVO.setEng(eng);
			scoreVO.setMat(mat);
			int tot = kor + eng + mat;
			double avg = (double) tot / 3;
			scoreVO.setTot(tot);
			scoreVO.setAvg(avg);
			result = scoreService.scoreWrite(scoreVO);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("display", "../score/scoreWrite.jsp");
		modelAndView.setViewName("/main/index.jsp");
//		String viewPage ="";
//		
//		if(result>0) {
//			viewPage = "scoreList.do?pg=1";
//		}else {
//		    viewPage ="scoreWrite";	
//		}
       return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreList.do")
	public ModelAndView scoreList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("목록 처리");
		
		// 1) 데이터 처리
		int pg = 1;
		String pg_str =request.getParameter("pg");
		
		if(RegexHelper.getInstance().isNum(pg_str)) {
			pg= Integer.parseInt(pg_str);
		}
		// 목록처리 (5줄씩)
		int endNum = pg * 5;
		int startNum = endNum - 4;
		// 2) DB 처리
		
		List<ScoreVO> scoreList = scoreService.scoreList(startNum, endNum);
		
		// 페이징 처리
		int totalA = scoreService.getTotalA();	// 총목록수
		int totalP = (totalA + 4) / 5;		// 총 페이지수
		
		int startPage = (pg-1)/3*3 + 1;  //페이지 3개씩만 보여줌
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		// 3) 데이터 공유 처리
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", scoreList);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("display", "../score/scoreList.jsp");
		modelAndView.setViewName("/main/index.jsp");
		// 4) 화면 네비게이션
		return modelAndView; // ./board/boardList.jsp
			
	}
	
	@RequestMapping(value="/score/scoreView.do")
	public ModelAndView scoreView(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("상세보기");
		// 1) 데이터 처리
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2) DB
		
		
		ScoreVO scoreVO = scoreService.scoreView(studNo);
		// 3) 데이터 공유
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("scoreVO", scoreVO);
		modelAndView.addObject("display", "../score/scoreView.jsp");
		modelAndView.setViewName("/main/index.jsp");
		// 4) 화면 네비게이션	
		
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreDelete.do")
	public ModelAndView scoreDelete(HttpServletRequest request) {
		// 1) 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		// 2) DB
		
		int result = scoreService.boardDelete(studNo);
		// 3) 데이터 공유
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("result", result);
		modelAndView.addObject("display", "../score/scoreDelete.jsp");
		modelAndView.setViewName("/main/index.jsp");
		// 4) 화면 네비게이션
		return modelAndView; // ./board/boardDelete.jsp
	}
	
	@RequestMapping(value="/score/scoreModifyForm.do")
	public ModelAndView scoreModifyForm(HttpServletRequest request, HttpServletResponse response)  {
		System.out.println("수정하기");
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ScoreVO scoreVO = scoreService.scoreView(studNo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("scoreVO", scoreVO);
		modelAndView.addObject("display", "../score/scoreModifyForm.jsp");
		modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/score/scoreModify.do")
	public ModelAndView scoreModify(HttpServletRequest request, HttpServletResponse response) {
		//1. 데이터처리
		//2. DB
		//3/ ModelAndView 작업 = 공유데이터 + view 처리 파일
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("성적수정 처리");
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		String kor_str = request.getParameter("kor");
		String eng_str = request.getParameter("eng");
		String mat_str = request.getParameter("mat");
		
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int result = 0;
		
		if(RegexHelper.getInstance().isNum(kor_str)&&RegexHelper.getInstance().isNum(eng_str)&&RegexHelper.getInstance().isNum(mat_str)) {
			kor = Integer.parseInt(kor_str);
			eng = Integer.parseInt(eng_str);
			mat = Integer.parseInt(mat_str);
			
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setStudNo(studNo);
			scoreVO.setName(name);
			scoreVO.setKor(kor);
			scoreVO.setEng(eng);
			scoreVO.setMat(mat);
			int tot = kor + eng + mat;
			double avg = (double) tot / 3;
			scoreVO.setTot(tot);
			scoreVO.setAvg(avg);
			result = scoreService.scoreModify(scoreVO);
		}else {
			result = -1;
		}
		

		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("result",result);
		modelAndView.addObject("studNo",studNo);
		modelAndView.addObject("display", "../score/scoreModify.jsp");
		modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
	}

	

}
