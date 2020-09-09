package com.ruoyi.web.controller.pg;

import java.util.List;

import com.ruoyi.pg.domain.view.TaPgtableForView;
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
import com.ruoyi.pg.domain.TaPgtable;
import com.ruoyi.pg.service.ITaPgtableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评估项Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/pgtable")
public class TaPgtableController extends BaseController
{
    private String prefix = "pg/pgtable";

    @Autowired
    private ITaPgtableService taPgtableService;


    @GetMapping()
    public String pgtable()
    {
        return prefix + "/pgtable";
    }

    /**
     * 查询评估项列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaPgtable taPgtable)
    {
        startPage();
        List<TaPgtable> list = taPgtableService.selectTaPgtableList(taPgtable);
        return getDataTable(list);
    }

    /**
     * 给前端提供的数据
     * @param tablename 评估表
     * @param pgclass 评估类别
     * @return
     */
    @GetMapping("/ListByPara")
    @ResponseBody
    public List<TaPgtable> ListByPara(String tablename, String pgclass)
    {
        TaPgtable taPgtable=new TaPgtable();
        taPgtable.setTablename(tablename);
        taPgtable.setPgclass(pgclass);
        List<TaPgtable> list = taPgtableService.selectTaPgtableSmallList(taPgtable);
        System.out.println("contorller评估表信息："+ list);
        return list;
    }

    /**
     * 导出评估项列表
     */
    @RequiresPermissions("pg:pgtable:export")
    @Log(title = "评估项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaPgtable taPgtable)
    {
        List<TaPgtable> list = taPgtableService.selectTaPgtableList(taPgtable);
        ExcelUtil<TaPgtable> util = new ExcelUtil<TaPgtable>(TaPgtable.class);
        return util.exportExcel(list, "pgtable");
    }

    /**
     * 新增评估项
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评估项
     */
    @RequiresPermissions("pg:pgtable:add")
    @Log(title = "评估项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaPgtable taPgtable)
    {
        return toAjax(taPgtableService.insertTaPgtable(taPgtable));
    }

    /**
     * 修改评估项
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TaPgtable taPgtable = taPgtableService.selectTaPgtableById(id);
        mmap.put("taPgtable", taPgtable);
        return prefix + "/edit";
    }

    /**
     * 修改保存评估项
     */
    @RequiresPermissions("pg:pgtable:edit")
    @Log(title = "评估项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaPgtable taPgtable)
    {
        return toAjax(taPgtableService.updateTaPgtable(taPgtable));
    }

    /**
     * 删除评估项
     */
    @RequiresPermissions("pg:pgtable:remove")
    @Log(title = "评估项", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taPgtableService.deleteTaPgtableByIds(ids));
    }
}
