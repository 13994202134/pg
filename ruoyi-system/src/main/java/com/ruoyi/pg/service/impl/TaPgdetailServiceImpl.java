package com.ruoyi.pg.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.pg.domain.TaPgdetail;
import com.ruoyi.pg.service.ITaPgdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaPgdetailMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 评估明细Service业务层处理
 * 
 * @author wsy
 * @date 2020-08-27
 */
@Service
public class TaPgdetailServiceImpl implements ITaPgdetailService
{
    @Autowired
    private TaPgdetailMapper taPgdetailMapper;

    /**
     * 查询评估明细
     * 
     * @param detailid 评估明细ID
     * @return 评估明细
     */
    @Override
    public TaPgdetail selectTaPgdetailById(Long detailid)
    {
        return taPgdetailMapper.selectTaPgdetailById(detailid);
    }

    /**
     * 查询评估明细列表
     * 
     * @param taPgdetail 评估明细
     * @return 评估明细
     */
    @Override
    public List<TaPgdetail> selectTaPgdetailList(TaPgdetail taPgdetail)
    {
        return taPgdetailMapper.selectTaPgdetailList(taPgdetail);
    }

    @Override
    public List<TaPgdetail> selectTaPgdetailByBatchid(TaPgdetail taPgdetail) {
        return taPgdetailMapper.selectTaPgdetailByBatchid(taPgdetail);
    }


    /**
     * 新增评估明细
     * 
     * @param taPgdetail 评估明细
     * @return 结果
     */
    @Override
    public int insertTaPgdetail(TaPgdetail taPgdetail)
    {
        taPgdetail.setCreateTime(DateUtils.getNowDate());
        return taPgdetailMapper.insertTaPgdetail(taPgdetail);
    }
    @Override
    public int batchInsertTaPgdetail(List<TaPgdetail> taPgdetailList)
    {
        for(int i=0;i<taPgdetailList.size();i++)
        {
            taPgdetailList.get(i).setCreateTime(DateUtils.getNowDate());
        }
        System.out.println("批量插入详细方法中的待插入信息======="+taPgdetailList);
        return taPgdetailMapper.batchInsertPgdetail(taPgdetailList);
    }

    /**
     * 修改评估明细
     * 
     * @param taPgdetail 评估明细
     * @return 结果
     */
    @Override
    public int updateTaPgdetail(TaPgdetail taPgdetail)
    {
        taPgdetail.setUpdateTime(DateUtils.getNowDate());
        return taPgdetailMapper.updateTaPgdetail(taPgdetail);
    }

    /**
     * 删除评估明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaPgdetailByIds(String ids)
    {
        return taPgdetailMapper.deleteTaPgdetailByIds(Convert.toStrArray(ids));
    }

    @Override
    public int deleteTaPgdetailByBatchId(String pgbatchid) {
        return taPgdetailMapper.deleteTaPgdetailByBatchId(pgbatchid);
    }

    /**
     * 删除评估明细信息
     * 
     * @param detailid 评估明细ID
     * @return 结果
     */
    @Override
    public int deleteTaPgdetailById(Long detailid)
    {
        return taPgdetailMapper.deleteTaPgdetailById(detailid);
    }

}
