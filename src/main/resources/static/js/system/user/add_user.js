$().ready(function () {    // $('#addUserBaseForm').disableAutoFill();    var addUserObj = {        "addUser": function () {            var param = $("#addUserBaseForm").serializeJson();            var belong = {};            belong["departmentId"] = $("#departmentId").val();            belong["roleId"] = $("#roleId").val();            belong["higherLevelUsers"] = [];            belong["lowerLevelUsers"] = [];            var higherLevelUsersId = $("#higherLevelUsers").val();            var lowerLevelUsersId = $("#lowerLevelUsers").val();            if ("" != higherLevelUsersId) {                var higherLevelUsers = [];                $("#" + higherLevelUsersId).find(".belongUser").each(function () {                    if ($(this).is(':checked')) {                        var user = {};                        user["userId"] = $(this).val();                        higherLevelUsers.push(user);                    }                });                belong["higherLevelUsers"] = higherLevelUsers;            }            if ("" != lowerLevelUsersId) {                var lowerLevelUsers = [];                $("#" + lowerLevelUsersId).find(".belongUser").each(function () {                    if ($(this).is(':checked')) {                        var user = {};                        user["userId"] = $(this).val();                        lowerLevelUsers.push(user);                    }                });                belong["lowerLevelUsers"] = lowerLevelUsers;            }            param["userBelongAddDTO"] = belong;            console.log(JSON.stringify(param))            var ajaxObj = {                url: "/user/addUser",                param: JSON.stringify(param),                method: "POST",                contentType: "application/json"            };            commonJS.sendAjaxRequest(ajaxObj, function (data) {                if (data.code == "1") {                    toastObj.toastMsg(true, true, "toast-top-center", "success", "新增成功");                    window.location.href = "/user/userManage";                } else {                    toastObj.toastMsg(true, true, "toast-top-center", "warning", data.message);                }            });        },        getDepartmentRoles: function () {            var departmentId = $("#departmentId").val();            if ("" == departmentId) {                var options = "<option value=''>请选择</option>";                $("#roleId").html(options);                return;            }            var param = {};            param["departmentId"] = departmentId;            var ajaxObj = {                url: "/role/getDepartmentRoles",                param: param,                method: "GET",                contentType: "application/json"            };            commonJS.sendAjaxRequest(ajaxObj, function (data) {                if (data.code == "1") {                    var options = "<option value=''>请选择</option>";                    $("#roleId").html(options + $("#roleOptionsTemplate").render(data.data));                } else {                }            });        },        belongUserShow: function (roleTypeUserId, departmentId, roleType, templateId) {            var param = {};            param["departmentId"] = departmentId;            param["roleType"] = roleType;            var ajaxObj = {                url: "/user/allDepartmentUsers",                param: param,                method: "GET",                contentType: "application/json"            };            commonJS.sendAjaxRequest(ajaxObj, function (data) {                if (data.code == "1") {                    $("#" + roleTypeUserId).html($("#" + templateId).render(data.data));                } else {                }            });        },        showDepartmentUsers: function () {            $(".roleType").hide();            $("#roleType2User").html();            $("#roleType3User1").html();            $("#roleType3User2").html();            $("#roleType4User").html();            var departmentId = $("#departmentId").val();            var roleType = $("#roleId").find("option:selected").attr("data-roletype");            if ("" == departmentId || "" == roleType) {                return;            }            $("#higherLevelUsers").attr("value", "");            $("#lowerLevelUsers").attr("value", "");            if (roleType == "2") {                addUserObj.belongUserShow("roleType2User", departmentId, 3, "checkboxTemplate");                $("#lowerLevelUsers").attr("value", "roleType2User");            } else if (roleType == "3") {                addUserObj.belongUserShow("roleType3User1", departmentId, 2, "checkboxTemplate");                addUserObj.belongUserShow("roleType3User2", departmentId, 4, "checkboxTemplate");                $("#higherLevelUsers").attr("value", "roleType3User1");                $("#lowerLevelUsers").attr("value", "roleType3User2");            } else if (roleType == "4") {                addUserObj.belongUserShow("roleType4User1", departmentId, 3, "checkboxTemplate");                $("#lowerLevelUsers").attr("value", "roleType4User1");            }            $("#roleType" + roleType).show();        }    };    var icon = "<i class='fa fa-times-circle'></i> ";    var addUserBaseFormValidate = $("#addUserBaseForm").validate({        onkeyup: false,        debug: false,        rules: {            account: {                required: true,                minlength: 3,                maxlength: 20,                validateAccount: true            },            userName: {                required: true,                maxlength: 40,            },            mobile: {                required: true,                checkMobile: true            },            email: {                required: true,                checkEmail: true,                maxlength: 45            },            password: {                required: true,                minlength: 8,                maxlength: 20,                checkPasswordStrong: true            },            confirm_password: {                required: true,                maxlength: 20,                equalTo: "#password"            }        },        messages: {            account: {                required: icon + "请输入帐户信息",                minlength: icon + "帐号信息必须3个字符以上",                validateAccount: icon + "账号只能输入英文与数字"            },            userName: {                required: icon + "请输入真实姓名",                maxlength: icon + "真实姓名不能大于40字符",            },            mobile: {                required: icon + "请输入手机号",                checkMobile: icon + "请输入正确手机号"            },            email: {                required: icon + "请输入邮箱信息",                checkEmail: icon + "请输入正确的邮箱信息",                maxlength: icon + "邮箱地址最长不能超过45个字符"            },            password: {                required: icon + "请输入密码",                minlength: icon + "密码至少8个字符",                maxlength: icon + "密码不能超过20个字符",                checkPasswordStrong: icon + "密码强度不够"            },            confirm_password: {                required: icon + "请输入确认密码",                equalTo: icon + "确认密码与密码不一致",                maxlength: icon + "密码不能超过20个字符"            }        },        submitHandler: function (form) {            $("#userBaseForm").hide();            $("#userRoleForm").show();        },        invalidHandler: function (form, validator) {            return false;        }    });    var addUserRoleFormValidate = $("#addUserRoleForm").validate({        rules: {            departmentId: {                required: true            },            roleId: {                required: true            }        },        messages: {            departmentId: {                required: icon + "请选择归属部门"            },            roleId: {                required: icon + "请选择用户角色"            }        },        submitHandler: function (form) {            addUserObj.addUser();        },        invalidHandler: function (form, validator) {            return false;        }    });    $("#departmentId").on("change", function () {        addUserObj.getDepartmentRoles();    });    $("#roleId").on("change", function () {        addUserObj.showDepartmentUsers();    });    $("#previous").on("click", function () {        $("#userRoleForm").hide();        $("#userBaseForm").show();    });});$.validator.addMethod("validateAccount", function (value, element) {    var reg = /^[0-9a-zA-Z]+$/; //zhongwen:/.*[\u4e00-\u9fa5]+.*$/    if (reg.test(value)) {        return true;    } else {        return false;    }}, "");function tipClass(inputId) {    $("#" + inputId).removeClass("help-block");    $("#" + inputId).removeClass("m-b-none");}