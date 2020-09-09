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
import com.ruoyi.pg.domain.TaDpdo;
import com.ruoyi.pg.service.ITaDpdoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门人员对照Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/dpdo")
public class TaDpdoController extends BaseController
{
    private String prefix = "pg/dpdo";

    @Autowired
    private ITaDpdoService taDpdoService;

    @RequiresPermissions("pg:dpdo:view")
    @GetMapping()
    public String dpdo()
    {
        return prefix + "/dpdo";
    }

    /**
     * 查询部门人员对照列表
     */
    @RequiresPermissions("pg:dpdo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaDpdo taDpdo)
    {
        startPage();
        List<TaDpdo> list = taDpdoService.selectTaDpdoList(taDpdo);
        return getDataTable(list);
    }

    /**
     * 导出部门人员对照列表
     */
    @RequiresPermissions("pg:dpdo:export")
    @Log(title = "部门人员对照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaDpdo taDpdo)
    {
        List<TaDpdo> list = taDpdoService.selectTaDpdoList(taDpdo);
        ExcelUtil<TaDpdo> util = new ExcelUtil<TaDpdo>(TaDpdo.class);
        return util.exportExcel(list, "dpdo");
    }

    /**
     * 新增部门人员对照
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存部门人员对照
     */
    @RequiresPermissions("pg:dpdo:add")
    @Log(title = "部门人员对照", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaDpdo taDpdo)
    {
        return toAjax(taDpdoService.insertTaDpdo(taDpdo));
    }

    /**
     * 修改部门人员对照
     */
    @GetMapping("/edit/{dpid}")
    public String edit(@PathVariable("dpid") Long dpid, ModelMap mmap)
    {
        TaDpdo taDpdo = taDpdoService.selectTaDpdoById(dpid);
        mmap.put("taDpdo", taDpdo);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门人员对照
     */
    @RequiresPermissions("pg:dpdo:edit")
    @Log(title = "部门人员对照", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaDpdo taDpdo)
    {
        return toAjax(taDpdoService.updateTaDpdo(taDpdo));
    }

    /**
     * 删除部门人员对照
     */
    @RequiresPermissions("pg:dpdo:remove")
    @Log(title = "部门人员对照", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taDpdoService.deleteTaDpdoByIds(ids));
    }
}
