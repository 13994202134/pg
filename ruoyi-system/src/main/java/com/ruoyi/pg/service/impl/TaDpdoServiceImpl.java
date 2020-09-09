package com.ruoyi.pg.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaDpdoMapper;
import com.ruoyi.pg.domain.TaDpdo;
import com.ruoyi.pg.service.ITaDpdoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 部门人员对照Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaDpdoServiceImpl implements ITaDpdoService 
{
    @Autowired
    private TaDpdoMapper taDpdoMapper;

    /**
     * 查询部门人员对照
     * 
     * @param dpid 部门人员对照ID
     * @return 部门人员对照
     */
    @Override
    public TaDpdo selectTaDpdoById(Long dpid)
    {
        return taDpdoMapper.selectTaDpdoById(dpid);
    }

    /**
     * 查询部门人员对照列表
     * 
     * @param taDpdo 部门人员对照
     * @return 部门人员对照
     */
    @Override
    public List<TaDpdo> selectTaDpdoList(TaDpdo taDpdo)
    {
        return taDpdoMapper.selectTaDpdoList(taDpdo);
    }

    /**
     * 新增部门人员对照
     * 
     * @param taDpdo 部门人员对照
     * @return 结果
     */
    @Override
    public int insertTaDpdo(TaDpdo taDpdo)
    {
        taDpdo.setCreateTime(DateUtils.getNowDate());
        return taDpdoMapper.insertTaDpdo(taDpdo);
    }

    /**
     * 修改部门人员对照
     * 
     * @param taDpdo 部门人员对照
     * @return 结果
     */
    @Override
    public int updateTaDpdo(TaDpdo taDpdo)
    {
        taDpdo.setUpdateTime(DateUtils.getNowDate());
        return taDpdoMapper.updateTaDpdo(taDpdo);
    }

    /**
     * 删除部门人员对照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaDpdoByIds(String ids)
    {
        return taDpdoMapper.deleteTaDpdoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门人员对照信息
     * 
     * @param dpid 部门人员对照ID
     * @return 结果
     */
    @Override
    public int deleteTaDpdoById(Long dpid)
    {
        return taDpdoMapper.deleteTaDpdoById(dpid);
    }
}
