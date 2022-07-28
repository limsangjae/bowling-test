package com.my.bowling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/article/paging")
@Log4j
public class ArticlePagingController {
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/write")
	public String writeGet() {
		
		log.info("paging writeGet() called...");
		
		return "article/paging/write";
	}
	
	@PostMapping("/write")
	public String writePost(ArticleVO articleVO, RedirectAttributes redirect) throws Exception {
		
		log.info("paging writePost() called... ");
		
		articleService.create(articleVO);
		redirect.addFlashAttribute("msg", "regSuccess");
		
		return "redirect:/article/paging/list";
	}
	
	@GetMapping("/list")
	public String list(Model model, Criteria criteria) throws Exception{
		
		log.info("paging list() called...");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(articleService.countArticles(criteria));
		
			
		model.addAttribute("articles", articleService.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		
		return "article/paging/list";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("articleNo") int articleNo,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		
		log.info("paging read() called...");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "article/paging/read";
	}
	
	@GetMapping("/modify")
	public String modifyGet(@RequestParam("articleNo") int articleNo,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		
		log.info("paging modifyGet() called...");
		model.addAttribute("article", articleService.read(articleNo));
		
		return "article/paging/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(ArticleVO articleVO, Criteria criteria, RedirectAttributes redirect) throws Exception {
		
		log.info("paging modifyPost() called...");
		articleService.update(articleVO);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("perPageNum",criteria.getPerPageNum());
		redirect.addFlashAttribute("msg", "modeSuccess");
		
		return "redirect:/article/paging/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("articleNo") int articleNo,
			Criteria criteria, RedirectAttributes redirect) throws Exception {
		
		log.info("paging remove() called...");
		articleService.delete(articleNo);
		redirect.addAttribute("page", criteria.getPage());
		redirect.addAttribute("perPageNum",criteria.getPerPageNum());
		redirect.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/article/paging/list";
	}
	


}
