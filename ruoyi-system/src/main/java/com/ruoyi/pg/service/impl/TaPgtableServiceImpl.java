package com.ruoyi.pg.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.pg.domain.view.TaPgtableForView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaPgtableMapper;
import com.ruoyi.pg.domain.TaPgtable;
import com.ruoyi.pg.service.ITaPgtableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评估项Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaPgtableServiceImpl implements ITaPgtableService 
{
    @Autowired
    private TaPgtableMapper taPgtableMapper;

    /**
     * 查询评估项
     * 
     * @param id 评估项ID
     * @return 评估项
     */
    @Override
    public TaPgtable selectTaPgtableById(Integer id)
    {
        return taPgtableMapper.selectTaPgtableById(id);
    }

    /**
     * 查询评估项列表
     * 
     * @param taPgtable 评估项
     * @return 评估项
     */
    @Override
    public List<TaPgtable> selectTaPgtableList(TaPgtable taPgtable)
    {
        return taPgtableMapper.selectTaPgtableList(taPgtable);
    }

    @Override
    public List<TaPgtable> selectTaPgtableSmallList(TaPgtable taPgtable) {
        return taPgtableMapper.selectTaPgtableSmallList(taPgtable);
    }

    /**
     * 新增评估项
     * 
     * @param taPgtable 评估项
     * @return 结果
     */
    @Override
    public int insertTaPgtable(TaPgtable taPgtable)
    {
        taPgtable.setCreateTime(DateUtils.getNowDate());
        return taPgtableMapper.insertTaPgtable(taPgtable);
    }

    /**
     * 修改评估项
     * 
     * @param taPgtable 评估项
     * @return 结果
     */
    @Override
    public int updateTaPgtable(TaPgtable taPgtable)
    {
        taPgtable.setUpdateTime(DateUtils.getNowDate());
        return taPgtableMapper.updateTaPgtable(taPgtable);
    }

    /**
     * 删除评估项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaPgtableByIds(String ids)
    {
        return taPgtableMapper.deleteTaPgtableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评估项信息
     * 
     * @param id 评估项ID
     * @return 结果
     */
    @Override
    public int deleteTaPgtableById(Integer id)
    {
        return taPgtableMapper.deleteTaPgtableById(id);
    }


}
