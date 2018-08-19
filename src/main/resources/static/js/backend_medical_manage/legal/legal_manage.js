$().ready(function () {


  laydate.render({elem: '#createTimeStart'});
  laydate.render({elem: '#createTimeEnd'});
  commonListQuery.listQuery();

  $("#query").on("click",function () {
    commonListQuery.listQuery();
  });

  $(document).on("click",".offline",function () {

    var medicalLegalNo = $(this).attr("data-no");
    var param = {};
    param["medicalLegalNo"] = medicalLegalNo;
    var ajaxObj = {
      url: "/manage/offLineLegal",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        window.location.href="/manage/legalManage"
      } else {

      }
    });
  });

  $(document).on("click",".online",function () {

    var medicalLegalNo = $(this).attr("data-no");
    var param = {};
    param["medicalLegalNo"] = medicalLegalNo;
    var ajaxObj = {
      url: "/manage/onLineLegal",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        location.href="/manage/legalManage"
      } else {

      }
    });
  });
});