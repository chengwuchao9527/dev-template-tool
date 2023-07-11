package com.cheng.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author liangqq
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Modifiable{

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** */
    @Column(name = "create_time",columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP",updatable = false)
    private LocalDateTime createTime;

    /** */
    @Column(name = "modify_time",columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modifyTime;

    /** */
    @Column(name = "create_user")
    private Long createUser;

    /** */
    @Column(name = "modify_user")
    private Long modifyUser;


    public void initCreateParam(Long userId) {
        this.setCreateTime(LocalDateTime.now());
        this.setCreateUser(userId);
        this.setModifyTime(LocalDateTime.now());
        this.setModifyUser(userId);
    }

    /**
     * 修改表数据
     * @param userId
     */
    @Override
    public void initModifyParam(Long userId) {
        this.setModifyTime(LocalDateTime.now());
        this.setModifyUser(userId);
    }
}
