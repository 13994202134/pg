package com.ruoyi.pg.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaDoctorMapper;
import com.ruoyi.pg.domain.TaDoctor;
import com.ruoyi.pg.service.ITaDoctorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaDoctorServiceImpl implements ITaDoctorService 
{
    @Autowired
    private TaDoctorMapper taDoctorMapper;

    /**
     * 查询人员
     * 
     * @param did 人员ID
     * @return 人员
     */
    @Override
    public TaDoctor selectTaDoctorById(Long did)
    {
        return taDoctorMapper.selectTaDoctorById(did);
    }

    /**
     * 查询人员列表
     * 
     * @param taDoctor 人员
     * @return 人员
     */
    @Override
    public List<TaDoctor> selectTaDoctorList(TaDoctor taDoctor)
    {
        return taDoctorMapper.selectTaDoctorList(taDoctor);
    }

    /**
     * 新增人员
     * 
     * @param taDoctor 人员
     * @return 结果
     */
    @Override
    public int insertTaDoctor(TaDoctor taDoctor)
    {
        taDoctor.setCreateTime(DateUtils.getNowDate());
        return taDoctorMapper.insertTaDoctor(taDoctor);
    }

    /**
     * 修改人员
     * 
     * @param taDoctor 人员
     * @return 结果
     */
    @Override
    public int updateTaDoctor(TaDoctor taDoctor)
    {
        taDoctor.setUpdateTime(DateUtils.getNowDate());
        return taDoctorMapper.updateTaDoctor(taDoctor);
    }

    /**
     * 删除人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaDoctorByIds(String ids)
    {
        return taDoctorMapper.deleteTaDoctorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员信息
     * 
     * @param did 人员ID
     * @return 结果
     */
    @Override
    public int deleteTaDoctorById(Long did)
    {
        return taDoctorMapper.deleteTaDoctorById(did);
    }
}
