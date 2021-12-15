package com.bitcamp.myhome.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	// 글목록
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("list", dao.boardAllSelect());
		mav.setViewName("board/list");
		return mav;
	}
	// 글내용 보기
	@RequestMapping("/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo", dao.boardView(no));
		mav.setViewName("board/view");
		return mav;
	}
	// 글쓰기 폼
	@RequestMapping("/write")
	public String write() {
		return "board/write";
	}
	// 글쓰기
	@RequestMapping("/writeOk")
	public ModelAndView writeOk(BoardVO vo, HttpSession ses, HttpServletRequest req) {
		vo.setUserid((String)ses.getAttribute("userid"));
		vo.setIp(req.getRemoteAddr());
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardWriteOk(vo);
		if(cnt > 0) { // 글등록
			mav.setViewName("redirect:list");
		} else { // 등록실패
			mav.setViewName("board/writeResult");
		}
		return mav;
	}
	// 글수정 폼
	@RequestMapping("/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo", dao.boardView(no));
		mav.setViewName("board/edit");
		return mav;
	}
}
