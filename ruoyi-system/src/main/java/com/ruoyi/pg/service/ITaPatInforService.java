package com.ruoyi.pg.service;

import java.util.List;
import com.ruoyi.pg.domain.TaPatInfor;

/**
 * 病人基本信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface ITaPatInforService 
{
    /**
     * 查询病人基本信息
     * 
     * @param patid 病人基本信息ID
     * @return 病人基本信息
     */
    public TaPatInfor selectTaPatInforById(Long patid);

    /**
     * 查询病人基本信息列表
     * 
     * @param taPatInfor 病人基本信息
     * @return 病人基本信息集合
     */
    public List<TaPatInfor> selectTaPatInforList(TaPatInfor taPatInfor);
    /**
     * 查询病人-科室基本信息列表
     *
     * @param taPatInfor 病人基本信息
     * @return 病人基本信息
     */

    public List<TaPatInfor> selectPdByPara(TaPatInfor taPatInfor);
    /**
     * 新增病人基本信息
     * 
     * @param taPatInfor 病人基本信息
     * @return 结果
     */
    public int insertTaPatInfor(TaPatInfor taPatInfor);

    /**
     * 修改病人基本信息
     * 
     * @param taPatInfor 病人基本信息
     * @return 结果
     */
    public int updateTaPatInfor(TaPatInfor taPatInfor);

    /**
     * 批量删除病人基本信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaPatInforByIds(String ids);

    /**
     * 删除病人基本信息信息
     * 
     * @param patid 病人基本信息ID
     * @return 结果
     */
    public int deleteTaPatInforById(Long patid);
}
