//列表查询统一处理
var commonListQuery = {
    listQuery: function () {
        $('#loading', parent.document).show();
        this.trimAllPageElements();
        var ajaxObj = {url: $("#queryForm").attr("action"), param: $('#queryForm').serialize(), method: "GET"};
        commonJS.sendAjaxRequest(ajaxObj, function (data) {
            if (data.code == "1") {
                var dataResult = data.data;
                dataResult["start"] = (parseInt(data.data.pageNo, 10) - 1) * parseInt(data.data.pageSize, 10);
                if (data.data.totalCount > 0) {
                    $("#queryResult").html($("#listTableTemplate").render(dataResult));
                    commonListQuery.pagination(data.data.totalPage, 5);
                    $("#pagination-list").append("<li class='disabled'><a>&nbsp;&nbsp;共&nbsp;" + data.data.totalCount + "&nbsp;条</a><li>");
                } else {
                    $("#queryResult").html($("#noResultTemplate").render(dataResult));
                }
            } else {
                parent.layer.msg(data.message);
            }
            $('#loading', parent.document).hide();
        });
    },
    listQueryExport: function () {
        window.open($("#queryForm").attr("action") + "_export?" + $('#queryForm').serialize());
    },
    pagination: function (totalPages, visiblePages) {
        $('#pagination-list').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            first: "第一页",
            prev: "上一页",
            next: "下一页",
            last: "最后一页",
            onPageClick: function (event, page) {
                var pageNo = $("#pageNo");
                if (page != pageNo.val()) {
                    pageNo.attr("value", page);
                    commonListQuery.listQuery();
                }
            }
        });
    },

    trimAllPageElements: function () {
        this.trimAllPageElementsByTagName("input");
        this.trimAllPageElementsByTagName("textarea");
    },
    trimAllPageElementsByTagName: function (tagName) {
        if (tagName == null || tagName == undefined) {
            return;
        }
        var els = document.getElementsByTagName(tagName);
        for (var i = 0; i < els.length; i++) {
            this.handleSingleElement(els[i]);
        }
    },
    handleSingleElement: function (element) {
        if (element == null || element == undefined) {
            return;
        }
        if (element.type.indexOf("text") == 0 || element.type.indexOf("textarea") == 0 || element.type.indexOf("hidden") == 0) {
            element.value = $.trim(element.value);
        }
        if (element.type.indexOf("password") == 0) {
            element.value = $.trim(element.value);
        }
    }

};