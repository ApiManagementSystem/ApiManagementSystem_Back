package com.may.apimanagementsystem.dao;

import com.may.apimanagementsystem.po.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MessageMapper {

    boolean inviteInsertMessage(Message message);//邀请人加入团队
    boolean insertMessage(Message message);//主动加入团队
    List<Message> selectMessages(int userId);
    boolean deleteMessage(int messageId);
    Message readMyMessage(int messageId);
}
