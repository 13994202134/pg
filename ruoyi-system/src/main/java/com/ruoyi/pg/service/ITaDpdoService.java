package com.ruoyi.pg.service;

import java.util.List;
import com.ruoyi.pg.domain.TaDpdo;

/**
 * 部门人员对照Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaDpdoService 
{
    /**
     * 查询部门人员对照
     * 
     * @param dpid 部门人员对照ID
     * @return 部门人员对照
     */
    public TaDpdo selectTaDpdoById(Long dpid);

    /**
     * 查询部门人员对照列表
     * 
     * @param taDpdo 部门人员对照
     * @return 部门人员对照集合
     */
    public List<TaDpdo> selectTaDpdoList(TaDpdo taDpdo);

    /**
     * 新增部门人员对照
     * 
     * @param taDpdo 部门人员对照
     * @return 结果
     */
    public int insertTaDpdo(TaDpdo taDpdo);

    /**
     * 修改部门人员对照
     * 
     * @param taDpdo 部门人员对照
     * @return 结果
     */
    public int updateTaDpdo(TaDpdo taDpdo);

    /**
     * 批量删除部门人员对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaDpdoByIds(String ids);

    /**
     * 删除部门人员对照信息
     * 
     * @param dpid 部门人员对照ID
     * @return 结果
     */
    public int deleteTaDpdoById(Long dpid);
}
