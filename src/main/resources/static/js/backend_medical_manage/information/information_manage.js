$().ready(function () {


  laydate.render({elem: '#createTimeStart'});
  laydate.render({elem: '#createTimeEnd'});
  commonListQuery.listQuery();

  $("#query").on("click",function () {
    commonListQuery.listQuery();
  });

  $(document).on("click",".offline",function () {

    var medicalInformationNo = $(this).attr("data-no");
    var param = {};
    param["medicalInformationNo"] = medicalInformationNo;
    var ajaxObj = {
      url: "/manage/offLineInformation",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        window.location.href="/manage/informationManage"
      } else {

      }
    });
  });

  $(document).on("click",".online",function () {

    var medicalInformationNo = $(this).attr("data-no");
    var param = {};
    param["medicalInformationNo"] = medicalInformationNo;
    var ajaxObj = {
      url: "/manage/onLineInformation",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        location.href="/manage/informationManage"
      } else {

      }
    });
  });
});