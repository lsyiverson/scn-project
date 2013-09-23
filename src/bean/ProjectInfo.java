package bean;

import java.util.Date;

public class ProjectInfo {
    /**
     * 序号
     */
    private int number;
    
    /**
     * 项目来源
     */
    private ItemSourceGroup itemSourceGroup;
    
    /**
     * 来单时间
     */
    private Date itemDate;
    
    /**
     * 来单名称
     */
    private String itemName;
    
    /**
     * 项目编号
     */
    private String proNumber;
    
    /**
     * 项目名称
     */
    private String proName;
    
    /**
     * 项目性质
     */
    private ProPropertyGroup proPropertyGroup;
    
    /**
     * 项目类别
     */
    private ProTypeGroup proTypeGroup;
    
    /**
     * 项目地址
     */
    private String proAddress;
    
    /**
     * 甲供材料费用
     */
    private float A_MaterialCST;
    
    /**
     * 甲供材料清单
     */
    private String A_MaterialBill;
    
    /**
     * 乙供材料费用
     */
    private float B_MaterialCST;
    
    /**
     * 乙供材料清单
     */
    private String B_MaterialBill;
    
    /**
     * 人工费
     */
    private float laborCost;
    
    /**
     * 人工费清单
     */
    private String laborCstBill;
    
    /**
     * 协调费
     */
    private float coordinationFee;
    
    /**
     * 合计
     */
    private float totalFee;
    
    /**
     * 材料使用第几季度入围材料
     */
    private String materialQua;
    
    /**
     * 施工方式
     */
    private ConsMethodGroup consMethodGroup;
    
    /**
     * OA立项通过时间
     */
    private String proOADate;
    
    /**
     * 纸质立项通过时间
     */
    private String proPaperDate;
    
    /**
     * 纸质立项通过时间
     */
    private String dispatchDate;
    
    /**
     * 重大项目提交审计备案时间
     */
    private String auditRecordDate;
    
    /**
     * 合同编号
     */
    private String contractNumber;
    
    /**
     * 合同金额
     */
    private float contractAccount;
    
    /**
     * 第一次付款金额
     */
    private float firstPaymentAmount;
    
    /**
     * 第二次付款金额
     */
    private float secondPaymentAmount;
    
    /**
     * 进场时间
     */
    private String approachTime;
    
    /**
     * 进场材料是否与预期一致
     */
    private String approachExpectMaterial;
    
    /**
     * 项目负责人
     */
    private String proLeader;
    
    /**
     * 施工单位
     */
    private String constructionUnit;
    
    /**
     * 本月工程进度
     */
    private String monthProgress;
    
    /**
     * 上月已报工程进度
     */
    private String lastMonthProgress;
    
    /**
     * 户数
     */
    private int houseHolds;
    
    /**
     * 干线长度
     */
    private int routeLength;
    
    /**
     * 改造方式
     */
    private String reformWay;
    
    /**
     * 施工阶段
     */
    private ConsStageGroup consStageGroup;
    
    /**
     * 隐蔽工程
     */
    private String concealedWork;
    
    /**
     * 附挂、穿管
     */
    private String hookingOrTube;
    
    /**
     * 变更单编号
     */
    private String orderChangeNo;
    
    /**
     * 变更金额
     */
    private String orderChangeAccount;
    
    /**
     * 建设情况详细说明（问题处理的时间与结果）
     */
    private String construction;
    
    /**
     * 完工时间
     */
    private String completedDate;
    
    /**
     * 提交竣工资料时间
     */
    private String submitCompletionData;
    
    /**
     * 验收是否通过
     */
    private String acceptance;
    
    /**
     * 实际安装户数
     */
    private String actualInstall;
    
    /**
     * 资产是否转移
     */
    private String assetsTransfer;
    
    /**
     * 资产是否上GIS系统
     */
    private String assetsGIS;
    
    /**
     * 竣工文件编号
     */
    private String completionDocNo;
    
    /**
     * 资料是否转移
     */
    private String dataTransfer;
    
    /**
     * 重大项目结算资料提交审计时间
     */
    private String importantDataSubmit;
    
    /**
     * 决算金额
     */
    private String settlementAmount;
    
    /**
     * 重大项目审计报告金额
     */
    private String importantProAmount;
    
    /**
     * 按决算应付施工方金额
     */
    private String settlementPayable;
    
    /**
     * 按决算应付施客商方金额
     */
    private String settlementPayMerchants;
    
    /**
     * 欠付金额
     */
    private String owedAmount;
    
    /**
     * 欠付金额
     */
    private String thirdPaymentAmount;
    
    /**
     * 质保金金额
     */
    private String retentionAmount;
    
    /**
     * 质保到期时间
     */
    private String retentionExpires;
    
    /**
     * 下月预计付款金额
     */
    private String nextMonthPayAmount;
    
    /**
     * 光节点
     */
    private String opticalNode;
    
    /**
     * 电缆
     */
    private String cable;
    
    /**
     * 施工负责人
     */
    private String chargeConstruction;
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public ItemSourceGroup getItemSourceGroup() {
        return itemSourceGroup;
    }

    public void setItemSourceGroup(ItemSourceGroup itemSourceGroup) {
        this.itemSourceGroup = itemSourceGroup;
    }
   
    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }
    
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
    
    public ProPropertyGroup getProPropertyGroup() {
        return proPropertyGroup;
    }

    public void setProPropertyGroup(ProPropertyGroup proPropertyGroup) {
        this.proPropertyGroup = proPropertyGroup;
    }
    
    public ProTypeGroup getProTypeGroup() {
        return proTypeGroup;
    }

    public void setProTypeGroup(ProTypeGroup proTypeGroup) {
        this.proTypeGroup = proTypeGroup;
    }
    
    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }
    
    public float getA_MaterialCST() {
        return A_MaterialCST;
    }

    public void setA_MaterialCST(float A_MaterialCST) {
        this.A_MaterialCST = A_MaterialCST;
    }
    
    public String getA_MaterialBill() {
        return A_MaterialBill;
    }

    public void setA_MaterialBill(String A_MaterialBill) {
        this.A_MaterialBill = A_MaterialBill;
    }
    
    public float getB_MaterialCST() {
        return B_MaterialCST;
    }

    public void setB_MaterialCST(float B_MaterialCST) {
        this.B_MaterialCST = B_MaterialCST;
    }
    
    public String getB_MaterialBill() {
        return B_MaterialBill;
    }

    public void setB_MaterialBill(String B_MaterialBill) {
        this.B_MaterialBill = B_MaterialBill;
    }
    
    public float getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(float laborCost) {
        this.laborCost = laborCost;
    }
    
    public String getLaborCstBill() {
        return laborCstBill;
    }

    public void setLaborCstBill(String laborCstBill) {
        this.laborCstBill = laborCstBill;
    }
    
    public float getCoordinationFee() {
        return coordinationFee;
    }

    public void setCoordinationFee(float coordinationFee) {
        this.coordinationFee = coordinationFee;
    }
    
    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }
    
    public String getMaterialQua() {
        return materialQua;
    }

    public void setMaterialQua(String materialQua) {
        this.materialQua = materialQua;
    }
    
    public ConsMethodGroup getConsMethodGroup() {
        return consMethodGroup;
    }

    public void setConsMethodGroup(ConsMethodGroup consMethodGroup) {
        this.consMethodGroup = consMethodGroup;
    }
    
    public String getProOADate() {
        return proOADate;
    }

    public void setProOADate(String proOADate) {
        this.proOADate = proOADate;
    }
    
    public String getProPaperDate() {
        return proPaperDate;
    }

    public void setProPaperDate(String proPaperDate) {
        this.proPaperDate = proPaperDate;
    }
    
    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }
    
    public String getAuditRecordDate() {
        return auditRecordDate;
    }

    public void setAuditRecordDate(String auditRecordDate) {
        this.auditRecordDate = auditRecordDate;
    }
    
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    
    public float getContractAccount() {
        return contractAccount;
    }

    public void setContractAccount(float contractAccount) {
        this.contractAccount = contractAccount;
    }
    
    public float getFirstPaymentAmount() {
        return firstPaymentAmount;
    }

    public void setFirstPaymentAmount(float firstPaymentAmount) {
        this.firstPaymentAmount = firstPaymentAmount;
    }
    
    public float getSecondPaymentAmount() {
        return secondPaymentAmount;
    }

    public void setSecondPaymentAmount(float secondPaymentAmount) {
        this.secondPaymentAmount = secondPaymentAmount;
    }
    
    public String getApproachTime() {
        return approachTime;
    }

    public void setApproachTime(String approachTime) {
        this.approachTime = approachTime;
    }
    
    public String getApproachExpectMaterial() {
        return approachExpectMaterial;
    }

    public void setApproachExpectMaterial(String approachExpectMaterial) {
        this.approachExpectMaterial = approachExpectMaterial;
    }
    
    public String getProLeader() {
        return proLeader;
    }

    public void setProLeader(String proLeader) {
        this.proLeader = proLeader;
    }
    
    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }
    
    public String getMonthProgress() {
        return monthProgress;
    }

    public void setMonthProgress(String monthProgress) {
        this.monthProgress = monthProgress;
    }
    
    public String getLastMonthProgress() {
        return lastMonthProgress;
    }

    public void setLastMonthProgress(String lastMonthProgress) {
        this.lastMonthProgress = lastMonthProgress;
    }
    
    public int getHouseHolds() {
        return houseHolds;
    }

    public void setHouseHolds(int houseHolds) {
        this.houseHolds = houseHolds;
    }
    
    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }
    
    public String getReformWay() {
        return reformWay;
    }

    public void setReformWay(String reformWay) {
        this.reformWay = reformWay;
    }
    
    public ConsStageGroup getConsStageGroup() {
        return consStageGroup;
    }

    public void setConsStageGroup(ConsStageGroup consStageGroup) {
        this.consStageGroup = consStageGroup;
    }
    
    public String getConcealedWork() {
        return concealedWork;
    }

    public void setConcealedWork(String concealedWork) {
        this.concealedWork = concealedWork;
    }
    
    public String getHookingOrTube() {
        return hookingOrTube;
    }

    public void setHookingOrTube(String hookingOrTube) {
        this.hookingOrTube = hookingOrTube;
    }
    
    public String getOrderChangeNo() {
        return orderChangeNo;
    }

    public void setOrderChangeNo(String orderChangeNo) {
        this.orderChangeNo = orderChangeNo;
    }
    
    public String getOrderChangeAccount() {
        return orderChangeAccount;
    }

    public void setOrderChangeAccount(String orderChangeAccount) {
        this.orderChangeAccount = orderChangeAccount;
    }
    
    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }
    
    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }
    
    public String getSubmitCompletionData() {
        return submitCompletionData;
    }

    public void setSubmitCompletionData(String submitCompletionData) {
        this.submitCompletionData = submitCompletionData;
    }
    
    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }
    
    public String getActualInstall() {
        return actualInstall;
    }

    public void setActualInstall(String actualInstall) {
        this.actualInstall = actualInstall;
    }
    
    public String getAssetsTransfer() {
        return assetsTransfer;
    }

    public void setAssetsTransfer(String assetsTransfer) {
        this.assetsTransfer = assetsTransfer;
    }
    
    public String getAssetsGIS() {
        return assetsGIS;
    }

    public void setAssetsGIS(String assetsGIS) {
        this.assetsGIS = assetsGIS;
    }
    
    public String getCompletionDocNo() {
        return completionDocNo;
    }

    public void setCompletionDocNo(String completionDocNo) {
        this.completionDocNo = completionDocNo;
    }
    
    public String getDataTransfer() {
        return dataTransfer;
    }

    public void setDataTransfer(String dataTransfer) {
        this.dataTransfer = dataTransfer;
    }
    
    public String getImportantDataSubmit() {
        return importantDataSubmit;
    }

    public void setImportantDataSubmit(String importantDataSubmit) {
        this.importantDataSubmit = importantDataSubmit;
    }
    
    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
    
    public String getImportantProAmount() {
        return importantProAmount;
    }

    public void setImportantProAmount(String importantProAmount) {
        this.importantProAmount = importantProAmount;
    }
    
    public String getSettlementPayable() {
        return settlementPayable;
    }

    public void setSettlementPayable(String settlementPayable) {
        this.settlementPayable = settlementPayable;
    }
    
    public String getSettlementPayMerchants() {
        return settlementPayMerchants;
    }

    public void setSettlementPayMerchants(String settlementPayMerchants) {
        this.settlementPayMerchants = settlementPayMerchants;
    }
    
    public String getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(String owedAmount) {
        this.owedAmount = owedAmount;
    }

    public String getThirdPaymentAmount() {
        return thirdPaymentAmount;
    }

    public void setThirdPaymentAmount(String thirdPaymentAmount) {
        this.thirdPaymentAmount = thirdPaymentAmount;
    }

    public String getRetentionAmount() {
        return retentionAmount;
    }

    public void setRetentionAmount(String retentionAmount) {
        this.retentionAmount = retentionAmount;
    }

    public String getRetentionExpires() {
        return retentionExpires;
    }

    public void setRetentionExpires(String retentionExpires) {
        this.retentionExpires = retentionExpires;
    }

    public String getNextMonthPayAmount() {
        return nextMonthPayAmount;
    }

    public void setNextMonthPayAmount(String nextMonthPayAmount) {
        this.nextMonthPayAmount = nextMonthPayAmount;
    }

    public String getOpticalNode() {
        return opticalNode;
    }

    public void setOpticalNode(String opticalNode) {
        this.opticalNode = opticalNode;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public String getChargeConstruction() {
        return chargeConstruction;
    }

    public void setChargeConstruction(String chargeConstruction) {
        this.chargeConstruction = chargeConstruction;
    }


    /**
     * 项目来源枚举定义
     *
     */
    public static enum ItemSourceGroup {
        /**
         * 市场
         */
        MARKET,
        /**
         * 技维
         */
        MAINTAIN,
        /**
         * VIP
         */
        VIP,
        /**
         * 省公司派单
         */
        AGGISN
    };
    
    /**
     * 项目性质枚举定义
     *
     */
    public static enum ProPropertyGroup {
        /**
         * 新建
         */
        NEW,
        /**
         * 改造
         */
        TRANSFORM,
        /**
         * 迁改
         */
        MOVE,
        /**
         * 专网
         */
        PRIVATENETWORK
    };
    
    /**
     * 项目类别枚举定义
     *
     */
    public static enum ProTypeGroup {
        /**
         * 城域网
         */
        MAN,
        /**
         * 接入
         */
        ACCESS,
        /**
         * HFC
         */
        HFC,
        /**
         * 管道
         */
        PIPELINE
    };
    
    /**
     * 施工方式枚举定义
     *
     */
    public static enum ConsMethodGroup {
        /**
         * 单包
         */
        SINGLE,
        /**
         * 双包
         */
        DOUBLE
    };
    
    /**
     * 施工阶段枚举定义
     *
     */
    public static enum ConsStageGroup {
        /**
         * 干线
         */
        ROUTE,
        /**
         * 总平
         */
        TOTALFLAT,
        /**
         * 户线
         */
        HOUSELINE
    };
}


