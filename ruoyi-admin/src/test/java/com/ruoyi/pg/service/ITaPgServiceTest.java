package com.ruoyi.pg.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.RuoYiApplication;
import com.ruoyi.pg.domain.InPara.scheme1.PgInPara;
import com.ruoyi.pg.domain.InPara.scheme1.Detail;
import com.ruoyi.pg.domain.InPara.scheme1.Total;
import com.ruoyi.pg.domain.InPara.scheme1.Subtotal;
import com.ruoyi.pg.domain.InPara.scheme2.Details.*;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInParaS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.PgInparaSA;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.SubtotalS;
import com.ruoyi.pg.domain.InPara.scheme2.PgTotal.TotalS;
import com.ruoyi.pg.domain.TaDoctor;
import com.ruoyi.pg.domain.TaPg;
import com.ruoyi.pg.domain.TaPgdetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public  class ITaPgServiceTest {
  @Autowired
  ITaPgService taPgService;
  @Autowired
  ITaPgdetailService taPgdetailService;
    @Test
  public  void selectPgByPara() {
        TaPg taPg = new TaPg();
        taPg.setPgid(2L);
        System.out.println("輸入參數:"+taPg);
        List<TaPg> result = taPgService.selectPgByPara(taPg);

        for(int i = 0; i < result.size(); i++){
            System.out.println("评估" + i);
            String name = result.get(i).getTaPatInfor().getPatname();
            System.out.println("患者姓名："+name);
            TaDoctor s = result.get(i).getTaDoctor();
            System.out.println("医生姓名:"+s.getDoctorname());
        }
    }



    @Test
    public void insertTaPg() {
        TaPg taPg = new TaPg();
        taPg.setPgbatchid("100");
        taPg.setCount(100L);
        taPg.setDid("152L");


        Integer result =   taPgService.insertTaPg(taPg);
        System.out.println("插入返回值："+ result);
    }


    @Test
   public   void batchInsertTaPg() {
        List<TaPg> taPgList = new ArrayList();
        TaPg taPg = new TaPg();
        taPg.setPgbatchid("100");
        taPg.setCount(100L);
        taPg.setDid("152");
        taPgList.add(taPg);

        TaPg taPg1 = new TaPg();
        taPg1.setPgbatchid("101");
        taPg1.setCount(101L);
        taPg1.setDid("153");
        taPgList.add(taPg1);

        System.out.println(taPgList);
        Integer result =   taPgService.batchInsertTaPg(taPgList);
        System.out.println("批量插入返回值："+ result);
    }
    /**
     * 自己构造一个类测试批量，问题是
     * @return
     */
    @Test
    public void batchInsertAll() throws ParseException{
        //root
        PgInPara pgInPara = new PgInPara();
        pgInPara.setPgbatchid("批次号");
        pgInPara.setPgclass("外科");
        pgInPara.setDid("医生编号");
        pgInPara.setPatid("患者Id");
        pgInPara.setInhossum("患者住院次数");
        pgInPara.setPathosid("患者住院号");


       //subtotal

        List<Subtotal> subtotalList = new ArrayList();

        Subtotal subtotal1 = new Subtotal();
        subtotal1.setPgtable("table1");
        subtotal1.setPgResult("评估情况1");
        subtotalList.add(subtotal1);
        Subtotal subtotal2 = new Subtotal();
        subtotal2.setPgtable("table2");
        subtotal2.setPgResult("评估情况2");
        subtotalList.add(subtotal2);

        System.out.println("subtatal的输入信息----"+subtotalList);
        pgInPara.setSubtotal(subtotalList);

        //total
        Total total = new Total();
        total.setCount(100L);
        total.setGrade("等级");
        System.out.println("total的输入信息----"+total);
        pgInPara.setTotal(total);

        //detail
        List<Detail> detailList = new ArrayList();
        Detail detail = new Detail();
        //detail.setPgtable("table1");
        detail.setAsScore(10L);
        detail.setPgName("评估内容名称");
        detail.setIsSel("Ture");
        detailList.add(detail);

        Detail detail1 = new Detail();
        //detail1.setPgtable("table2");
        detail1.setAsScore(5L);
        detail1.setPgName("评估内容名称2");
        detail1.setIsSel("Ture");
        detailList.add(detail1);
        System.out.println("detail的输入内容----"+detailList);

        pgInPara.setDetail(detailList);
        System.out.println("all的输入内容++++++"+pgInPara);
        Integer result =  taPgService.batchInsertAll(pgInPara);
        System.out.println("批量插入所有的返回值："+ result);
    }



    @Test
    public void batchInsertByJosn() {
        TaPg taPg = new TaPg();
        TaPgdetail taPgdetail = new TaPgdetail();
        //模拟一个json
        String PgTotalStr ="{\"pgbatchid\":\"批次\",\"inhossum\":\"1\",\"pathosid\":\"111111\",\"pgclass\":\"wai\",\"did\":1,\"patid\":1,\"subtotal\":[{\"pgtable \":\"table1\",\"pgResult\":\"出血高危\"},{\"pgtable \":\"table2\",\"pgResult\":\"出血低危\"}],\"total\":{\"count\":\"100\",\"grade\":\"等级\"}}";//解析
        JSONObject jsonObject = JSON.parseObject(PgTotalStr);

        //root
        PgInParaS pgInPara = new PgInParaS();
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
        //JSONArray jASubtotal = jSubtotal.parseArray("subtotal");
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

        //detail
        String DetailsStr ="{\"table1\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"},{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"}],\"table2\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table2\",\"projectlist\":\"年龄≥85岁\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true\"}]}";
        //table1
        JSONObject jsonDetail = JSON.parseObject(DetailsStr);
        System.out.println("jsonDetail--之后"+jsonDetail);
        JSONArray jATable1= jsonDetail.getJSONArray("table1");
        System.out.println("jATable1--之后"+jATable1);
        DetailRoot detailRoot = new DetailRoot();
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
            detailRoot.setTabel1(table1List);
            System.out.println("detailRootList的输入信息----"+detailRoot);
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
            detailRoot.setTable2(table1List2);
            System.out.println("table2的输入信息----" + table1List2);
            System.out.println("detailRootList的输入信息----" + detailRoot);
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
            detailRoot.setTabel3(table1List3);
            System.out.println("table2的输入信息----"+table1List3);
            System.out.println("detailRootList的输入信息----"+detailRoot);
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
            detailRoot.setTable4(table1List4);
            System.out.println("table4的输入信息----"+table1List4);
            System.out.println("detailRootList的输入信息----"+detailRoot);
        }

        //调用


        int result =  taPgService.batchInsertByJosn(pgInPara,detailRoot);
        System.out.println("批量插入所有的返回值："+ result);

    }

    @Test
    public void batchInsertByJosnAll() {

        //模拟一个json
        String PgTotalStr = "{\"pgbatchid\":\"批次\",\"inhossum\":\"1\",\"pathosid\":\"111111\",\"pgclass\":\"wai\",\"did\":1,\"patid\":1,\"subtotal\":[{\"pgtable \":\"table1\",\"pgResult\":\"出血高危\"},{\"pgtable \":\"table2\",\"pgResult\":\"出血低危\"}],\"total\":{\"count\":\"100\",\"grade\":\"等级\"},\"table1\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"},{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"}],\"table2\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table2\",\"projectlist\":\"年龄≥85岁\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true\"}]}";

        int result =  taPgService.batchInsertByJosnAll(PgTotalStr);
        System.out.println("批量插入所有的返回值："+ result);

    }


    @Test
    public void delIns() {
        String PgTotalStr =  "{\"pgbatchid\":\"批次\",\"inhossum\":\"1\",\"pathosid\":\"111111\",\"pgclass\":\"wai\",\"did\":1,\"patid\":1,\"subtotal\":[{\"pgtable \":\"table1\",\"pgResult\":\"出血高危\"},{\"pgtable \":\"table2\",\"pgResult\":\"出血低危\"}],\"total\":{\"count\":\"100\",\"grade\":\"等级\"},\"table1\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"},{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table1\",\"projectlist\":\"活动性消化道溃疡\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true \"}],\"table2\":[{\"pgclass\":\"nei_chuxue\",\"tablename\":\"table2\",\"projectlist\":\"年龄≥85岁\",\"value\":\"10\",\"asScore\":\"10\",\"isSel\":\"true\"}]}";
        String pgbatchid = "批次一";
        int result = taPgService.DelIns(PgTotalStr,pgbatchid);
        System.out.println("先删除，再批量插入所有的返回值："+ result);
    }

    @Test
    public void selectTotalSByPgbatchid() {
        String pgbatchid = "222";
        TotalS totalS = taPgService.selectTotalSByPgbatchid(pgbatchid);
        System.out.println("根据批次抽取汇总"+totalS);

    }

    @Test
    public void selectSubtotalSByPgbatchid() {
        String pgbatchid = "批次2";
        List<SubtotalS> subtotalSList = taPgService.selectSubtotalSByPgbatchid(pgbatchid);
        System.out.println("根据批次抽取小计"+subtotalSList);
    }
}