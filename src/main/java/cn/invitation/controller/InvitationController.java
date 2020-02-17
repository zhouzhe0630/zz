package cn.invitation.controller;

import cn.invitation.entity.Page;
import cn.invitation.entity.Reply;
import cn.invitation.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/all")
    public String all(@RequestParam(defaultValue = "1") Integer pageNo, String title, HttpServletRequest request) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(3);
        invitationService.all(page, title);
        request.setAttribute("title", title);
        request.setAttribute("page", page);
        request.setAttribute("all", page.getPageList());
        return "all";
    }

    @RequestMapping("/show")
    public String showReply(@RequestParam(defaultValue = "1") Integer pageNo, Integer invid, HttpServletRequest request, HttpSession session) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(1);
        invitationService.showReply(page, invid);
        request.setAttribute("replyList", page.getPageList());
        request.setAttribute("page1", page);
        session.setAttribute("invid", invid);
        return "showReply";
    }

    @RequestMapping("/add")
    public String add(Integer invid, HttpServletRequest request) {
        request.setAttribute("invid", invid);
        return "add";
    }

    @RequestMapping("/add1")
    public String add1(Reply reply, HttpServletResponse response) throws IOException {
        reply.setCreateDate(new Date());
        int result = invitationService.add(reply);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(result > 0 ? "<script>alert('添加回复成功！')</script>" : "<script>alert('添加回复失败！')</script>");
        out.flush();
        return "forward:/all";
    }

    @RequestMapping("/dele")
    public String dele(Integer id, HttpServletRequest request) {
        int i = invitationService.dele(id);
        request.setAttribute("result", i > 0 ? "删除成功!" : "删除失败!");
        return "forward:/all";
    }
}
