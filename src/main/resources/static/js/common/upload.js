var uploadObj = {/*上传功能*/
    "uploadFile": function (btn, url,allowed, fileSize,token,startCallbak, onSubmitCallbak, onCompleteCallbak, onErrorCallbak) {
       var uploadObject =  new ss.SimpleUpload({ /*ajax文件上传公共方法*/
            button: btn,
            multipart: true,
            name: 'files',
            hoverClass: 'hover',
            focusClass: 'focus',
            responseType: 'json',
            allowedExtensions: allowed,
            maxSize: fileSize,
            url: url,
            customHeaders:{ "X-CSRF-TOKEN": token},
            startXHR: function (data) {/*上传前*/
                $('#loading', parent.document).show();
                if ("" != startCallbak&&startCallbak) {
                  return  startCallbak(data);
                }
            },
            onSubmit: function (data) {/*上传*/
                if ("" != onSubmitCallbak&&onSubmitCallbak) {
                   return onSubmitCallbak(data);
                }
            },
            onExtError: function( filename, extension ) {
              $('#loading', parent.document).hide();
              toastObj.toastMsg(true, false, "toast-top-center", "warning", "上传文件类型错误");
            },
            onSizeError: function( filename, fileSize ) {
              $('#loading', parent.document).hide();
              toastObj.toastMsg(true, false, "toast-top-center", "warning", "上传文件大小不能超过"+fileSize+"K");
            },
            onComplete: function (filename, response) {/*上传完成*/
                $('#loading', parent.document).hide();
                if ("" != onCompleteCallbak&&onCompleteCallbak) {
                    onCompleteCallbak(response);
                }
            },
            onError: function (data) {/*上传失败*/
               $('#loading', parent.document).hide();
                if ("" != onErrorCallbak&&onErrorCallbak) {
                    onErrorCallbak(data);
                }
            }
        });
       return uploadObject;
    }
};