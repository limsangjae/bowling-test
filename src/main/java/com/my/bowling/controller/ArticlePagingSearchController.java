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

import com.my.bowling.commons.paging.PageMaker;
import com.my.bowling.commons.paging.SearchCriteria;
import com.my.bowling.domain.vo.ArticleVO;
import com.my.bowling.service.ArticleService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/article/paging/search")
@Log4j
public class ArticlePagingSearchController {
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/write")
    public String writeGET() {

        log.info("search writeGET() called...");

        return "article/search/write";
    }

    @PostMapping("/write")
    public String writePOST(ArticleVO articleVO,
                            RedirectAttributes redirectAttributes) throws Exception {

        log.info("search writePOST() called...");

        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");

        return "redirect:/article/paging/search/list";
    }
    
    
    
    @GetMapping("/list")
    public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception {

        log.info("search list() called ...");
        
        
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        //pageMaker.setTotalCount(articleService.countArticles(searchCriteria));
        pageMaker.setTotalCount(articleService.countSearchedArticles(searchCriteria));

        //model.addAttribute("articles", articleService.listCriteria(searchCriteria));
        model.addAttribute("articles", articleService.listSearch(searchCriteria));
        model.addAttribute("pageMaker", pageMaker);
        
        return "article/search/list";
    }
    
 // 조화 페이지
    @GetMapping("/read")
    public String read(@RequestParam("articleNo") int articleNo,
                       @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception {

        log.info("search read() called ...");
        model.addAttribute("article", articleService.read(articleNo));

        return "article/search/read";
    }
    
 // 수정 페이지
    @GetMapping("/modify")
    public String modifyGET(@RequestParam("articleNo") int articleNo,
                            @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                            Model model) throws Exception {

        log.info("search modifyGet() called ...");
        log.info(searchCriteria.toString());
        model.addAttribute("article", articleService.read(articleNo));

        return "article/search/modify";
    }
    
 // 수정 처리
    @PostMapping("/modify")
    public String modifyPOST(ArticleVO articleVO,
                             SearchCriteria searchCriteria,
                             RedirectAttributes redirectAttributes) throws Exception {

        log.info("search modifyPOST() called ...");
        articleService.update(articleVO);
        redirectAttributes.addAttribute("page", searchCriteria.getPage());
        redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
        redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
        redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/article/paging/search/list";
    }
    
 // 삭제 처리
    @PostMapping("/remove")
    public String remove(@RequestParam("articleNo") int articleNo,
                         SearchCriteria searchCriteria,
                         RedirectAttributes redirectAttributes) throws Exception {

        log.info("search remove() called ...");
        articleService.delete(articleNo);
        redirectAttributes.addAttribute("page", searchCriteria.getPage());
        redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
        redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
        redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/paging/search/list";
    }
}
