package com.cc.ssm.dao;

import com.cc.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    /**
     * 查找单个会员
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
