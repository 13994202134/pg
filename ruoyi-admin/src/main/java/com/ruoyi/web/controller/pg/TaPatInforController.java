package com.ruoyi.web.controller.pg;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.pg.domain.TaPatInfor;
import com.ruoyi.pg.service.ITaPatInforService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病人基本信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/infor")
public class TaPatInforController extends BaseController
{
    private String prefix = "pg/infor";

    @Autowired
    private ITaPatInforService taPatInforService;

    @RequiresPermissions("pg:infor:view")
    @GetMapping()
    public String infor()
    {
        return prefix + "/infor";
    }

    /**
     * 查询病人基本信息列表
     */
/*    @RequiresPermissions("pg:infor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaPatInfor taPatInfor)
    {
        startPage();
        List<TaPatInfor> list = taPatInforService.selectTaPatInforList(taPatInfor);
        return getDataTable(list);
    }*/
    /**
     * 查询病人-部门基本信息列表
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaPatInfor taPatInfor)
    {
        startPage();
        List<TaPatInfor> list = taPatInforService.selectPdByPara(taPatInfor);
        return getDataTable(list);
    }




    /**
     * 导出病人基本信息列表
     */
    @RequiresPermissions("pg:infor:export")
    @Log(title = "病人基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaPatInfor taPatInfor)
    {
        List<TaPatInfor> list = taPatInforService.selectTaPatInforList(taPatInfor);
        ExcelUtil<TaPatInfor> util = new ExcelUtil<TaPatInfor>(TaPatInfor.class);
        return util.exportExcel(list, "infor");
    }

    /**
     * 新增病人基本信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存病人基本信息
     */
    @RequiresPermissions("pg:infor:add")
    @Log(title = "病人基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaPatInfor taPatInfor)
    {
        return toAjax(taPatInforService.insertTaPatInfor(taPatInfor));
    }

    /**
     * 修改病人基本信息
     */
    @GetMapping("/edit/{patid}")
    public String edit(@PathVariable("patid") Long patid, ModelMap mmap)
    {
        TaPatInfor taPatInfor = taPatInforService.selectTaPatInforById(patid);
        mmap.put("taPatInfor", taPatInfor);
        return prefix + "/edit";
    }

    /**
     * 修改保存病人基本信息
     */
    @RequiresPermissions("pg:infor:edit")
    @Log(title = "病人基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaPatInfor taPatInfor)
    {
        return toAjax(taPatInforService.updateTaPatInfor(taPatInfor));
    }

    /**
     * 删除病人基本信息
     */
    @RequiresPermissions("pg:infor:remove")
    @Log(title = "病人基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taPatInforService.deleteTaPatInforByIds(ids));
    }
}
