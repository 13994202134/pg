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
import com.ruoyi.pg.domain.TaDoctor;
import com.ruoyi.pg.service.ITaDoctorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/doctor")
public class TaDoctorController extends BaseController
{
    private String prefix = "pg/doctor";

    @Autowired
    private ITaDoctorService taDoctorService;

    @RequiresPermissions("pg:doctor:view")
    @GetMapping()
    public String doctor()
    {
        return prefix + "/doctor";
    }

    /**
     * 查询人员列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaDoctor taDoctor)
    {
        startPage();
        List<TaDoctor> list = taDoctorService.selectTaDoctorList(taDoctor);
        return getDataTable(list);
    }
    /**
     * 查询人员列表
     */
    @GetMapping("/listByDid")
    @ResponseBody
    public TableDataInfo listByDid(int did)
    {
        TaDoctor taDoctor = new TaDoctor();
        taDoctor.setDid(did);
        List<TaDoctor> list = taDoctorService.selectTaDoctorList(taDoctor);
        return getDataTable(list);
    }

    /**
     * 导出人员列表
     */
    @RequiresPermissions("pg:doctor:export")
    @Log(title = "人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaDoctor taDoctor)
    {
        List<TaDoctor> list = taDoctorService.selectTaDoctorList(taDoctor);
        ExcelUtil<TaDoctor> util = new ExcelUtil<TaDoctor>(TaDoctor.class);
        return util.exportExcel(list, "doctor");
    }

    /**
     * 新增人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员
     */
    @RequiresPermissions("pg:doctor:add")
    @Log(title = "人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaDoctor taDoctor)
    {
        return toAjax(taDoctorService.insertTaDoctor(taDoctor));
    }

    /**
     * 修改人员
     */
    @GetMapping("/edit/{did}")
    public String edit(@PathVariable("did") Long did, ModelMap mmap)
    {
        TaDoctor taDoctor = taDoctorService.selectTaDoctorById(did);
        mmap.put("taDoctor", taDoctor);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员
     */
    @RequiresPermissions("pg:doctor:edit")
    @Log(title = "人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaDoctor taDoctor)
    {
        return toAjax(taDoctorService.updateTaDoctor(taDoctor));
    }

    /**
     * 删除人员
     */
    @RequiresPermissions("pg:doctor:remove")
    @Log(title = "人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taDoctorService.deleteTaDoctorByIds(ids));
    }
}
