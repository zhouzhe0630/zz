package cn.invitation.dao;

import cn.invitation.entity.Invitation;
import cn.invitation.entity.Reply;

import java.util.List;
import java.util.Map;

public interface InvitationMapper {
    public List<Invitation> getList(Map<String, Object> params);

    public int count(Map<String, Object> params);

    public List<Reply> showReply(Map<String, Object> params);

    public int countReply(Map<String, Object> params);

    public int add(Reply reply);

    public int dele(Integer id);

    public int deleRe(Integer id);
}
