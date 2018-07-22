$().ready(function () {

  commonListQuery.listQuery();

  $("#query").on("click",function () {
    commonListQuery.listQuery();
  })
});