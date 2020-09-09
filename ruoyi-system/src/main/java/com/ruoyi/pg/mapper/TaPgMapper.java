package com.ruoyi.pg.mapper;

import java.util.List;

import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.SubtotalS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.TotalS;
import com.ruoyi.pg.domain.TaPg;

/**
 * 评估总Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface TaPgMapper 
{
    /**
     * 查询评估总
     * 
     * @param pgid 评估总ID
     * @return 评估总
     */
    public TaPg selectTaPgById(Long pgid);

    /**
     * 查询评估总列表
     * 
     * @param taPg 评估总
     * @return 评估总集合
     */
    public List<TaPg> selectTaPgList(TaPg taPg);

    /**
     * 查询评估-医生姓名-病人姓名-总列表
     *
     * @param taPg 评估总
     * @return 评估总集合
     */
    public List<TaPg> selectPgByPara(TaPg taPg);

     public List<TaPg> selectTaPgByPgbatchid(String pgbatchid);

    public TotalS selectTotalSByPgbatchid(String pgbatchid);

    public List<SubtotalS> selectSubtotalSByPgbatchid(String pgbatchid);

     public List<TaPg> selectTaPgAll();

    /**
     * 新增评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    public int insertTaPg(TaPg taPg);

    /**
     * 修改评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    public int updateTaPg(TaPg taPg);

    /**
     * 删除评估总
     * 
     * @param pgid 评估总ID
     * @return 结果
     */
    public int deleteTaPgById(Long pgid);

    /**
     * 批量删除评估总
     * 
     * @param pgids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaPgByIds(String[] pgids);


    public int batchInsertPg(List<TaPg> taPgList);

    public   int deleteTaPgByBatchId(String pgbatchid);
}
