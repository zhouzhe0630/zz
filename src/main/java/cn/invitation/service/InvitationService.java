package cn.invitation.service;

import cn.invitation.entity.Invitation;
import cn.invitation.entity.Page;
import cn.invitation.entity.Reply;

import java.util.List;

public interface InvitationService {
    public void all(Page page, String title);

    public void showReply(Page page, Integer id);

    public int add(Reply reply);

    public int dele(Integer id);
}
