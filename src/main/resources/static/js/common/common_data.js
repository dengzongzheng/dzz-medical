var commonDataObj = {
  listArea:function (level,callbackFn) {
    var ajaxObj = {url:"/area/listArea",param:{level:level},method:"GET"};
    commonJS.sendAjaxRequest(ajaxObj, function(data) {
      if(data.code=="1"){
        if (callbackFn && typeof callbackFn === 'function') {
          callbackFn(data.data);
        }
      }
    });
  },
  getAreaByCode:function (areaCode) {
    var ajaxObj = {url:"/area/getAreaByCode",param:{areaCode:areaCode},method:"GET"};
    commonJS.sendAjaxRequest(ajaxObj, function(data) {
      if(data.code=="1"){
        return data.data;
      }
    });
  },
  subArea:function (areaCode,callbackFn) {
    var ajaxObj = {url:"/area/subArea",param:{areaCode:areaCode},method:"GET"};
    commonJS.sendAjaxRequest(ajaxObj, function(data) {
      if(data.code=="1"){
        if (callbackFn && typeof callbackFn === 'function') {
          callbackFn(data.data);
        }
      }
    });
  },
  listCompany:function (insuranceType,callbackFn) {
    var ajaxObj = {url:"/company/listCompany",param:{insuranceType:insuranceType},method:"GET"};
    commonJS.sendAjaxRequest(ajaxObj, function(data) {
      if(data.code=="1"){
        if (callbackFn && typeof callbackFn === 'function') {
          callbackFn(data.data);
        }
      }
    });
  },
  listRiskCategory:function (insuranceType,callbackFn) {
    var ajaxObj = {url:"/riskCategory/listRiskCategory",param:{insuranceType:insuranceType},method:"GET"};
    commonJS.sendAjaxRequest(ajaxObj, function(data) {
      if(data.code=="1"){
        if (callbackFn && typeof callbackFn === 'function') {
          callbackFn(data.data);
        }
      }
    });
  },
    listItemByBelongCompany: function (insuranceCode, callbackFn) {
        var ajaxObj = {url: "/item/listByBelongCompany", param: {insuranceCode: insuranceCode}, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (data) {
            if (data.code == "1") {
                if (callbackFn && typeof callbackFn === 'function') {
                    callbackFn(data.data);
                }
            }
        });
    },
    listItemClaimData: function (itemCodes, callbackFn) {
        var ajaxObj = {url: "/item/listItemClaimData", param: {itemCodes: itemCodes}, traditional: true, method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (data) {
            if (data.code == "1") {
                if (callbackFn && typeof callbackFn === 'function') {
                    callbackFn(data.data);
                }
            }
        });
    }

};