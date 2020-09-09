package com.ruoyi.pg.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaDpmentMapper;
import com.ruoyi.pg.domain.TaDpment;
import com.ruoyi.pg.service.ITaDpmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaDpmentServiceImpl implements ITaDpmentService 
{
    @Autowired
    private TaDpmentMapper taDpmentMapper;

    /**
     * 查询部门
     * 
     * @param dpid 部门ID
     * @return 部门
     */
    @Override
    public TaDpment selectTaDpmentById(Long dpid)
    {
        return taDpmentMapper.selectTaDpmentById(dpid);
    }

    /**
     * 查询部门列表
     * 
     * @param taDpment 部门
     * @return 部门
     */
    @Override
    public List<TaDpment> selectTaDpmentList(TaDpment taDpment)
    {
        return taDpmentMapper.selectTaDpmentList(taDpment);
    }

    /**
     * 新增部门
     * 
     * @param taDpment 部门
     * @return 结果
     */
    @Override
    public int insertTaDpment(TaDpment taDpment)
    {
        taDpment.setCreateTime(DateUtils.getNowDate());
        return taDpmentMapper.insertTaDpment(taDpment);
    }

    /**
     * 修改部门
     * 
     * @param taDpment 部门
     * @return 结果
     */
    @Override
    public int updateTaDpment(TaDpment taDpment)
    {
        taDpment.setUpdateTime(DateUtils.getNowDate());
        return taDpmentMapper.updateTaDpment(taDpment);
    }

    /**
     * 删除部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaDpmentByIds(String ids)
    {
        return taDpmentMapper.deleteTaDpmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门信息
     * 
     * @param dpid 部门ID
     * @return 结果
     */
    @Override
    public int deleteTaDpmentById(Long dpid)
    {
        return taDpmentMapper.deleteTaDpmentById(dpid);
    }
}
