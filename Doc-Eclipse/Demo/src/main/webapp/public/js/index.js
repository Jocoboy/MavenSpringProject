$(document).ready(function () {
    $("#btn_home").click(function () {
        window.location = "index";
    });

    $("#btn_food").click(function () {
        window.location = "food";
    });

    $("#btn_activity").click(function () {
        window.location = "activity";
    });

    $("#btn_login").click(function () {
        window.location = "login";
    });

    $("#btn_register").click(function () {
        window.location = "register";
    });
    
    /*for test...*/
    /*$("#btn_login_confirm").click(function () {
        window.location = "back.jsp";
    });*/
    /*for test...*/
    
    function clearAll() {
        $(".my-fav-box").addClass("no-show");
        $(".my-reserve-box").addClass("no-show");
        $(".my-settings-box").addClass("no-show");
        $(".my-publish-box").addClass("no-show");
    }

    function initAll() {
        $("#my-fav").removeClass("text-light").removeClass("bg-c2").addClass("c1").addClass("bg-c3");
        $("#my-reserve").removeClass("text-light").removeClass("bg-c2").addClass("c1").addClass("bg-c3");
        $("#my-settings").removeClass("text-light").removeClass("bg-c2").addClass("c1").addClass("bg-c3");
        $("#my-publish-food").removeClass("text-light").removeClass("bg-c2").addClass("c1").addClass("bg-c3");
    }

    $("#my-fav").click(function () {
        clearAll();
        $(".my-fav-box").removeClass("no-show");
        initAll();
        $("#my-fav").removeClass("c1").removeClass("bg-c3");
        $("#my-fav").addClass("text-light").addClass("bg-c2");
    });

    $("#my-reserve").click(function () {
        clearAll();
        $(".my-reserve-box").removeClass("no-show");
        initAll();
        $("#my-reserve").removeClass("c1").removeClass("bg-c3");
        $("#my-reserve").addClass("text-light").addClass("bg-c2");
    });

    $("#my-settings").click(function () {
        clearAll();
        $(".my-settings-box").removeClass("no-show");
        initAll();
        $("#my-settings").removeClass("c1").removeClass("bg-c3");
        $("#my-settings").addClass("text-light").addClass("bg-c2");
    });

    $("#my-publish-food").click(function () {
        clearAll();
        $(".my-publish-box").removeClass("no-show");
        initAll();
        $("#my-publish-food").removeClass("c1").removeClass("bg-c3");
        $("#my-publish-food").addClass("text-light").addClass("bg-c2");
    });
    
    


    $("#food-pic").on('change', function () {
  
        //获取上传文件的数量
        var countFiles = $(this)[0].files.length;
         
        var imgPath = $(this)[0].value;
        var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
        var image_holder = $("#image-holder");
        image_holder.empty();
         
        if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
         if (typeof (FileReader) != "undefined") {
         
          // 循环所有要上传的图片
          for (var i = 0; i < countFiles; i++) {
         
           var reader = new FileReader();
           reader.onload = function (e) {
            $("<img />", {
             "src": e.target.result,
              "class": "thumb-image"
            }).appendTo(image_holder);
           }
         
           image_holder.show();
           reader.readAsDataURL($(this)[0].files[i]);
          }
         
         } else {
          alert("你的浏览器不支持FileReader！");
         }
        } else {
         alert("请选择图像文件。");
        }
       });
    
    

});