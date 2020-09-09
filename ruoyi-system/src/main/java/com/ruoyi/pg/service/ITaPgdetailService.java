package com.ruoyi.pg.service;

import com.ruoyi.pg.domain.TaPgdetail;

import java.util.List;

/**
 * 评估明细Service接口
 * 
 * @author wsy
 * @date 2020-08-27
 */
public interface ITaPgdetailService 
{
    /**
     * 查询评估明细
     * 
     * @param detailid 评估明细ID
     * @return 评估明细
     */
    public TaPgdetail selectTaPgdetailById(Long detailid);

    /**
     * 查询评估明细列表
     * 
     * @param taPgdetail 评估明细
     * @return 评估明细集合
     */
    public List<TaPgdetail> selectTaPgdetailList(TaPgdetail taPgdetail);

    public List<TaPgdetail> selectTaPgdetailByBatchid(TaPgdetail taPgdetail);

    /**
     * 新增评估明细
     * 
     * @param taPgdetail 评估明细
     * @return 结果
     */
    public int insertTaPgdetail(TaPgdetail taPgdetail);

    public int batchInsertTaPgdetail(List<TaPgdetail> taPgdetailList);
    /**
     * 修改评估明细
     * 
     * @param taPgdetail 评估明细
     * @return 结果
     */
    public int updateTaPgdetail(TaPgdetail taPgdetail);

    /**
     * 批量删除评估明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaPgdetailByIds(String ids);

    public int deleteTaPgdetailByBatchId(String pgbatchid);
    /**
     * 删除评估明细信息
     * 
     * @param detailid 评估明细ID
     * @return 结果
     */
    public int deleteTaPgdetailById(Long detailid);
}
