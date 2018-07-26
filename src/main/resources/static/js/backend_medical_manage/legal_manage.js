$().ready(function () {


  laydate.render({elem: '#createTimeStart'});
  laydate.render({elem: '#createTimeEnd'});
  commonListQuery.listQuery();

  $("#query").on("click",function () {
    commonListQuery.listQuery();
  })
});