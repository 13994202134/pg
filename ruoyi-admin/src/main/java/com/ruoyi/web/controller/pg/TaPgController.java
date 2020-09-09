package com.ruoyi.web.controller.pg;

import java.util.List;

import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.pg.domain.InPara.scheme2.Details.DetailRoot;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInParaS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInparaSA;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.SubtotalS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.TotalS;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.pg.domain.TaPg;
import com.ruoyi.pg.service.ITaPgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评估总Controller
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Controller
@RequestMapping("/pg/pg")
@CrossOrigin
public class TaPgController extends BaseController
{
    private String prefix = "pg/pg";

    @Autowired
    private ITaPgService taPgService;




    @GetMapping()
    public String pg()
    {
        return prefix + "/pg";
    }

    /**
     * 查询评估总列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaPg taPg)
    {
        startPage();
        List<TaPg> list = taPgService.selectPgByPara(taPg);
        return getDataTable(list);
    }
    /**
     * 查询评估详细
     */
    @GetMapping("/detail/{pgbatchid}")
    public String detail(@PathVariable("pgbatchid") String pgbatchid, ModelMap mmap)
    {
        mmap.put("pgDetail", taPgService.selectTaPgByPgbatchid(pgbatchid));
        mmap.put("pgDetailList", taPgService.selectTaPgAll());
        return "pg/pgdetail/pgdetail";
    }

    /**
     * 查询汇总评估
     * @param pgbatchid 批次号
     * @return
     */
    @GetMapping("/total")
    @ResponseBody
    public TotalS total(String pgbatchid)
    {
        TotalS totalS = taPgService.selectTotalSByPgbatchid(pgbatchid);
        return   totalS;
    }

    /**
     * 查询小计
     * @param pgbatchid 批次号
     * @return
     */
    @GetMapping("/subTotal")
    @ResponseBody
    public List<SubtotalS> subtotal(String pgbatchid)
    {
        List<SubtotalS> subtotalList = taPgService.selectSubtotalSByPgbatchid(pgbatchid);
        return   subtotalList;
    }

    /**
     * 导出评估总列表
     */
    @RequiresPermissions("pg:pg:export")
    @Log(title = "评估总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaPg taPg)
    {
        List<TaPg> list = taPgService.selectTaPgList(taPg);
        ExcelUtil<TaPg> util = new ExcelUtil<TaPg>(TaPg.class);
        return util.exportExcel(list, "pg");
    }

    /**
     * 新增评估总
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评估总
     */
    @Log(title = "评估总", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaPg taPg)
    {
        return toAjax(taPgService.insertTaPg(taPg));
    }


    @PostMapping("/batchAdd")
    @ResponseBody
    public AjaxResult batchInsertByJosn(@RequestBody String pgInPara)
    {
        System.out.println("接收到参数"+pgInPara);
        return toAjax(taPgService.batchInsertByJosnAll(pgInPara));

    }

    /**
     * 修改评估总
     */
    @GetMapping("/edit/{pgid}")
    public String edit(@PathVariable("pgid") Long pgid, ModelMap mmap)
    {
        TaPg taPg = taPgService.selectTaPgById(pgid);
        mmap.put("taPg", taPg);
        return prefix + "/edit";
    }

    /**
     * 修改保存评估总
     */
    @RequiresPermissions("pg:pg:edit")
    @Log(title = "评估总", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaPg taPg)
    {
        return toAjax(taPgService.updateTaPg(taPg));
    }

    /**
     * 修改评估详细信息后先删除原有的信息，再保存
     * @param PgTotalStr 提交的评估信息json
     * @param pgbatchid 批次号
     * @return
     */
    @Log(title = "评估总表和详细比奥删除后批量新增", businessType = BusinessType.DELETE)
    @PostMapping( "/DelIns")
    @ResponseBody
    public AjaxResult DelIns(@RequestBody String PgTotalStr,String pgbatchid)
    {
        return  toAjax(taPgService.DelIns(PgTotalStr,pgbatchid));
    }

    /**
     * 删除评估总
     */
    @RequiresPermissions("pg:pg:remove")
    @Log(title = "评估总", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taPgService.deleteTaPgByIds(ids));
    }
}
