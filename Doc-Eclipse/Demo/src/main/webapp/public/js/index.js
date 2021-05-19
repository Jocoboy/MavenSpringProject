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
    
    

    
   
    

});