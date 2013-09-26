<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ProjectInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css" title="currentStyle">
        @import "<%=request.getContextPath()%>/datatables/media/css/demo_page.css";
        @import "<%=request.getContextPath()%>/datatables/media/css/demo_table.css";
        @import "<%=request.getContextPath()%>/datatables/media/css/demo_table_jui.css";
</style>
<script type="text/javascript"
    src="<%=request.getContextPath()%>/datatables/media/js/jquery.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath()%>/datatables/media/js/jquery.dataTables.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电工程管理系统-查询结果</title>
<script type="text/javascript">
$(document).ready(function() {
    $('#result').dataTable({
        "sScrollX": "820%",
        "bAutoWidth": false,
        "bScrollCollapse": true,
        "bProcessing": true,
        "oLanguage": {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "oPaginate": {  
                    "sFirst": "首页",  
                    "sPrevious": "前一页",
                    "sNext": "后一页",  
                    "sLast": "尾页"  
                }, 
            "sSearch": "搜索",
            "sZeroRecords": "没有检索到数据",  
            "sProcessing": "<img src='./loading.gif' />"
        },
        "fnInitComplete": function() {
            $('#result').show();
        }
    });
} );
</script>
</head>
<body>
    <center>
        <div style="width: 800px">
            <%@include file="page_title.jsp"%>
            <h2>项目详细清单</h2>
<%
ArrayList<ProjectInfo> projectlist = null;
Object obj = request.getAttribute("projectlist");
if (obj == null) {
    response.sendRedirect("main.jsp");
    return;
}
if (obj instanceof ArrayList<?>) {
    try {
        projectlist = (ArrayList<ProjectInfo>)obj;
    } catch(ClassCastException ex) {
        response.sendRedirect("main.jsp");
        return;
    }
} else {
    response.sendRedirect("main.jsp");
    return;
}
if(projectlist == null) {
    response.sendRedirect("main.jsp");
    return;
}
int projectCount = projectlist.size();
double time = (Long)request.getAttribute("time")/1000.0;
%>
        </div>
        <div style="width:90%; min-width: 800px; padding-bottom: 50px" id="dt_example">
        <div align="left">
共找到满足条件的记录<%=projectCount%>条，共耗时<%=time%>秒
        </div>
            <table id="result" align="left" class="display">
                <thead>
                    <tr align="center">
                        <th>序号</th>
                        <th>项目来源</th>
                        <th>来单时间</th>
                        <th>来单名称</th>
                        <th>项目编号</th>
                        <th>项目名称</th>
                        <th>项目性质</th>
                        <th>项目类别</th>
                        <th>项目地址</th>
                        <th>甲供材料费用</th>
                        <th>甲供材料清单</th>
                        <th>乙供材料费用</th>
                        <th>乙供材料清单</th>
                        <th>人工费</th>
                        <th>人工费清单</th>
                        <th>协调费</th>
                        <th>合计</th>
                        <th>材料使用第几季度入围材料</th>
                        <th>施工方式</th>
                        <th>OA立项通过时间</th>
                        <th>纸质立项通过时间</th>
                        <th>工程派工时间</th>
                        <th>重大项目提交审计备案时间</th>
                        <th>合同编号</th>
                        <th>合同金额</th>
                        <th>第一次付款金额</th>
                        <th>第二次付款金额</th>
                        <th>进场时间</th>
                        <th>进场材料是否与预期一致</th>
                        <th>项目负责人</th>
                        <th>施工单位</th>
                        <th>本月工程进度</th>
                        <th>上月已报工程进度</th>
                        <th>户数</th>
                        <th>干线长度</th>
                        <th>改造方式</th>
                        <th>施工阶段</th>
                        <th>隐蔽工程</th>
                        <th>附挂、穿管</th>
                        <th>变更单编号</th>
                        <th>变更金额</th>
                        <th>建设情况详细说明（问题处理的时间与结果）</th>
                        <th>完工时间</th>
                        <th>提交竣工资料时间</th>
                        <th>验收是否通过</th>
                        <th>实际安装户数</th>
                        <th>资产是否转移</th>
                        <th>资产是否上GIS系统</th>
                        <th>竣工文件编号</th>
                        <th>资料是否转移</th>
                        <th>重大项目结算资料提交审计时间</th>
                        <th>决算金额</th>
                        <th>重大项目审计报告金额</th>
                        <th>按决算应付施工方金额</th>
                        <th>按决算应付施客商方金额</th>
                        <th>欠付金额</th>
                        <th>第三次付款金额</th>
                        <th>质保金金额</th>
                        <th>质保到期时间</th>
                        <th>下月预计付款金额</th>
                        <th>光节点</th>
                        <th>电缆</th>
                        <th class="rightside">施工负责人</th>
                    </tr>
                </thead>
                <tbody>
<s:iterator value="#request.projectlist" id="list">
                    <tr align="center">
                    <s:if test="#list.number == 0">
                        <td></td>
                    </s:if>
                    <s:else>
                        <td><s:property value="#list.number"/></td>
                    </s:else>
                        <td><s:property value="#list.itemSourceGroup"/></td>
                        <td><s:date name="#list.itemDate" format="yyyy.M.d"/></td>
                        <td><s:property value="#list.itemName"/></td>
                        <td><s:property value="#list.proNumber"/></td>
                        <td><s:property value="#list.proName"/></td>
                        <td><s:property value="#list.proPropertyGroup"/></td>
                        <td><s:property value="#list.proTypeGroup"/></td>
                        <td><s:property value="#list.proAddress"/></td>
                        <td><s:property value="#list.A_MaterialCST"/></td>
                        <td><s:property value="#list.A_MaterialBill"/></td>
                        <td><s:property value="#list.B_MaterialCST"/></td>
                        <td><s:property value="#list.B_MaterialBill"/></td>
                        <td><s:property value="#list.laborCost"/></td>
                        <td><s:property value="#list.laborCstBill"/></td>
                        <td><s:property value="#list.coordinationFee"/></td>
                        <td><s:property value="#list.totalFee"/></td>
                        <td><s:property value="#list.materialQua"/></td>
                        <td><s:property value="#list.consMethodGroup"/></td>
                        <td><s:property value="#list.proOADate"/></td>
                        <td><s:property value="#list.proPaperDate"/></td>
                        <td><s:property value="#list.dispatchDate"/></td>
                        <td><s:property value="#list.auditRecordDate"/></td>
                        <td><s:property value="#list.contractNumber"/></td>
                        <td><s:property value="#list.contractAccount"/></td>
                        <td><s:property value="#list.firstPaymentAmount"/></td>
                        <td><s:property value="#list.secondPaymentAmount"/></td>
                        <td><s:property value="#list.approachTime"/></td>
                        <td><s:property value="#list.approachExpectMaterial"/></td>
                        <td><s:property value="#list.proLeader"/></td>
                        <td><s:property value="#list.constructionUnit"/></td>
                        <td><s:property value="#list.monthProgress"/></td>
                        <td><s:property value="#list.lastMonthProgress"/></td>
                        <td><s:property value="#list.houseHolds"/></td>
                        <td><s:property value="#list.routeLength"/></td>
                        <td><s:property value="#list.reformWay"/></td>
                        <td><s:property value="#list.consStageGroup"/></td>
                        <td><s:property value="#list.concealedWork"/></td>
                        <td><s:property value="#list.hookingOrTube"/></td>
                        <td><s:property value="#list.orderChangeNo"/></td>
                        <td><s:property value="#list.orderChangeAccount"/></td>
                        <td><s:property value="#list.construction"/></td>
                        <td><s:property value="#list.completedDate"/></td>
                        <td><s:property value="#list.submitCompletionData"/></td>
                        <td><s:property value="#list.acceptance"/></td>
                        <td><s:property value="#list.actualInstall"/></td>
                        <td><s:property value="#list.assetsTransfer"/></td>
                        <td><s:property value="#list.assetsGIS"/></td>
                        <td><s:property value="#list.completionDocNo"/></td>
                        <td><s:property value="#list.dataTransfer"/></td>
                        <td><s:property value="#list.importantDataSubmit"/></td>
                        <td><s:property value="#list.settlementAmount"/></td>
                        <td><s:property value="#list.importantProAmount"/></td>
                        <td><s:property value="#list.settlementPayable"/></td>
                        <td><s:property value="#list.settlementPayMerchants"/></td>
                        <td><s:property value="#list.owedAmount"/></td>
                        <td><s:property value="#list.thirdPaymentAmount"/></td>
                        <td><s:property value="#list.retentionAmount"/></td>
                        <td><s:property value="#list.retentionExpires"/></td>
                        <td><s:property value="#list.nextMonthPayAmount"/></td>
                        <td><s:property value="#list.opticalNode"/></td>
                        <td><s:property value="#list.cable"/></td>
                        <td class="rightside"><s:property value="#list.chargeConstruction"/></td>
                    </tr>
</s:iterator>
                </tbody>
            </table>
        </div>
    </center>

</body>
</html>