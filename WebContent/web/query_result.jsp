<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ProjectInfo"%>
<%@ page import="utils.Utils" %>
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
<title>四川广电网络工程管理系统-查询结果</title>
<script type="text/javascript">
$(document).ready(function() {
    $('#result').dataTable({
        "sScrollX": "850%",
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
        <div style="width: 90%; min-width: 800px">
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
                        <th>甲供材料费用(元)</th>
                        <th>甲供材料清单</th>
                        <th>乙供材料费用(元)</th>
                        <th>乙供材料清单</th>
                        <th>人工费(元)</th>
                        <th>人工费清单</th>
                        <th>协调费(元)</th>
                        <th>合计(元)</th>
                        <th>材料使用第几季度入围材料</th>
                        <th>施工方式</th>
                        <th>OA立项通过时间</th>
                        <th>纸质立项通过时间</th>
                        <th>工程派工时间</th>
                        <th>重大项目提交审计备案时间</th>
                        <th>合同编号</th>
                        <th>合同金额(元)</th>
                        <th>第一次付款金额(元)</th>
                        <th>第二次付款金额(元)</th>
                        <th>进场时间</th>
                        <th>进场材料是否与预期一致</th>
                        <th>项目负责人</th>
                        <th>施工单位</th>
                        <th>本月工程进度(%)</th>
                        <th>上月已报工程进度(%)</th>
                        <th>户数</th>
                        <th>干线长度</th>
                        <th>改造方式</th>
                        <th>施工阶段</th>
                        <th>隐蔽工程</th>
                        <th>附挂、穿管</th>
                        <th>变更单编号</th>
                        <th>变更金额(增加或减少)</th>
                        <th>建设情况详细说明（问题处理的时间与结果）</th>
                        <th>完工时间</th>
                        <th>提交竣工资料时间</th>
                        <th>验收是否通过(验收几次合格)</th>
                        <th>实际安装户数</th>
                        <th>资产是否转移</th>
                        <th>资产是否上GIS系统</th>
                        <th>竣工文件编号(签字、盖章手续已经完毕)</th>
                        <th>资料是否转移</th>
                        <th>重大项目结算资料提交审计时间</th>
                        <th>决算金额(元)</th>
                        <th>重大项目审计报告金额(元)</th>
                        <th>按决算应付施工方金额(元)</th>
                        <th>按决算应付施客商方金额(元)</th>
                        <th>欠付金额(元)</th>
                        <th>第三次付款金额(元)</th>
                        <th>质保金金额(元)</th>
                        <th>质保到期时间</th>
                        <th>下月预计付款金额(元)</th>
                        <th>光节点(个)</th>
                        <th>电缆(米)</th>
                        <th class="rightside">施工负责人</th>
                    </tr>
                </thead>
                <tbody>
<%
for (ProjectInfo info : projectlist) {
    DecimalFormat formatter = new DecimalFormat("##0.00");
    out.print("<tr align=\"center\">");
    if (info.getNumber() == 0) {
        out.print("<td></td>");
    } else {
        out.print("<td>" + info.getNumber() + "</td>");
    }
    out.print("<td>" + info.getItemSourceGroup() + "</td>");
    out.print("<td>" + Utils.DATE_FORMAT.format(info.getItemDate()) + "</td>");
    out.print("<td>" + info.getItemName() + "</td>");
    out.print("<td>" + info.getProName() + "</td>");
    out.print("<td>" + info.getProPropertyGroup() + "</td>");
    out.print("<td>" + info.getProTypeGroup() + "</td>");
    out.print("<td>" + info.getProAddress() + "</td>");
    out.print("<td>" + info.getProName() + "</td>");
    out.print("<td>" + formatter.format(info.getA_MaterialCST()) + "</td>");
    out.print("<td>" + info.getA_MaterialBill() + "</td>");
    out.print("<td>" + formatter.format(info.getB_MaterialCST()) + "</td>");
    out.print("<td>" + info.getB_MaterialBill() + "</td>");
    out.print("<td>" + formatter.format(info.getLaborCost()) + "</td>");
    out.print("<td>" + info.getLaborCstBill() + "</td>");
    out.print("<td>" + formatter.format(info.getCoordinationFee()) + "</td>");
    out.print("<td>" + formatter.format(info.getTotalFee()) + "</td>");
    out.print("<td>" + info.getMaterialQua() + "</td>");
    out.print("<td>" + info.getConsMethodGroup() + "</td>");
    out.print("<td>" + info.getProOADate() + "</td>");
    out.print("<td>" + info.getDispatchDate() + "</td>");
    out.print("<td>" + info.getAuditRecordDate() + "</td>");
    out.print("<td>" + info.getContractNumber() + "</td>");
    out.print("<td>" + info.getMaterialQua() + "</td>");
    out.print("<td>" + formatter.format(info.getContractAccount()) + "</td>");
    out.print("<td>" + info.getFirstPaymentAmount() + "</td>");
    out.print("<td>" + info.getSecondPaymentAmount() + "</td>");
    out.print("<td>" + info.getApproachTime() + "</td>");
    out.print("<td>" + info.getApproachExpectMaterial() + "</td>");
    out.print("<td>" + info.getProLeader() + "</td>");
    out.print("<td>" + info.getConstructionUnit() + "</td>");
    out.print("<td>" + info.getMonthProgress() + "</td>");
    out.print("<td>" + info.getLastMonthProgress() + "</td>");
    out.print("<td>" + info.getHouseHolds() + "</td>");
    out.print("<td>" + info.getRouteLength() + "</td>");
    out.print("<td>" + info.getReformWay() + "</td>");
    out.print("<td>" + info.getConsStageGroup() + "</td>");
    out.print("<td>" + info.getConcealedWork() + "</td>");
    out.print("<td>" + info.getHookingOrTube() + "</td>");
    out.print("<td>" + info.getOrderChangeNo() + "</td>");
    out.print("<td>" + info.getOrderChangeAccount() + "</td>");
    out.print("<td>" + info.getConstruction() + "</td>");
    out.print("<td>" + info.getCompletedDate() + "</td>");
    out.print("<td>" + info.getSubmitCompletionData() + "</td>");
    out.print("<td>" + info.getAcceptance() + "</td>");
    out.print("<td>" + info.getActualInstall() + "</td>");
    out.print("<td>" + info.getAssetsTransfer() + "</td>");
    out.print("<td>" + info.getAssetsGIS() + "</td>");
    out.print("<td>" + info.getCompletionDocNo() + "</td>");
    out.print("<td>" + info.getDataTransfer() + "</td>");
    out.print("<td>" + info.getImportantDataSubmit() + "</td>");
    out.print("<td>" + info.getSettlementAmount() + "</td>");
    out.print("<td>" + info.getImportantProAmount() + "</td>");
    out.print("<td>" + info.getSettlementPayable() + "</td>");
    out.print("<td>" + info.getSettlementPayMerchants() + "</td>");
    out.print("<td>" + info.getOwedAmount() + "</td>");
    out.print("<td>" + info.getThirdPaymentAmount() + "</td>");
    out.print("<td>" + info.getRetentionAmount() + "</td>");
    out.print("<td>" + info.getRetentionExpires() + "</td>");
    out.print("<td>" + info.getNextMonthPayAmount() + "</td>");
    out.print("<td>" + info.getOpticalNode() + "</td>");
    out.print("<td>" + info.getCable() + "</td>");
    out.print("<td class=\"rightside\">" + info.getChargeConstruction() + "</td>");
    out.print("</tr>");
}
%>
                </tbody>
            </table>
        </div>
    </center>

</body>
</html>