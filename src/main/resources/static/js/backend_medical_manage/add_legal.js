$().ready(function () {

  var textData = $('#text_data').summernote({
    lang: 'zh-CN',
    focus: false,
    placeholder:"法律法规内容",
    height: 200
  });

  $.validator.addMethod("checkTextData", function (value, element) {
    var html = textData.code();
    $("#textData").val(html);
    if(""==html){
      $(element).data('error-msg', icon + '请输入法律法规信息');
      return false;
    }else{
      return true;
    }
  }, function (params, element) {
    return $(element).data('error-msg');
  });

  $.validator.addMethod("checkTitleImages", function (value, element) {
    var fileNames = $("img[class='file-name']").attr("data-fileName");
    if(undefined==fileNames||""==fileNames){
      $(element).data('error-msg', icon + '请上传标题图片信息');
      return false;
    }else{
      return true;
    }
  }, function (params, element) {
    return $(element).data('error-msg');
  });


  /*form 验证开始*/
  var icon = "<i class='fa fa-times-circle'></i> ";
  var addFormValidate = $("#addForm").validate({
    ignore: [],
    onkeyup: false,
    debug: true,
    rules: {
      'title': {
        required: true,
        minlength: 2,
        maxlength: 200
      },
      'subTitle': {
        required: true,
        minlength: 2,
        maxlength: 200
      },
      'titleImages':{
        checkTitleImages: true
      },
      'sort': {
        required: true
      },
      'topping': {
        required: true
      },
      'textData':{
        checkTextData: true
      }
    },
    messages: {
      'title': {
        required: icon + "请输入标题",
        minlength: icon + "标题必须2个字符以上",
        maxlength: icon + "标题最长不能超过200字符"
      },
      'subTitle': {
        required: icon + "请输入标题",
        minlength: icon + "标题必须2个字符以上",
        maxlength: icon + "标题最长不能超过200字符"
      },
      'sort': {
        required: icon + "请输入排序"
      },
      'topping': {
        required: icon + "请输入选择是否置顶"
      }
    },
    submitHandler: function (form) {
      var fileNames = $("[class='file-name']");
      var files = "";
      $(fileNames).each(function (index,value) {
        files += $(value).attr("data-fileName")+";"
      });
      $("#titleImages").val(files.substring(0,files.length-1));
      form.submit();
    },
    invalidHandler: function (form, validator) {
      return false;
    }
  });

  uploadObj.uploadFile("uploadTitleImage",
      "/file/upload", ['jpg', 'png','jpeg'], 4096, $("meta[name='_csrf']").attr("content"), null, null, function (data) {
        if(data.code=="1"){
          $("#showTitleImages").prepend("<div class='img-box'><img data-fileName='"+data.data.fileName+"' class='file-name' src='"
          +data.data.imageServerPath+data.data.fileName+"' />"
          + "<div class='operate'><a href='javascript:void(0)' data-fileName='"+data.data.imageServerPath+data.data.fileName+"' class='preview-img'>预览</a>"
          + "<a href='javascript:void(0)' data-fileName='"+data.data.imageServerPath+data.data.fileName+"' class='del-img'>删除</a></div></div>");
        }else{

        }

      }, null);

  $(document).on("click",".preview-img",function () {
    var fileName = $(this).attr("data-fileName");
    $("#preview-file").html("<img src='"+fileName+"'>");
    $("#preview-file-box").show();
  });

  $(document).on("click",".del-img",function () {
    $(this).parent().parent().remove();
  });


});