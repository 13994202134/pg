package com.ruoyi.pg.service;

import java.util.List;
import com.ruoyi.pg.domain.TaPgtable;
import com.ruoyi.pg.domain.view.TaPgtableForView;

/**
 * 评估项Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaPgtableService 
{
    /**
     * 查询评估项
     * 
     * @param id 评估项ID
     * @return 评估项
     */
    public TaPgtable selectTaPgtableById(Integer id);

    /**
     * 查询评估项列表
     * 
     * @param taPgtable 评估项
     * @return 评估项集合
     */
    public List<TaPgtable> selectTaPgtableList(TaPgtable taPgtable);

    /**
     * 新增评估项
     * 
     * @param taPgtable 评估项
     * @return 结果
     */
    public int insertTaPgtable(TaPgtable taPgtable);

    /**
     * 修改评估项
     * 
     * @param taPgtable 评估项
     * @return 结果
     */
    public int updateTaPgtable(TaPgtable taPgtable);

    /**
     * 批量删除评估项
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaPgtableByIds(String ids);

    /**
     * 删除评估项信息
     * 
     * @param id 评估项ID
     * @return 结果
     */
    public int deleteTaPgtableById(Integer id);

    /**
     * 给前端提供的数据
     * @param taPgtable
     * @return
     */
   public List<TaPgtable> selectTaPgtableSmallList(TaPgtable taPgtable);
}
