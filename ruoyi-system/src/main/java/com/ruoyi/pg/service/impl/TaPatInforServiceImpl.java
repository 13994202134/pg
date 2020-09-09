package com.ruoyi.pg.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaPatInforMapper;
import com.ruoyi.pg.domain.TaPatInfor;
import com.ruoyi.pg.service.ITaPatInforService;
import com.ruoyi.common.core.text.Convert;

/**
 * 病人基本信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaPatInforServiceImpl implements ITaPatInforService 
{
    @Autowired
    private TaPatInforMapper taPatInforMapper;

    /**
     * 查询病人基本信息
     * 
     * @param patid 病人基本信息ID
     * @return 病人基本信息
     */
    @Override
    public TaPatInfor selectTaPatInforById(Long patid)
    {
        return taPatInforMapper.selectTaPatInforById(patid);
    }

    /**
     * 查询病人基本信息列表
     * 
     * @param taPatInfor 病人基本信息
     * @return 病人基本信息
     */
    @Override
    public List<TaPatInfor> selectTaPatInforList(TaPatInfor taPatInfor)
    {
        return taPatInforMapper.selectTaPatInforList(taPatInfor);
    }


    /**
     * 查询病人-科室基本信息列表
     *
     * @param taPatInfor 病人基本信息
     * @return 病人基本信息
     */
    @Override
    public List<TaPatInfor> selectPdByPara(TaPatInfor taPatInfor)
    {
        return taPatInforMapper.selectPdByPara(taPatInfor);
    }

    /**
     * 新增病人基本信息
     * 
     * @param taPatInfor 病人基本信息
     * @return 结果
     */
    @Override
    public int insertTaPatInfor(TaPatInfor taPatInfor)
    {
        return taPatInforMapper.insertTaPatInfor(taPatInfor);
    }

    /**
     * 修改病人基本信息
     * 
     * @param taPatInfor 病人基本信息
     * @return 结果
     */
    @Override
    public int updateTaPatInfor(TaPatInfor taPatInfor)
    {
        return taPatInforMapper.updateTaPatInfor(taPatInfor);
    }

    /**
     * 删除病人基本信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaPatInforByIds(String ids)
    {
        return taPatInforMapper.deleteTaPatInforByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除病人基本信息信息
     * 
     * @param patid 病人基本信息ID
     * @return 结果
     */
    @Override
    public int deleteTaPatInforById(Long patid)
    {
        return taPatInforMapper.deleteTaPatInforById(patid);
    }
}
