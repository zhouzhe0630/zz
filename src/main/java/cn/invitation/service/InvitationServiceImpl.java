package cn.invitation.service;

import cn.invitation.entity.Invitation;
import cn.invitation.entity.Page;
import cn.invitation.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.invitation.dao.InvitationMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private InvitationMapper invitationMapper;

    public void all(Page page, String title) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        page.setCount(invitationMapper.count(params));//总记录数
        if (page.getPageNo() < 1)
            page.setPageNo(1);
        else if (page.getPageNo() > page.getPageCount())
            page.setPageNo(page.getPageCount());
        params.put("from", (page.getPageNo() - 1) * page.getPageSize());
        params.put("pageSize", page.getPageSize());
        page.setPageList(invitationMapper.getList(params));
    }

    public void showReply(Page page, Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        page.setCount(invitationMapper.countReply(params));
        if (page.getPageNo() < 1)
            page.setPageNo(1);
        else if (page.getPageNo() > page.getPageCount())
            page.setPageNo(page.getPageCount());
        params.put("from", (page.getPageNo() - 1) * page.getPageSize());
        params.put("pageSize", page.getPageSize());
        page.setPageList(invitationMapper.showReply(params));
    }

    public int add(Reply reply) {
        if (reply.getAuthor().equals(""))
            reply.setAuthor("匿名用户");
        return invitationMapper.add(reply);
    }

    @Transactional
    public int dele(Integer id) {
        invitationMapper.deleRe(id);//从表
        int i = invitationMapper.dele(id);//主表
        return i > 0 ? i : 0;
    }

}
