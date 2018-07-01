
$(function(){
    //菜单点击J_iframe
    $(".J_menuItem").on('click',function(){
        var url = $(this).attr('href');
        $("#J_iframe").attr('src',url);
        $('#loading', parent.document).hide();
        return false;
    });

    var updatePassword = function () {
        var param = {};
        param['oldPassword'] = $("#oldPassword").val();
        param['password'] = $("#password").val();
        param['confirmPassword'] = $("#confirmPassword").val();
        var ajaxObj = {url:'/user/updatePassword',param:JSON.stringify(param),method:"POST",contentType:"application/json; charset=utf-8"};
        commonJS.sendAjaxRequest(ajaxObj, function(data) {
            if(data.code=="1"){
                $("#updateUserPasswordModal").modal("hide");
                alertObj.sweetInfo("处理成功!","您已成功修改密码，请重新登录。",function () {
                    window.location.href = "/logout";
                });
            }else{
                updatePasswordFormValidate.showErrors(data.data);
            }
        });
    };

    var icon = "<i class='fa fa-times-circle'></i> ";
    var updatePasswordFormValidate = $("#updatePasswordForm").validate({
        rules: {
            oldPassword:{
                required: true,
                minlength: 5
            },
            password:{
                required: true,
                minlength: 8,
                checkPasswordStrong: true
            },
            confirmPassword:{
                required: true,
                minlength: 8,
                equalTo: "#password"
            }
        },
        messages: {
            oldPassword: {
                required: icon + "请输入原始密码",
                minlength: icon + "原始密码5个字符以上"
            },
            password:{
                required: icon + "请输入新密码",
                minlength: icon + "新密码至少8个字符",
                checkPasswordStrong: icon + "密码强度不够"
            },
            confirmPassword:{
                required: icon + "请输入确认密码",
                minlength: icon + "确认密码与密码不一致"
            }
        },
        submitHandler:function (form) {
            updatePassword();
        },
        invalidHandler:function (form,validator) {
            return false;
        }
    });

    //修改密码
    $("#updatePassword").on("click",function () {
        $(".ibox-content div").removeClass("has-error");
        $(".ibox-content div").removeClass("has-success");
        $(".ibox-content span.help-block.m-b-none").remove();
        $(".ibox-content input").removeClass("help-block m-b-none")
        $(".ibox-content .col-sm-8 input").val("");
        $("#updateUserPasswordModal").show();
    });

    $("#cancelUpdate").on("click",function(){
        $("#updateUserPasswordModal").hide();
    });

    /*导航高亮*/
    $('.nav li a').click(function () {
        $(".nav li").removeClass('active');
        if($(this).parent().hasClass("show")){
            $(this).parent().removeClass('active');
            $(this).parent().removeClass('show');
        }else{
            $(this).parent().addClass('active');
            $(this).parent().addClass('show');
        }
        var iframesrc = $("#J_iframe").attr("src");
        var ele='.nav-second-level a[href="';
        ele+=iframesrc;
        ele+='"]';
        if($(this).parent().parent().hasClass("nav-second-level")){
          $(this).parent().parent().parent().addClass("active");
        } else {
            $(this).parent().find(ele).parent().addClass("active");
        }
    });

});