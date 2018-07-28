$().ready(function () {

  var legalObj = {
    "queryLegal":function () {
      var param = {};
      param["pageSize"] = $("#pageSize").val();
      param["pageNo"] = $("#pageNo").val();
      var ajaxObj = {
        url: "/forService/listLegal",
        param: param,
        method: "GET",
        contentType: "application/json"
      };
      commonJS.sendAjaxRequest(ajaxObj, function (data) {
        if (data.code == "1") {
          console.log(data);
          var html = "";
          $(data.data.data).each(function (index,value) {
            if(value.isOneImage){
              html += $("#listLegalTemplate1").render(value)
            }else{
              html += $("#listLegalTemplate2").render(value)
            }
          });
          $("#content-box").html(html);
        } else {

        }
      });
    }
  };
  legalObj.queryLegal();

});