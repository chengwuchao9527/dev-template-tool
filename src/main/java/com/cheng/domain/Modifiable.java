package com.cheng.domain;

/**
 * 标记可修改,统一管理修改操作
 * @author liangqq
 */
public interface Modifiable {


    /**
     * 修改表数据
     * @param userId 修改的用户id
     */
    public void initModifyParam(Long userId);
}
