$().ready(function () {

  $('#text_data').summernote({
    lang: 'zh-CN',
    focus: false,
    placeholder:"法律法规",
    height: 200,
  });

  $.validator.addMethod("checkTextData", function (value, element) {
    var code = $("#text_data").code();
    console.log(code);
    $("#textData").val(code);
    if(code==""){
      $(element).data('error-msg', icon + '请输入法律法规信息');
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
        required: true
      },
      'sort': {
        required: true
      },
      'toping': {
        required: true
      },
      'textData':{
        required: true
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
      'titleImages':{
        required: icon + "请上传标题图片"
      },
      'sort': {
        required: icon + "请输入排序"
      },
      'toping': {
        required: icon + "请输入选择是否置顶"
      },
      'textData':{
        required: icon + "请输入法律法规信息"
      }
    },
    submitHandler: function (form) {
      form.submit();
    },
    invalidHandler: function (form, validator) {
      return false;
    }
  });

});