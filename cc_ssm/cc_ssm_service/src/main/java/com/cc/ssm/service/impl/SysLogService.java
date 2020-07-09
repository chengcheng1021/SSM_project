package com.cc.ssm.service.impl;

import com.cc.ssm.dao.ISysLogDao;
import com.cc.ssm.domain.SysLog;
import com.cc.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogService implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    /**
     * 保存日志
     *
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    /**
     * 查询所有日志
     *
     * @return
     */
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
