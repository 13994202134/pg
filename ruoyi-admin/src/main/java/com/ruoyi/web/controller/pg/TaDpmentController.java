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
import com.ruoyi.pg.domain.TaDpment;
import com.ruoyi.pg.service.ITaDpmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/dpment")
public class TaDpmentController extends BaseController
{
    private String prefix = "pg/dpment";

    @Autowired
    private ITaDpmentService taDpmentService;

    @RequiresPermissions("pg:dpment:view")
    @GetMapping()
    public String dpment()
    {
        return prefix + "/dpment";
    }

    /**
     * 查询部门列表
     */
    @RequiresPermissions("pg:dpment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaDpment taDpment)
    {
        startPage();
        List<TaDpment> list = taDpmentService.selectTaDpmentList(taDpment);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @RequiresPermissions("pg:dpment:export")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaDpment taDpment)
    {
        List<TaDpment> list = taDpmentService.selectTaDpmentList(taDpment);
        ExcelUtil<TaDpment> util = new ExcelUtil<TaDpment>(TaDpment.class);
        return util.exportExcel(list, "dpment");
    }

    /**
     * 新增部门
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @RequiresPermissions("pg:dpment:add")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaDpment taDpment)
    {
        return toAjax(taDpmentService.insertTaDpment(taDpment));
    }

    /**
     * 修改部门
     */
    @GetMapping("/edit/{dpid}")
    public String edit(@PathVariable("dpid") Long dpid, ModelMap mmap)
    {
        TaDpment taDpment = taDpmentService.selectTaDpmentById(dpid);
        mmap.put("taDpment", taDpment);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门
     */
    @RequiresPermissions("pg:dpment:edit")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaDpment taDpment)
    {
        return toAjax(taDpmentService.updateTaDpment(taDpment));
    }

    /**
     * 删除部门
     */
    @RequiresPermissions("pg:dpment:remove")
    @Log(title = "部门", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taDpmentService.deleteTaDpmentByIds(ids));
    }
}
