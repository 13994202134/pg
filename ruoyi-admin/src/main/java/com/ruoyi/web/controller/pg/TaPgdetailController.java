package com.ruoyi.web.controller.pg;

import java.util.List;

import com.ruoyi.pg.domain.TaPgdetail;
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
import com.ruoyi.pg.service.ITaPgdetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评估明细Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/pgdetail")
public class TaPgdetailController extends BaseController
{
    private String prefix = "pg/pgdetail";

    @Autowired
    private ITaPgdetailService taPgdetailService;


    @GetMapping()
    public String pgdetail()
    {
        return prefix + "/pgdetail";
    }

    /**
     * 查询评估明细列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaPgdetail taPgdetail)
    {
        startPage();
        List<TaPgdetail> list = taPgdetailService.selectTaPgdetailList(taPgdetail);
        return getDataTable(list);
    }
    @GetMapping("/listByBatchid")
    @ResponseBody
    public TableDataInfo listByBatchid(String pgbatchid,String pgtable)
    {
        TaPgdetail taPgdetail = new TaPgdetail();
        taPgdetail.setPgbatchid(pgbatchid);
        taPgdetail.setPgname(pgtable);
        startPage();
        List<TaPgdetail> list = taPgdetailService.selectTaPgdetailByBatchid(taPgdetail);
        return getDataTable(list);
    }
    /**
     * 导出评估明细列表
     */
    @RequiresPermissions("pg:pgdetail:export")
    @Log(title = "评估明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaPgdetail taPgdetail)
    {
        List<TaPgdetail> list = taPgdetailService.selectTaPgdetailList(taPgdetail);
        ExcelUtil<TaPgdetail> util = new ExcelUtil<TaPgdetail>(TaPgdetail.class);
        return util.exportExcel(list, "pgdetail");
    }

    /**
     * 新增评估明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评估明细
     */
    @RequiresPermissions("pg:pgdetail:add")
    @Log(title = "评估明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaPgdetail taPgdetail)
    {
        return toAjax(taPgdetailService.insertTaPgdetail(taPgdetail));
    }

    /**
     * 修改评估明细
     */
    @GetMapping("/edit/{detailid}")
    public String edit(@PathVariable("detailid") Long detailid, ModelMap mmap)
    {
        TaPgdetail taPgdetail = taPgdetailService.selectTaPgdetailById(detailid);
        mmap.put("taPgdetail", taPgdetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存评估明细
     */
    @RequiresPermissions("pg:pgdetail:edit")
    @Log(title = "评估明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaPgdetail taPgdetail)
    {
        return toAjax(taPgdetailService.updateTaPgdetail(taPgdetail));
    }

    /**
     * 删除评估明细
     */
    @RequiresPermissions("pg:pgdetail:remove")
    @Log(title = "评估明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taPgdetailService.deleteTaPgdetailByIds(ids));
    }
}
