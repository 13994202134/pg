package com.ruoyi.pg.service;

import java.util.List;
import com.ruoyi.pg.domain.TaDpment;

/**
 * 部门Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaDpmentService 
{
    /**
     * 查询部门
     * 
     * @param dpid 部门ID
     * @return 部门
     */
    public TaDpment selectTaDpmentById(Long dpid);

    /**
     * 查询部门列表
     * 
     * @param taDpment 部门
     * @return 部门集合
     */
    public List<TaDpment> selectTaDpmentList(TaDpment taDpment);

    /**
     * 新增部门
     * 
     * @param taDpment 部门
     * @return 结果
     */
    public int insertTaDpment(TaDpment taDpment);

    /**
     * 修改部门
     * 
     * @param taDpment 部门
     * @return 结果
     */
    public int updateTaDpment(TaDpment taDpment);

    /**
     * 批量删除部门
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaDpmentByIds(String ids);

    /**
     * 删除部门信息
     * 
     * @param dpid 部门ID
     * @return 结果
     */
    public int deleteTaDpmentById(Long dpid);
}
