package com.cc.ssm.dao;

import com.cc.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface ISysLogDao {

    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    @Insert("")
    public void save(SysLog sysLog) throws Exception;
}
