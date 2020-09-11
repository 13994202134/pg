package com.ruoyi.pg.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.pg.domain.InPara.scheme1.PgInPara;
import com.ruoyi.pg.domain.InPara.scheme2.Details.*;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.*;
import com.ruoyi.pg.domain.TaPgdetail;
import com.ruoyi.pg.service.ITaPgdetailService;
import com.ruoyi.pg.tool.tools;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pg.mapper.TaPgMapper;
import com.ruoyi.pg.domain.TaPg;
import com.ruoyi.pg.service.ITaPgService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;


/**
 * 评估总Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class TaPgServiceImpl implements ITaPgService 
{

    @Autowired
    private TaPgMapper taPgMapper;
    @Autowired
    private ITaPgService taPgService;
    @Autowired
    private ITaPgdetailService taPgdetailService;

    /**
     * 查询评估总
     * 
     * @param pgid 评估总ID
     * @return 评估总
     */
    @Override
    public TaPg selectTaPgById(Long pgid)
    {
        return taPgMapper.selectTaPgById(pgid);
    }

    /**
     * 查询评估总列表
     * 
     * @param taPg 评估总
     * @return 评估总
     */
    @Override
    public List<TaPg> selectTaPgList(TaPg taPg)
    {
        return taPgMapper.selectTaPgList(taPg);
    }

    @Override
    public List<TaPg> selectTaPgByPgbatchid(String pgbatchid) {
        return taPgMapper.selectTaPgByPgbatchid(pgbatchid);
    }

    @Override
    public TotalS selectTotalSByPgbatchid(String pgbatchid) {
        return taPgMapper.selectTotalSByPgbatchid(pgbatchid);
    }

    @Override
    public List<SubtotalS> selectSubtotalSByPgbatchid(String pgbatchid) {
        return taPgMapper.selectSubtotalSByPgbatchid(pgbatchid);
    }

    @Override
    public List<TaPg> selectTaPgAll() {
        return taPgMapper.selectTaPgAll();
    }

    /**
     * 查询评估总列表
     *
     * @param taPg 评估总
     * @return 评估总
     */
    @Override
    public List<TaPg> selectPgByPara(TaPg taPg)
    {
        return taPgMapper.selectPgByPara(taPg);
    }

    /**
     * 新增评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    @Override
    public int insertTaPg(TaPg taPg)
    {
        taPg.setCreateTime(DateUtils.getNowDate());
        return taPgMapper.insertTaPg(taPg);
    }

    @Override
    public int batchInsertTaPg(List<TaPg> taPgList) {
        for(int i=0;i<taPgList.size();i++)
        {
            taPgList.get(i).setCreateTime(DateUtils.getNowDate());
        }

        return taPgMapper.batchInsertPg(taPgList);
    }

    /**
     * 修改评估总
     * 
     * @param taPg 评估总
     * @return 结果
     */
    @Override
    public int updateTaPg(TaPg taPg)
    {
        taPg.setUpdateTime(DateUtils.getNowDate());
        return taPgMapper.updateTaPg(taPg);
    }

    /**
     * 删除评估总对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaPgByIds(String ids)
    {
        return taPgMapper.deleteTaPgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评估总信息
     * 
     * @param pgid 评估总ID
     * @return 结果
     */
    @Override
    public int deleteTaPgById(Long pgid)
    {
        return taPgMapper.deleteTaPgById(pgid);
    }

    @Override
    public int deleteTaPgByBatchId(String pgbatchid) {
        return taPgMapper.deleteTaPgByBatchId(pgbatchid);
    }

    /**
     *批量新增方案一：table合并，目前没有启用
     * @param pgInPara
     * @return
     * @throws ParseException
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
     public int batchInsertAll(PgInPara pgInPara) throws ParseException {
        //参数中的信息对接pg主表和pgdetail
        TaPg taPg = new TaPg();
        taPg.setPgbatchid(pgInPara.getPgbatchid());
        taPg.setPgclass(pgInPara.getPgclass());
        taPg.setDid(pgInPara.getDid());
        taPg.setPatid(pgInPara.getPatid());
        //total
        taPg.setCount(pgInPara.getTotal().getCount());
        taPg.setGrade(pgInPara.getTotal().getGrade());

        int totalResult =  taPgService.insertTaPg(taPg);
        System.out.println("插入汇总------");
        //subtotal
        List<TaPg> taPgList =  new ArrayList<>();
        int  subSize = pgInPara.getSubtotal().size();
        for(int i=0;i<subSize;i++) {
            TaPg taPgsub = new TaPg();
            taPgsub.setPgbatchid(pgInPara.getPgbatchid());
            taPgsub.setPgclass(pgInPara.getPgclass());
            taPgsub.setDid(pgInPara.getDid());
            taPgsub.setPatid(pgInPara.getPatid());
            taPgsub.setPgtable(pgInPara.getSubtotal().get(i).getPgtable());
            taPgsub.setPgresult(pgInPara.getSubtotal().get(i).getPgResult());
            taPgList.add(taPgsub);
        }
        int subtotalResult = batchInsertTaPg(taPgList);
        System.out.println("批量插入小计---------");
        //detail

        List<TaPgdetail> taPgdetailList =new ArrayList<>();
       int detailSize = pgInPara.getDetail().size();
        System.out.println("获取到的详细======="+pgInPara.getDetail());
        for(int j=0;j<detailSize;j++)
        {
            TaPgdetail taPgDetail = new TaPgdetail();
            //taPgDetail.setPgbatchid(pgInPara.getPgbatchid());
            taPgDetail.setPgtable(pgInPara.getDetail().get(j).getPgtable());
            taPgDetail.setPgname(pgInPara.getDetail().get(j).getPgName());
            taPgDetail.setAcscore(pgInPara.getDetail().get(j).getAsScore());
            taPgDetail.setIssel(pgInPara.getDetail().get(j).getIsSel());
            taPgdetailList.add(taPgDetail);
        }
        System.out.println("赋值后的详细======="+taPgdetailList);
        int detailResult = taPgdetailService.batchInsertTaPgdetail(taPgdetailList);
        System.out.println("批量插入评估详细-------");
       if(totalResult==0 && subtotalResult==0 && detailResult==0)
       { return 0;}
       else
       {return 1;}
    }

    /**
     * 批量新增方案二：表格各自单独写，目前启用
     * @param pgInPara
     * @param detailRoot
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
    public int batchInsertByJosn(PgInParaS pgInPara, DetailRoot detailRoot) {
        //参数中的信息对接pg主表和pgdetail
        TaPg taPg = new TaPg();
        taPg.setPgbatchid(pgInPara.getPgbatchid());
        taPg.setInhossum(pgInPara.getInhossum());
        taPg.setPathosid(pgInPara.getPathosid());
        taPg.setPgclass(pgInPara.getPgclass());
        taPg.setDid(pgInPara.getDid());
        taPg.setPatid(pgInPara.getPatid());
        //total
        taPg.setCount(Long.parseLong(pgInPara.getTotal().getCount()));
        taPg.setGrade(pgInPara.getTotal().getGrade());

        int totalResult =  taPgService.insertTaPg(taPg);
        System.out.println("插入汇总------");

        //subtotal
        List<TaPg> taPgList =  new ArrayList<>();
        int  subSize = pgInPara.getSubtotalS().size();
        for(int i=0;i<subSize;i++) {
            TaPg taPgsub = new TaPg();
            taPgsub.setPgbatchid(pgInPara.getPgbatchid());
            taPgsub.setPgclass(pgInPara.getPgclass());
            taPgsub.setDid(pgInPara.getDid());
            taPgsub.setPatid(pgInPara.getPatid());
            taPgsub.setPgtable(pgInPara.getSubtotalS().get(i).getPgtable());
            taPgsub.setPgresult(pgInPara.getSubtotalS().get(i).getPgResult());
            taPgList.add(taPgsub);
        }
        int subtotalResult = batchInsertTaPg(taPgList);
        System.out.println("批量插入小计---------");

        //detail
        List<TaPgdetail> taPgdetailList =new ArrayList<>();
          //table1
        if(detailRoot.getTabel1()!=null)
        {
            List<Tabel1> tabel1List = detailRoot.getTabel1() ;
            for(int i=0;i<tabel1List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(pgInPara.getPgbatchid());
                taPgDetail.setPgtable(tabel1List.get(i).getTablename());
                taPgDetail.setPgname(tabel1List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel1List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel1List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table1赋值后的详细-------"+taPgdetailList);
        }

        //table2
        if(detailRoot.getTable2()!=null) {
            List<Table2> tabel2List = detailRoot.getTable2();
            for (int i = 0; i < tabel2List.size(); i++) {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(pgInPara.getPgbatchid());
                taPgDetail.setPgtable(tabel2List.get(i).getTablename());
                taPgDetail.setPgname(tabel2List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel2List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel2List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table2赋值后的详细-------" + taPgdetailList);
        }
        //table3
        if(detailRoot.getTabel3()!=null)
        {
            List<Tabel3> tabel3List = detailRoot.getTabel3() ;
            for(int i=0;i<tabel3List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(pgInPara.getPgbatchid());
                taPgDetail.setPgtable(tabel3List.get(i).getTablename());
                taPgDetail.setPgname(tabel3List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel3List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel3List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table3赋值后的详细-------"+taPgdetailList);
        }
        //table4
        if(detailRoot.getTable4()!=null)
        {
            List<Tabel4> tabel4List = detailRoot.getTable4() ;
            for(int i=0;i<tabel4List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(pgInPara.getPgbatchid());
                taPgDetail.setPgtable(tabel4List.get(i).getTablename());
                taPgDetail.setPgname(tabel4List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel4List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel4List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table4赋值后的详细-------"+taPgdetailList);
        }
        int detailResult = taPgdetailService.batchInsertTaPgdetail(taPgdetailList);
        System.out.println("批量插入评估详细-------");
        if(totalResult==0 && subtotalResult==0 && detailResult==0)
        { return 0;}
        else
        {return 1;}
    }



    /**
     * 批量新增方案四：表格合并到总的参数中，和total平级，参数是json

     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
    public int batchInsertByJosnAll(String pgInParaStr) {
        //解析传入的字符串，并返回类
        PgInparaSA pgInPara = analysis(pgInParaStr);
        String batchid = tools.getStringTodayTime()+ RandomStringUtils.randomAlphanumeric(5);
        //参数中的信息对接pg主表和pgdetail
        TaPg taPg = new TaPg();
        taPg.setPgbatchid(batchid);

        taPg.setInhossum(pgInPara.getInhossum());
        taPg.setPathosid(pgInPara.getPathosid());
        taPg.setPgclass(pgInPara.getPgclass());
        taPg.setDid(pgInPara.getDid());
        taPg.setPatid(pgInPara.getPatid());

        //total
        if(pgInPara.getTotal().getCount()!=null)
        {taPg.setCount(Long.parseLong(pgInPara.getTotal().getCount()));}

         taPg.setGrade(pgInPara.getTotal().getGrade());

        int totalResult =  taPgService.insertTaPg(taPg);
        System.out.println("插入汇总------");

        //subtotal
        List<TaPg> taPgList =  new ArrayList<>();
        int  subSize = pgInPara.getSubtotalS().size();
        for(int i=0;i<subSize;i++) {
            TaPg taPgsub = new TaPg();
            taPgsub.setPgbatchid(batchid);
            taPgsub.setPgclass(pgInPara.getPgclass());
            taPgsub.setDid(pgInPara.getDid());
            taPgsub.setPatid(pgInPara.getPatid());
            taPgsub.setPgtable(pgInPara.getSubtotalS().get(i).getPgtable());
            taPgsub.setPgresult(pgInPara.getSubtotalS().get(i).getPgResult());
            taPgList.add(taPgsub);
        }
        int subtotalResult = batchInsertTaPg(taPgList);
        System.out.println("批量插入小计---------");

        //detail
        List<TaPgdetail> taPgdetailList =new ArrayList<>();
        //table1
        if(pgInPara.getTabel1()!=null)
        {
            List<Tabel1> tabel1List = pgInPara.getTabel1() ;
            for(int i=0;i<tabel1List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(batchid);
                taPgDetail.setPgtable(tabel1List.get(i).getTablename());
                taPgDetail.setPgname(tabel1List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel1List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel1List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table1赋值后的详细-------"+taPgdetailList);
        }

        //table2
        if(pgInPara.getTable2()!=null) {
            List<Table2> tabel2List = pgInPara.getTable2();
            for (int i = 0; i < tabel2List.size(); i++) {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(batchid);
                taPgDetail.setPgtable(tabel2List.get(i).getTablename());
                taPgDetail.setPgname(tabel2List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel2List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel2List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table2赋值后的详细-------" + taPgdetailList);
        }
        //table3
        if(pgInPara.getTabel3()!=null)
        {
            List<Tabel3> tabel3List = pgInPara.getTabel3() ;
            for(int i=0;i<tabel3List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(batchid);
                taPgDetail.setPgtable(tabel3List.get(i).getTablename());
                taPgDetail.setPgname(tabel3List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel3List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel3List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table3赋值后的详细-------"+taPgdetailList);
        }
        //table4
        if(pgInPara.getTable4()!=null)
        {
            List<Tabel4> tabel4List = pgInPara.getTable4() ;
            for(int i=0;i<tabel4List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(batchid);
                taPgDetail.setPgtable(tabel4List.get(i).getTablename());
                taPgDetail.setPgname(tabel4List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel4List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel4List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table4赋值后的详细-------"+taPgdetailList);
        }
        int detailResult = taPgdetailService.batchInsertTaPgdetail(taPgdetailList);
        System.out.println("批量插入评估详细-------");
        if(totalResult==0 && subtotalResult==0 && detailResult==0)
        { return 0;}
        else
        {return 1;}

    }

    /**
     * 方案5：子表合并
     * @param pgInParaStr
     * @return
     */
    @Override
    public int batchInsertByJosnDetail(String pgInParaStr) {
        //解析传入的字符串，并返回类
        PgInparaSTable pgInparaSTable = analysisD(pgInParaStr);
        //参数中的信息对接pg主表和pgdetail
        TaPg taPg = new TaPg();
        taPg.setPgbatchid(pgInparaSTable.getPgbatchid());

        taPg.setInhossum(pgInparaSTable.getInhossum());
        taPg.setPathosid(pgInparaSTable.getPathosid());
        taPg.setPgclass(pgInparaSTable.getPgclass());
        taPg.setDid(pgInparaSTable.getDid());
        taPg.setPatid(pgInparaSTable.getPatid());

        //total
        if(pgInparaSTable.getTotal().getCount()!=null)
        {taPg.setCount(Long.parseLong(pgInparaSTable.getTotal().getCount()));}

        taPg.setGrade(pgInparaSTable.getTotal().getGrade());

        int totalResult =  taPgService.insertTaPg(taPg);
        System.out.println("插入汇总------");

        //subtotal
        List<TaPg> taPgList =  new ArrayList<>();
        int  subSize = pgInparaSTable.getSubtotalS().size();
        for(int i=0;i<subSize;i++) {
            TaPg taPgsub = new TaPg();
            taPgsub.setPgbatchid(pgInparaSTable.getPgbatchid());
            taPgsub.setPgclass(pgInparaSTable.getPgclass());
            taPgsub.setDid(pgInparaSTable.getDid());
            taPgsub.setPatid(pgInparaSTable.getPatid());
            taPgsub.setPgtable(pgInparaSTable.getSubtotalS().get(i).getPgtable());
            taPgsub.setPgresult(pgInparaSTable.getSubtotalS().get(i).getPgResult());
            taPgList.add(taPgsub);
        }
        int subtotalResult = batchInsertTaPg(taPgList);
        System.out.println("批量插入小计---------");

        //detail
        List<TaPgdetail> taPgdetailList =new ArrayList<>();
        //table1
        if(pgInparaSTable.getDetailTableList()!=null)
        {
            List<DetailTable> tabel1List = pgInparaSTable.getDetailTableList() ;
            for(int i=0;i<tabel1List.size();i++)
            {
                TaPgdetail taPgDetail = new TaPgdetail();
                taPgDetail.setPgbatchid(pgInparaSTable.getPgbatchid());
                taPgDetail.setPgtable(tabel1List.get(i).getTablename());
                taPgDetail.setPgname(tabel1List.get(i).getProjectlist());
                taPgDetail.setAcscore(Long.parseLong(tabel1List.get(i).getAsScore()));
                taPgDetail.setIssel(tabel1List.get(i).getIsSel());
                taPgdetailList.add(taPgDetail);
            }
            System.out.println("table1赋值后的详细-------"+taPgdetailList);
        }


        int detailResult = taPgdetailService.batchInsertTaPgdetail(taPgdetailList);
        System.out.println("批量插入评估详细-------");
        if(totalResult==0 && subtotalResult==0 && detailResult==0)
        { return 0;}
        else
        {return 1;}

    }

    public PgInparaSA analysis(String PgTotalStr)
    {
        //String PgTotalStr = "{\"pgbatchid\":\"批次\",\"inhossum\":\"1\",\"pathosid\":\"111111\",\"pgclass\":\"wai\",\"did\":1,\"patid\":1,\"subtotal\":[{\"pgtable \":\"table1\",\"pgResult\":\"出血高危\"},{\"pgtable \":\"table2\",\"pgResult\":\"出血低危\"}],\"total\":{\"count\":\"100\",\"grade\":\"等级\"},\"table1\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"},{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"}],\"table2\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table2\",\"projectlist\":\"年龄≥85岁\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true\"}]}";
        JSONObject jsonObject = JSON.parseObject(PgTotalStr);

        //root
        PgInparaSA pgInPara = new PgInparaSA();
        pgInPara.setPgbatchid(jsonObject.getString("pgbatchid"));
        pgInPara.setInhossum(jsonObject.getString("inhossum"));
        pgInPara.setPathosid(jsonObject.getString("pathosid"));
        pgInPara.setPgclass(jsonObject.getString("pgclass"));
        pgInPara.setDid(jsonObject.getString("did"));
        pgInPara.setPatid(jsonObject.getString("patid"));

        //total
        TotalS totals = new TotalS();
        String count = jsonObject.getJSONObject("total").getString("count");
        String grade = jsonObject.getJSONObject("total").getString("grade");
        totals.setCount(count);
        totals.setGrade(grade);

        pgInPara.setTotal(totals);
        System.out.println("totals赋值后的pgInPara信息----"+pgInPara);
        //subtotal
        JSONArray jASubtotal = jsonObject.getJSONArray("subtotal");

        System.out.println("jASubtotal--之后"+jASubtotal);

        List<SubtotalS> subtotalList = new ArrayList();
        for(int i=0;i<jASubtotal.size();i++)
        {
            JSONObject subtotal = (JSONObject) jASubtotal.get(i);
            String tablename = subtotal.getString("pgtable");
            String result1 =  subtotal.getString("pgResult");

            SubtotalS subtotal1 = new SubtotalS();
            subtotal1.setPgtable(tablename);
            subtotal1.setPgResult(result1);
            subtotalList.add(subtotal1);
        }
        System.out.println("subtatal的输入信息----"+subtotalList);
        pgInPara.setSubtotalS(subtotalList);

        //table1
        JSONObject jsonDetail = JSON.parseObject(PgTotalStr);
        System.out.println("jsonDetail--之后"+jsonDetail);
        JSONArray jATable1= jsonDetail.getJSONArray("table1");
        System.out.println("jATable1--之后"+jATable1);
        //DetailRoot detailRoot = new DetailRoot();
        List<Tabel1> table1List = new ArrayList();
        if(jsonDetail.containsKey("table1")) {
            for(int i=0;i<jATable1.size();i++)
            {
                JSONObject table1 = (JSONObject) jATable1.get(i);
                String tablename = table1.getString("tablename");
                String projectlist = table1.getString("projectlist");
                String value = table1.getString("value");
                String isSel = table1.getString("isSel");

                Tabel1 tabel1 = new Tabel1();
                tabel1.setTablename(tablename);
                tabel1.setProjectlist(projectlist);
                tabel1.setAsScore(value);
                tabel1.setIsSel(isSel);
                table1List.add(tabel1);
            }
            System.out.println("table1的输入信息----"+table1List);
            pgInPara.setTabel1(table1List);
            System.out.println("detailRootList的输入信息----"+pgInPara);
        }

        //table2
        if(jsonDetail.containsKey("table2")) {
            JSONArray jATable2 = jsonDetail.getJSONArray("table2");
            System.out.println("jATable2--之后" + jATable2);
            List<Table2> table1List2 = new ArrayList();
            for (int j = 0; j < jATable2.size(); j++) {
                JSONObject table2 = (JSONObject) jATable2.get(j);
                String tablename = table2.getString("tablename");
                String projectlist = table2.getString("projectlist");
                String value = table2.getString("value");
                String isSel = table2.getString("isSel");

                Table2 tabel2 = new Table2();
                tabel2.setTablename(tablename);
                tabel2.setProjectlist(projectlist);
                tabel2.setAsScore(value);
                tabel2.setIsSel(isSel);
                table1List2.add(tabel2);
            }
            pgInPara.setTable2(table1List2);
            System.out.println("table2的输入信息----" + table1List2);
            System.out.println("detailRootList的输入信息----" + pgInPara);
        }
        //table3
        if(jsonDetail.containsKey("table3"))
        {
            JSONArray jATable3= jsonDetail.getJSONArray("table3");

            System.out.println("jATable3--之后"+jATable3);
            List<Tabel3> table1List3 = new ArrayList();
            for(int j=0;j<jATable3.size();j++)
            {
                JSONObject table3 = (JSONObject) jATable3.get(j);
                String tablename = table3.getString("tablename");
                String projectlist = table3.getString("projectlist");
                String value = table3.getString("value");
                String isSel = table3.getString("isSel");

                Tabel3 tabel3 = new Tabel3();
                tabel3.setTablename(tablename);
                tabel3.setProjectlist(projectlist);
                tabel3.setAsScore(value);
                tabel3.setIsSel(isSel);
                table1List3.add(tabel3);
            }
            pgInPara.setTabel3(table1List3);
            System.out.println("table2的输入信息----"+table1List3);
            System.out.println("detailRootList的输入信息----"+pgInPara);
        }
        //table4
        if(jsonDetail.containsKey("table4"))
        {
            JSONArray jATable4= jsonDetail.getJSONArray("table4");

            System.out.println("jATable4--之后"+jATable4);
            List<Tabel4> table1List4 = new ArrayList();
            for(int j=0;j<jATable4.size();j++)
            {
                JSONObject table4 = (JSONObject) jATable4.get(j);
                String tablename = table4.getString("tablename");
                String projectlist = table4.getString("projectlist");
                String value = table4.getString("value");
                String isSel = table4.getString("isSel");

                Tabel4 tabel4 = new Tabel4();
                tabel4.setTablename(tablename);
                tabel4.setProjectlist(projectlist);
                tabel4.setAsScore(value);
                tabel4.setIsSel(isSel);
                table1List4.add(tabel4);
            }
            pgInPara.setTable4(table1List4);
            System.out.println("table4的输入信息----"+table1List4);
            System.out.println("detailRootList的输入信息----"+pgInPara);

        }
        return  pgInPara;
    }

    /**
     * 解析简化后table的json
     * @param PgTotalStr
     * @return
     */
    public PgInparaSTable analysisD(String PgTotalStr)
    {
        //String PgTotalStr = "{"pgbatchid":"批次1","inhossum":"1","pathosid":"111111","pgclass":"wai","did":1,"patid":1,"subtotal":[{"pgtable ":"table1","pgResult":"出血高危"},{"pgtable ":"table2","pgResult":"出血低危"}],"total":{"count":"100","grade":"等级"},"detailTable":[{"pgclass":"nei_chuxue","tablename":"table1","projectlist":"活动性消化道溃疡","value":"10","asScore":"10","isSel":"true "},{"pgclass":"nei_chuxue","tablename":"table1","projectlist":"活动性消化道溃疡","value":"10","asScore":"10","isSel":"true "}]}";
        JSONObject jsonObject = JSON.parseObject(PgTotalStr);

        //root
        PgInparaSTable pgInPara = new PgInparaSTable();
        pgInPara.setPgbatchid(jsonObject.getString("pgbatchid"));
        pgInPara.setInhossum(jsonObject.getString("inhossum"));
        pgInPara.setPathosid(jsonObject.getString("pathosid"));
        pgInPara.setPgclass(jsonObject.getString("pgclass"));
        pgInPara.setDid(jsonObject.getString("did"));
        pgInPara.setPatid(jsonObject.getString("patid"));

        //total
        TotalS totals = new TotalS();
        String count = jsonObject.getJSONObject("total").getString("count");
        String grade = jsonObject.getJSONObject("total").getString("grade");
        totals.setCount(count);
        totals.setGrade(grade);

        pgInPara.setTotal(totals);
        System.out.println("totals赋值后的pgInPara信息----"+pgInPara);
        //subtotal
        JSONArray jASubtotal = jsonObject.getJSONArray("subtotal");

        System.out.println("jASubtotal--之后"+jASubtotal);

        List<SubtotalS> subtotalList = new ArrayList();
        for(int i=0;i<jASubtotal.size();i++)
        {
            JSONObject subtotal = (JSONObject) jASubtotal.get(i);
            String tablename = subtotal.getString("pgtable");
            String result1 =  subtotal.getString("pgResult");

            SubtotalS subtotal1 = new SubtotalS();
            subtotal1.setPgtable(tablename);
            subtotal1.setPgResult(result1);
            subtotalList.add(subtotal1);
        }
        System.out.println("subtatal的输入信息----"+subtotalList);
        pgInPara.setSubtotalS(subtotalList);

        //table1
        JSONObject jsonDetail = JSON.parseObject(PgTotalStr);
        System.out.println("jsonDetail--之后"+jsonDetail);
        JSONArray jATable1= jsonDetail.getJSONArray("detailTable");
        System.out.println("jATable1--之后"+jATable1);
        //DetailRoot detailRoot = new DetailRoot();
        List<DetailTable> table1List = new ArrayList();
        if(jsonDetail.containsKey("detailTable")) {
            for(int i=0;i<jATable1.size();i++)
            {
                JSONObject table1 = (JSONObject) jATable1.get(i);
                String tablename = table1.getString("tablename");
                String projectlist = table1.getString("projectlist");
                String value = table1.getString("value");
                String isSel = table1.getString("isSel");

                DetailTable detailTable = new DetailTable();
                detailTable.setTablename(tablename);
                detailTable.setProjectlist(projectlist);
                detailTable.setAsScore(value);
                detailTable.setIsSel(isSel);
                table1List.add(detailTable);
            }
            System.out.println("table1的输入信息----"+table1List);
            pgInPara.setDetailTableList(table1List);
            System.out.println("detailRootList的输入信息----"+pgInPara);
        }


        return  pgInPara;
    }

    /**
     * 批量删除后再批量新增，用于修改，因为单数修改一条，会影响其他

     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
    public int DelIns(String PgTotalStr)
    {
        //修改特定在记录，条件是批次号，删除后新增
        //解析得到批次号
        PgInparaSA pgInparaSA = analysis(PgTotalStr);
        String pgbatchid = pgInparaSA.getPgbatchid();
        System.out.println("查找到批次号"+pgbatchid);

         int delePgResult = deleteTaPgByBatchId(pgbatchid);
         System.out.println("批量删除Pg"+delePgResult);

         int delePgDetailResut = taPgdetailService.deleteTaPgdetailByBatchId(pgbatchid);
         System.out.println("批量删除PgDetail"+delePgDetailResut);

         int insertResult = batchInsertByJosnAll(PgTotalStr);
         System.out.println("批量新增PgDetail"+insertResult);

         if(delePgResult==0 && delePgDetailResut==0 && insertResult==0)
         { return 0;}
         else
         {return 1;}
    }

}
