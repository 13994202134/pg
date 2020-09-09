package com.ruoyi.pg.service;

import java.util.List;
import com.ruoyi.pg.domain.TaDoctor;

/**
 * 人员Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaDoctorService 
{
    /**
     * 查询人员
     * 
     * @param did 人员ID
     * @return 人员
     */
    public TaDoctor selectTaDoctorById(Long did);

    /**
     * 查询人员列表
     * 
     * @param taDoctor 人员
     * @return 人员集合
     */
    public List<TaDoctor> selectTaDoctorList(TaDoctor taDoctor);

    /**
     * 新增人员
     * 
     * @param taDoctor 人员
     * @return 结果
     */
    public int insertTaDoctor(TaDoctor taDoctor);

    /**
     * 修改人员
     * 
     * @param taDoctor 人员
     * @return 结果
     */
    public int updateTaDoctor(TaDoctor taDoctor);

    /**
     * 批量删除人员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaDoctorByIds(String ids);

    /**
     * 删除人员信息
     * 
     * @param did 人员ID
     * @return 结果
     */
    public int deleteTaDoctorById(Long did);
}
