package com.cc.ssm.service;

import com.cc.ssm.domain.SysLog;

public interface ISysLogService {

    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;
}
