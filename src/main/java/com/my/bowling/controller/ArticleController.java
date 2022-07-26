package com.my.bowling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.bowling.commons.paging.Criteria;
import com.my.bowling.commons.paging.PageMaker;
import com.my.bowling.domain.vo.ArticleVO;
import com.my.bowling.service.ArticleService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/article")
@Log4j
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	

	
	//등록 페이지 이동
	@GetMapping("/write")
	public String writeGet() {
		log.info("write GET...............");
		
		return "/article/write";
	}
	
	//등록 처리
	@PostMapping("/write")
	public String writePost(ArticleVO articleVO, RedirectAttributes redirect) throws Exception {
		log.info("write POST...............");
		log.info(articleVO.toString());
		articleService.create(articleVO);
		redirect.addFlashAttribute("msg", "regSuccess");
		
		return "redirect:/article/list";
	}
	
	//목록 페이지 이동
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		log.info("list...............");
		
		model.addAttribute("articles", articleService.listAll());
		
		return "/article/list";
	}
	
	//조회 페이지 이동
	@GetMapping("/read")
	public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
		log.info("read...............");
		model.addAttribute("article", articleService.read(articleNo));
		return "/article/read";
	}
	
	//수정 페이지 이동
	@GetMapping("/modify")
	public String modifyGet(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
		
		log.info("modify GET...............");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "article/modify";
	}
	
	//수정 처리
	@PostMapping("/modify")
	public String modifyPost(ArticleVO articleVO, RedirectAttributes redirect) throws Exception{
		
		log.info("modify POST...............");
		articleService.update(articleVO);
		redirect.addFlashAttribute("msg", "modSuccess");
		
		
		return "redirect:/article/list";
	}
	
	//삭제 처리
	@PostMapping("/remove")
	public String remove(@RequestParam("articleNo") int articleNo, RedirectAttributes redirect) throws Exception{
		
		log.info("remove...............");
		articleService.delete(articleNo);
		redirect.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/article/list";
	}
	
	@GetMapping("/listCriteria")
	public String listCriteria(Model model, Criteria criteria) throws Exception{
		
		log.info("listCriteria............");
		model.addAttribute("articles", articleService.listCriteria(criteria));
		
		return "/article/list_criteria";
	}
	
	@GetMapping("/listPaging")
	public String listPaging(Model model, Criteria criteria) throws Exception{
		
		log.info("listPaging............");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(articleService.countArticles(criteria));
		
			
		model.addAttribute("articles", articleService.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		
		return "/article/list_paging";
	}
	
	@GetMapping("/readPaging")
	public String readPaging(@RequestParam("articleNo") int articleNo,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/read_paging";
	}
	
	@GetMapping("/modifyPaging")
	public String modifyGetPaging(@RequestParam("articleNo") int articleNo,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		
		log.info("modifyGetPaging...");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/modify_paging";
	}
	
	@PostMapping("/modifyPaging")
	public String modifyPostPaging(ArticleVO articleVO, Criteria criteria, RedirectAttributes redirect) throws Exception {
		
		log.info("modifyPostPaging...");
		articleService.update(articleVO);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("perPageNum",criteria.getPerPageNum());
		redirect.addFlashAttribute("msg", "modeSuccess");
		
		return "redirect:/article/listPaging";
	}
	
	@PostMapping("/removePaging")
	public String removePaging(@RequestParam("articleNo") int articleNo,
			Criteria criteria, RedirectAttributes redirect) throws Exception {
		
		log.info("remove...");
		articleService.delete(articleNo);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("perPageNum",criteria.getPerPageNum());
		redirect.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/article/listPaging";
	}
	
	
	
	
}








