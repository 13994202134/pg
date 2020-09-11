package com.ruoyi.pg.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.pg.domain.InPara.scheme1.PgInPara;
import com.ruoyi.pg.domain.InPara.scheme2.Details.*;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInParaS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInparaSA;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.SubtotalS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.TotalS;
import com.ruoyi.pg.domain.TaPg;
import com.ruoyi.pg.domain.TaPgdetail;

/**
 * 评估总Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaPgService 
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

    public List<TaPg>  selectTaPgByPgbatchid(String pgbatchid);

    public TotalS selectTotalSByPgbatchid(String pgbatchid);

    public List<SubtotalS>  selectSubtotalSByPgbatchid(String pgbatchid);

    public List<TaPg>  selectTaPgAll();


    /**
     * 查询评估总列表
     *
     * @param taPg 评估总
     * @return 评估总集合
     */
    public List<TaPg> selectPgByPara(TaPg taPg);



    /**
     * 新增评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    public int insertTaPg(TaPg taPg);

    public int batchInsertTaPg(List<TaPg> taPgList);

    /**
     * 修改评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    public int updateTaPg(TaPg taPg);

    /**
     * 批量删除评估总
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaPgByIds(String ids);

    /**
     * 删除评估总信息
     * 
     * @param pgid 评估总ID
     * @return 结果
     */
    public int deleteTaPgById(Long pgid);

    public int deleteTaPgByBatchId(String pgbatchid);

    public int batchInsertAll(PgInPara pgInPara) throws ParseException;


    public   int batchInsertByJosn(PgInParaS pgInPara, DetailRoot detailRootList);



    public int DelIns(String PgTotalStr,String pgbatchid);



    public int batchInsertByJosnAll(String pgInPara);

    /**
     * 子表合并
     * @param pgInParaStr
     * @return
     */
    public int batchInsertByJosnDetail(String pgInParaStr);
}
