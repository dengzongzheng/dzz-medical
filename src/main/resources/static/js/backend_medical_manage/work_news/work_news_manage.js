$().ready(function () {


  laydate.render({elem: '#createTimeStart'});
  laydate.render({elem: '#createTimeEnd'});
  commonListQuery.listQuery();

  $("#query").on("click",function () {
    commonListQuery.listQuery();
  });

  $(document).on("click",".offline",function () {

    var medicalNoticeNo = $(this).attr("data-no");
    var param = {};
    param["medicalNoticeNo"] = medicalNoticeNo;
    var ajaxObj = {
      url: "/manage/offLineNotice",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        window.location.href="/manage/workNewsManage"
      } else {

      }
    });
  });

  $(document).on("click",".online",function () {

    var medicalNoticeNo = $(this).attr("data-no");
    var param = {};
    param["medicalNoticeNo"] = medicalNoticeNo;
    var ajaxObj = {
      url: "/manage/onLineNotice",
      param: param,
      method: "POST",
      contentType : "application/x-www-form-urlencoded"
    };
    commonJS.sendAjaxRequest(ajaxObj, function (data) {
      if (data.code == "1") {
        location.href="/manage/workNewsManage"
      } else {

      }
    });
  });
});