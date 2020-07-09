package com.cc.ssm.service;

import com.cc.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志
     * @return
     */
    List<SysLog> findAll() throws Exception;
}
