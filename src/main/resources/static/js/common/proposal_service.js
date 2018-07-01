var ProposalService = {

    // 根据投保单号查询投保订单
    queryProposalByNo : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/queryByProposalNo",
            param : param,
            method:"GET"
        }, callback);
    },

    // 投保订单标的信息主被保人列表查询
    listSubjectPersonMaster : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/subject/person/master/query",
            param : param,
            method:"GET"
        }, callback);
    },

    // 投保订单标的信息附属被保人列表查询
    listSubjectPersonSlave : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/subject/person/slave/query",
            param : param,
            method:"GET"
        }, callback);
    },

    // 投保单受益人列表查询
    listBenefit : function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/benefit/query",
            param : param,
            method:"GET"
        }, callback);
    },

    // 根据标的信息主被保险人ID查询标的信息主被保险人信息
    getSubjectPersonMasterById: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/subject/person/master/queryById",
            param : param,
            method:"GET"
        }, callback);
    },

    // 根据标的信息附属被保险人ID查询标的信息附属被保险人信息
    getSubjectPersonSlaveById: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/subject/person/slave/queryById",
            param : param,
            method:"GET"
        }, callback);
    },

    // 根据投保单号获取投保单详细信息（不包含标的下被保人信息）
    getProposalDetail : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/business/get_policy_detail",
            param : param,
            method:"GET"
        }, callback);
    },

    // 根据投保单号获取投保单详细信息（包含标的物信息）
    getFacadeProposalDetail: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/detail/queryFacadeByProposalNo",
            param: param,
            method: "GET"
        }, callback);
    },
    // 根据投保单号获取投保单支付信息
    getProposalPay: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/pay/queryByProposalNo",
            param: param,
            method: "GET"
        }, callback);
    },
    // 根据投保单号获取投保单支付信息
    getFacadeProposalPay: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/pay/queryFacadeByProposalNo",
            param: param,
            method: "GET"
        }, callback);
    },
    // 修改团体投保单标的信息主被保人信息
    updateProposalSubjectPersonMaster: function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/group/subject/person/master/update",
            param : param,
            method:"GET"
        }, callback);
    },

    // 修改团体投保单标的信息附属被保人信息
    updateProposalSubjectPersonSlaveById : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/group/subject/person/slave/update",
            param : param,
            method:"GET"
        }, callback);
    },

    // 根据投保订单文件ID和单个文件名删除单个文件
    deleteProposalFileItem : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/file/item/delete",
            param : param,
            method:"GET"
        }, callback);
    },

    // 众安-投保单审核通过
    checkZAProposal: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/za/check",
            param : param,
            method:"GET"
        }, callback);
    },

    // 众安-投保单审核拒绝
    rejectZAProposal: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/za/reject",
            param : param,
            method:"GET"
        }, callback);
    },
    // 2.1线下支付审核-投保单审核
    checkFacadeProposal: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/facade/check",
            param: param,
            method: "GET"
        }, callback);
    },
// 2.1线下支付审核-投保单审核
    rejectFacadeProposal: function (param, callback) {
        commonJS.sendAjaxRequest({
            url: "/proposal/facade/reject",
            param: param,
            method: "GET"
        }, callback);
    },

    // 日志信息列表
    listBusinessLog : function (param, callback) {
        commonJS.sendAjaxRequest({
            url : "/proposal/businessLog/page/query",
            param : param,
            method:"GET"
        }, callback);
    },
};