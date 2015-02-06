function delayURL(url){
    var delay=document.getElementById("time").innerHTML;
    if(--delay>0){
       
        document.getElementById("time").innerHTML=delay;
        setTimeout("delayURL('"+url+"'),1000)");
    }else{
        window.location.href=url;
        
    }
}
function showLciense(lciUrl){
	
	var popUpSizeX=700;
	var popUpSizeY=450;
	var popUpLocationX=400;
	var popUpLocationY=100;
	var popUpURL=lciUrl;
	
	//splashWin=window.open("", 'x', 'fullscreen=0,,scrollbars=auto,resizeable=0');
	splashWin=window.open("", 'x', 'toolbar:no,menubar:no,scrollbars:no,resizeable=no,status:no');
	//splashWin=window.open("", 'x', 'toolbar=0,status=0,resizable=1,width=620,height=650');
	splashWin.blur();
	splashWin.focus();
	splashWin.resizeTo(popUpSizeX, popUpSizeY);
	splashWin.moveTo(popUpLocationX, popUpLocationY);
	
	splashWin.location=popUpURL;
	//showModalDialog(lciUrl, window, "dialogwidth=700px;dialogheight=500px;status=no;help:no;resizable:no;scrollbars:no;");
	
	
	
}
    
//发布校验
function check_sendls(){
	    
		if (document.sendlsform.cat.value=="") {
			$("#tips").slideDown(200);
			$("#message_text").text('请为您的牢骚选择一个分类 ');
			return false;
		}
		if (document.sendlsform.content.value=="") {
			$("#tips").slideDown(200);
			$("#message_text").text('请先抒写您的牢骚再发布 ');
			return false;
		}
		return true;
	}
//上传文件
$(document).ready(function(){
		$("#profile_avatar").change(ajaxUpload);
	
});
function ajaxUpload() {
	//var filepath=document.avatar_form.image.value;
	var filepath=$("input[name='image']").val();
	
	var extStart=filepath.lastIndexOf(".");
	var ext=filepath.substring(extStart,filepath.lenth).toUpperCase();
	//alert(ext);
	if(ext!=".JPG"&&ext!=".JPEG"&&ext!=".GIF"&&ext!=".PNG"){
		$("#tips").slideDown(200);
		$("#message_text").text('格式 仅限于JPG/JPEG, GIF or PNG');
		setTimeout("$('#tips').slideUp(200)", 2000);
		return false;
	}
	
	//var fso=new ActiveXObject("ScriptingFileSystemObject");
	//alert(fso.GetFile(filepath).size);
	
	
	document.avatar_form.submit();
	
}
function check_rchgpass_Submit(){
	var old_password= document.chgpassform.old_password.value;
	var new_password= document.chgpassform.new_password.value;
	if(old_password==""){
		$("#tips").slideDown(200);
		$("#message_text").text('请输入原密码');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	if(new_password==""){
		$("#tips").slideDown(200);
		$("#message_text").text('请输入新密码');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	if(new_password.length<=4){
		$("#tips").slideDown(200);
		$("#message_text").text('新密码长度应大于4');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
}

//点击图片更换验证码
$(function () {  
     
     $("#Verify").click(function(){
         $(this).attr("src","security/SecurityCodeImageAction?timestamp="+new Date().getTime());
     });
 });

function check_goto_Submit(){
	var totalPage=document.gotoform.totalPage.value;
	var currentPage=document.gotoform.currentPage.value;
	if(currentPage<=0){
		document.gotoform.totalPage.value=1;
		$("#tips").slideDown(200);
		$("#message_text").text('请输入页面小于1，默认为1');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	if(currentPage>totalPage){
		$("#tips").slideDown(200);
		$("#message_text").text('一共'+totalPage+'页 想去'+currentPage+'页 是不可能的');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	
}

//后台消息前台展示
function login_onload_no(nomsg){
	//alert(msg);
	if(nomsg!=""&&nomsg!=null&&nomsg!="null"){
		
		
		$("#tips").slideDown(100);
		$("#message_text").text(nomsg);
		setTimeout("$('#tips').slideUp(200)", 3000);
		
	}
}
function login_onload_yes(yesmsg){
	//alert(msg);
	if(yesmsg!=""&&yesmsg!=null&&yesmsg!="null"){
		
		$("#tips_t").addClass("tips_t_green");
		$("#message_dock").addClass("message_dock_green");
		$("#tips").slideDown(100);
		$("#message_text").text(yesmsg);
		setTimeout("$('#tips').slideUp(200)", 3000);
                
                
		
	}
}


function check_reply_Submit(){
	if (document.replyform.post_comment_text.value == "") {
		document.replyform.post_comment_text.focus();
		$("#tips").slideDown(200);
		$("#message_text").text('请输入回复内容');
		setTimeout("$('#tips').slideUp(200)", 3000);
		
		return false;
	}
	
}
function check_bug_Submit(){
	if (document.bugform.post_comment_text.value == "") {
		document.bugform.post_comment_text.focus();
                $("#message_dock").removeClass("message_dock_green")
                $("#tips_t").removeClass("tips_t_green");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入Bug内容');
		setTimeout("$('#tips').slideUp(200)", 3000);
		
		return false;
	}
	
}
//登录验证
function check_login_Submit() {
   // alert("-----------------");
	if (document.loginform.login_email.value == "") {
		document.loginform.login_email.focus();
		//alert("请输入邮箱地址！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入邮箱地址');
		setTimeout("$('#tips').slideUp(200)", 3000);
		
		return false;
	} else {
		var vmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!vmail.test(document.loginform.login_email.value)) {
			//alert("请输入正确的邮箱地址！");
			$("#tips").slideDown(200);
			$("#message_text").text('请输入正确的邮箱地址 ');
			setTimeout("$('#tips').slideUp(200)", 3000);
			return false;
		} 

	}
	if (document.loginform.login_password.value == "") {
		document.loginform.login_password.focus();
		//alert("请输入密码！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入密码 ');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
		//return false;
	}
	
	if (document.loginform.securityCode.value == "") {
		document.loginform.securityCode.focus();
		//alert("请输入验证码！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入验证码 ');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}else{
		if(document.loginform.securityCode.value.length!=4){
			//alert("请核实验证码的长度！");
			
			$("#tips").slideDown(200);
			$("#message_text").text('请核实验证码的长度');
			setTimeout("$('#tips').slideUp(200)", 3000);
			return false;
		}
	}
	/*
	var login_error	   = $("#login_error");

	login_error.removeClass("hidden").html("登录成功，即将跳转...");
	window.setTimeout(gotourl(data), 2000);*/
	
}
function chageOK(){
	if(document.registerform.hd_isOK.value=="1"){
		document.registerform.hd_isOK.value="0";
	}else{
		document.registerform.hd_isOK.value="1";
	}
	alert(document.registerform.hd_isOK.value);
}
//显示后台信息
function alertMes(mes){
	if(mes!=""){
		alert(mes);
	}
}
//
function changeImage() {

	var verifyObj = document.getElementById("Verify");
	verifyObj.onclick = function() {
		this.src = "Security/SecurityCodeImageAction?timestamp="
				+ new Date().getTime();

	};
}
// 验证注册
function check_register_Submit() {
	//alert(" 验证注册");
	//alert(document.registerform.isOK.checked);
	var userPassWord = document.registerform.reg_password.value;
	var userPassWord2 = document.registerform.reg_password2.value;
	//alert(document.registerform.alread.checked);
    if(document.registerform.alread.checked==false){
    	///alert("111111");
    	document.registerform.alread.focus();
		
		$("#tips").slideDown(200);
		$("#message_text").text('请确定已经阅读用户须知！ ^^');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
    	
    }
	if (document.registerform.reg_email.value == "") {

		document.registerform.reg_email.focus();
		//alert("请输入邮箱！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入邮箱！ ^^');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	} else {
		var vmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!vmail.test(document.registerform.reg_email.value)) {
			//alert("请输入正确的邮箱地址！");
			$("#tips").slideDown(200);
			$("#message_text").text('请输入正确的邮箱地址');
			setTimeout("$('#tips').slideUp(200)", 3000);
			return false;
		} 

	}
	
	if (document.registerform.reg_nickname.value == "") {
		document.registerform.reg_nickname.focus();
		//alert("请输入昵称！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入昵称');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	if (document.registerform.reg_password.value == "") {
		document.registerform.reg_password.focus();
		//alert("请输入密码！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入密码');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	
	if (document.registerform.reg_password2.value == "") {
		document.registerform.reg_password2.focus();
		//alert("请输入重复密码！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入重复密码');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	if (userPassWord != userPassWord2) {
		document.registerform.reg_password2.focus();
		//alert("两次输入的密码不一致");
		$("#tips").slideDown(200);
		$("#message_text").text('两次输入的密码不一致 ');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}
	
	if (document.registerform.securityCode.value =="") {
		document.registerform.securityCode.focus();
		//alert("请输入验证码！");
		$("#tips").slideDown(200);
		$("#message_text").text('请输入验证码 ');
		setTimeout("$('#tips').slideUp(200)", 3000);
		return false;
	}else{
		if(document.registerform.securityCode.value.length!=4){
			$("#tips").slideDown(200);
			$("#message_text").text('请核实验证码的长度 ');
			setTimeout("$('#tips').slideUp(200)", 3000);
			//alert("请核实验证码的长度！");
			
			return false;
		}
	}
	/*
	if(document.registerform.hd_isOK.value!="1"){
		alert("同意条款 方能注册！");
		return false;
	}
    */
	

}
//

//JavaScript Document
$(document).ready(function() {
	var $backToTopEle = $('<div class="back_to_top"></div>').appendTo($("body")).click(function() {
            $("html, body").animate({ scrollTop: 0 }, 120);
    }), $backToTopFun = function() {
        var st = $(document).scrollTop(), winh = $(window).height();
        (st > 0)? $backToTopEle.fadeIn(): $backToTopEle.fadeOut();    
        //IE6下的定位
        if (!window.XMLHttpRequest) {
            $backToTopEle.css("top", st + winh - 166);    
        }
    };
    $(window).bind("scroll", $backToTopFun);
    $(function() { $backToTopFun(); });
});

$(document).ready(function(){
	$('a#logo, #right_menu_box ul li a').jrumble();
	var login_state   = $("#login_state");
	var input_content = $("#input_content");
	var input_tags    = $("#input_tags");
	var btn_pub = $("#btn_pub");
	
	//login_state.load('/header_check_login.php');
	/*$.ajax({
		type: "GET",
		url:  "/header_check_login.php",
		dataType: "html",
		cache: false,
		success: function(data) {
			login_state.html(data);
		}
	});*/
	
	//顶部搜索框焦点
	
	var search_q = $('#search_q');
	search_q.focus(function(){
		if (search_q.val() == '按关键字/昵称/编号搜索') {
			search_q.val('');
		}	
	});
	search_q.blur(function(){
		if (search_q.val() == '') {
			search_q.val('按关键字/昵称/编号搜索');
		}	
	});

	
	//loading more
	var more_info = $("#more-info");
	var wrap_info = $("#wrap_info");
	more_info.click(function(){
		$.ajax({
			type: "GET",
			url:  "moreload.php",
			dataType: "html",
			cache: false,
			success: function(data) {
				wrap_info.append(data);
			}
		});
	});
	
	//显示Email表单
	$('#sender_email_link').click(function(){
		$('#sender_email_zone').html('Email(选填)<input type="text" name="sender_email" id="sender_email" style="border:1px solid #578CCA; height:20px;width:170px;" />');
		$('#sender_email').focus();
	});
	
	
	if ($.trim(input_content.val()) != '') {
		input_content.removeClass("input_content");
	}
	input_content.focus(function(){
		input_content.removeClass("input_content");
	});
	input_content.blur(function(){
		if ($.trim(input_content.val()) == '') {
			input_content.addClass("input_content");
		}
	});
	
	//发布
	/*
	$("#btn_pub").click(function(){
		$("#tips").slideUp(200);
		if ($("#input_nickname").val().length > 15) {
			$("#tips").slideDown(200);
			$("#message_text").text('您填写的昵称太长了，换一个吧 ^^');
		} else if ($("#input_sex").val() == '') {
			$("#tips").slideDown(200);
			$("#message_text").text('请选择您的性别 ^^');
		} else if ($("#input_cat").val() == '') {
			$("#tips").slideDown(200);
			$("#message_text").text('请为您的草蛋事儿选择一个分类 ^^');
		} else if ($.trim(input_content.val()) == '') {
			$("#tips").slideDown(200);
			$("#message_text").text('请先抒写您的草蛋事儿再发布 ^^');
		} else {
			var res = $("#pub_wrap form").serialize();
			btn_pub.ajaxStart(function(){
				$(this).val('提交中...');
				$(this).attr({disabled: "disabled"});
			});
			$.ajax({
				type: 'POST',
				url: '/action/publish_info',
				data: res,
				cache: false,
				success: function(data) {
					if (data == 'CONTENT_REPEATED') {
						$("#tips").slideDown(200);
						$("#message_text").text('不要贪心哦，类似内容的草蛋发一条就够啦。');	
						$('#btn_pub').val('提 交');
						$('#btn_pub').removeAttr('disabled');
					} else {
						$("#tips_t").addClass("tips_t_green");
						$("#message_dock").addClass("message_dock_green");
						$("#tips").slideDown(200);
						$("#message_text").html(data);
						input_content.val("");
						input_tags.val("");
						setTimeout("$('#pub_wrap').slideUp(200);$('#btn_pub').val('提 交');$('#btn_pub').removeAttr('disabled');", 4000);
						setTimeout("$('#tips').slideUp(200)", 4000);
						setTimeout("$('#tips_t').removeClass('tips_t_green');$('#message_dock').removeClass('message_dock_green');", 5000);
					}
				}
			});
		}
		
		setTimeout("$('#tips').slideUp(200)", 10000);
	});
	
	$("#message_dock").click(function(){
		$("#tips").slideUp(200);
	});
	*/
	$("#menu_cen_right span").click(function(){
		$("#pub_wrap").slideToggle();
	});
	
	//post comments
	
	$('#post_comment_btn_1').click(function(){
		$("#tips").slideUp(200);
		var post_comment_text = $('#post_comment_text');
		if ($.trim(post_comment_text.val()) == '') {
			$("#tips").slideDown(200);
			$("#message_text").text('评论内容不能为空');
			setTimeout("$('#tips').slideUp(200)", 3000);
		} else if ($.trim($('#post_comment_name').val()).length > 20) {
			$("#tips").slideDown(200);
			$("#message_text").text('昵称不能超过20个字符');
			setTimeout("$('#tips').slideUp(200)", 3000);
		} else {
			var res = $("#post_comment_box form").serialize();
			$.ajax({
				type: 'POST',
				url: '/action/new_comments',
				data: res,
				dataType: "html",
				cache: false,
				beforeSend: function(){
					$('#post_comment_btn').val('提交中...');
					$('#post_comment_btn').attr({disabled: "disabled"});
				},
				success: function(data) {
					if (data == 'TOO_MUCH_CONTENT') {
						$("#tips").slideDown(200);
						$("#message_text").text('抱歉，一次发布的内容太长了哦');
						$('#post_comment_btn').val('发布评论(Alt+S)');
						$('#post_comment_btn').removeAttr('disabled');
						setTimeout("$('#tips').slideUp(200)", 3000);
					} else if (data == 'POST_TOO_FAST') {
						$("#tips").slideDown(200);
						$("#message_text").text('您发布的太快了，坐下歇歇再发吧^ ^');
						$('#post_comment_btn').val('发布评论(Alt+S)');
						$('#post_comment_btn').removeAttr('disabled');
						setTimeout("$('#tips').slideUp(200)", 3000);
					} else if (data == 'BAD_KEYWORDS') {
						$("#tips").slideDown(200);
						$("#message_text").text('评论内容包含未经允许的违规内容');
						$('#post_comment_btn').val('发布评论(Alt+S)');
						$('#post_comment_btn').removeAttr('disabled');
						setTimeout("$('#tips').slideUp(200)", 3000);
					} else {
						//$("#tips_t").addClass("tips_t_green");
						//$("#message_dock").addClass("message_dock_green");
						//$("#tips").slideDown(200);
						//$("#message_text").html(data);
						var numplus = Number($("#dateleft span").text()) + 1;
						$("#dateleft span").text(numplus);
						$("#comments_list").append(data)
						post_comment_text.val("");
						setTimeout("$('#post_comment_btn').val('发布评论(Alt+S)');$('#post_comment_btn').removeAttr('disabled');", 1000);
						//setTimeout("$('#tips').slideUp(200)", 4000);
						//setTimeout("$('#tips_t').removeClass('tips_t_green');$('#message_dock').removeClass('message_dock_green');", 5000);
					}
				}
			});
		}
		
	});
	
	//注册
	
	
	
});

function pub_done()
{
	$('#pub_wrap').slideUp(200);
	$('#btn_pub').val('提 交');
	$('#btn_pub').removeAttr('disabled');	
}



//计算
function cut(input){
	if (input.value.length >= 150){
		input.value = input.value.substring(0,150);
	}
	var reste = 150 - input.value.length;
	$("#count_box span").text(reste);
}

function settingMenuToggle() {
	$("#settings_menu_drop").toggle();
	if ($("#settings_menu_drop").css("display") == 'block') {
		$("#settings_menu").css({"-moz-border-radius":"5px 5px 0 0","-khtml-border-radius":"5px 5px 0 0","-webkit-border-radius":"5px 5px 0 0","border-radius":"5px 5px 0 0"});
		$("#settings_menu span").css({"background-position":"-130px -134px"});
	} else {
		$("#settings_menu").css({"-moz-border-radius":"5px","-khtml-border-radius":"5px","-webkit-border-radius":"5px","border-radius":"5px"});	
		$("#settings_menu span").css({"background-position":"-145px -134px"});
	}
}

function actfollowing(uid) {
	//alert(""+uid);
	$.ajax({
		type: 'POST',
		url:  'user/FllowAction!addFllow',
		data: "uid=" + uid,
		success: function(data) {
			/*if (data == 'NOT_LOGIN') {
				$("#f_" + uid).html('<a href="/login.php">请登录</a>');
			} else if (data == 'ERROR_NO2') {
				$("#tips").slideDown(200);
				$("#message_text").text('不能自己关注自己');
				setTimeout("$('#tips').slideUp(200)", 2000);
			} else if (data == 'ALREADY_FOLLOWED') {
				$("#tips").slideDown(200);
				$("#message_text").text('已经关注了对方');
				setTimeout("$('#tips').slideUp(200)", 2000);
			} else */if (data == 'FOLLOWING_OK') {
				$("#f_" + uid).attr("class", "delfollow");
				$("#f_" + uid).text('已关注');
                                //alert($("#fllow_count").text());
                               $("#fllow_count").text(parseInt($("#fllow_count").text())+1)
			} else if (data == 'CANCELED_FOLLOWING') {
				$("#f_" + uid).attr("class", "addfollow");
				$("#f_" + uid).text('加关注');
                                //alert($("#fllow_count").text());
                                $("#fllow_count").text(parseInt($("#fllow_count").text())-1)
			} else {
				return false;
			}
		}
	});
}
//投票
function voteyes(id, cm) {
	$('#voteyes'+id).css({color:"#aaa"}).html('谢谢投票');
	$.post("user/FllowAction!add_yes",{"id":id, "cm":cm},function(data) {
               
		$('#voteyes'+id).css('display','none');
		$('#voteyes'+id).css({color:"#aaa"}).html('可怜孩子 (' + data + ')').fadeIn();
	});
}
function voteno(id, cm) {
	$('#voteno'+id).css({color:"#aaa"}).html('谢谢投票');
	$.post("user/FllowAction!add_no",{"id":id,"cm":cm},function(data) {
                
		$('#voteno'+id).css('display','none');		
		$('#voteno'+id).css({color:"#aaa"}).html('呀！遗憾 (' + data + ')').fadeIn();
	});
}


function addtofav(info_id)
{
   
	$.post("user/FllowAction!addtofav",{"id":info_id}, function(data) {
               //alert(data)
		if (data == "NOT_LOGIN") {
			$('#fav_' + info_id).css('display','none');			
			$('#fav_' + info_id).fadeIn().html('<a href="NavigateAction?navFlag=login"><b>请先登录</b></a>');
		}else if(data == "ALREADY_ADDED") {
			$('#fav_' + info_id).css('display','none');			
			$('#fav_' + info_id).fadeIn().html('你已经收藏过该牢骚');
		} else if(data == "SUCCESSFULLY_ADDED") {
			$('#fav_' + info_id).css('display','none');			
			$('#fav_' + info_id).fadeIn().html('已加入收藏');
		} else {
			$('#fav_' + info_id).css('display','none');			
			$('#fav_' + info_id).fadeIn().html('服务器有点开小车了，请稍后再试');
		}
	});
}

function delFromFav(info_id) {
	if (confirm("确定从收藏夹中移除吗？")) {
		//$("#info_" + info_id).slideUp();
		
		$.ajax({
			type: "POST",
			url : "user/FllowAction!delFromFav",
			data: {"id":info_id},
			cache: false,
			success: function(data) {
				//alert(data);
				if (data == "NOT_LOGIN") {
					$('#info_' + info_id).css('display','none');			
					$('#info_' + info_id).fadeIn().html('<a href="NavigateAction?navFlag=login"><b>请先登录</b></a>');
				}else if (data == "NO_ADD") {
					$('#info_' + info_id).css('display','none');			
					$('#info_' + info_id).fadeIn().html('没有收藏过该牢骚');
				} else if(data == "ALREADY_DLETE"){
					$("#info_" + info_id).slideUp();
				}else {
					$('#info_' + info_id).css('display','none');			
					$('#info_' + info_id).fadeIn().html('服务器有点开小车了，请稍后再试');
				}
				
			}
		});
	}
}
 //http://v.t.sina.com.cn/share/share.php?url=http://caoegg.cn/view/55078&appkey=2495395889&ralateUid=1657779303

function postToWb(urlbase,url,id, content){
	var _t = content;
	//var _url = 'http://www.caoegg.cn/view/' + id;
	var _url = url;
	var _appkey = encodeURI("c3015768fdfd4590affb3953eff774f6");
	var _pic = encodeURI('');
	//var _site = 'http://www.caoegg.cn';
	var _site = urlbase;
	var _u = 'http://v.t.qq.com/share/share.php?title='+_t+'&url='+_url+'&appkey='+_appkey+'&site='+_site+'&pic='+_pic;
	window.open( _u,'', 'width=700, height=680, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no' );
}
//分享 &title=&pic=&ralateUid=1756781753
function share(id, content) {
	document.write("<a title=\"分享到人人网\" href=\"javascript:void(function(){var d=document,e=encodeURIComponent,r='http://share.xiaonei.com/share/buttonshare.do?link='+e('http://www.caoegg.cn/view/" + id + "')+'&title='+e('分享我们的草蛋日子！'),x=function(){if(!window.open(r,'xnshare','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r+'&r=1'};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()\"  ><img  align=\"absmiddle\" src=\"/images/renren.jpg\" width=\"16\" height=\"16\" border=\"0\" ALT=\"分享到人人网\"></a> <a style=\"color:#333333;text-align:center;font-size:12px;\" href=\"javascript:void((function(s,d,e){try{}catch(e){}var f='http://v.t.sina.com.cn/share/share.php?',u=d.location.href,p=['url=',e('http://www.caoegg.cn/view/" + id + "'),'&title=" + content + "&appkey=2495395889&ralateUid=1657779303'].join('');function a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=620,height=450,left=',(s.width-620)/2,',top=',(s.height-450)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent)){setTimeout(a,0)}else{a()}})(screen,document,encodeURIComponent));\" title=\"分享到新浪微博\"><img src=\"/images/sina.jpg\" style=\"border:0;cursor:pointer;\" align=\"absmiddle\" alt=\"分享到新浪微博\" /></a>");
	document.write('<a href="javascript:void(0)" onclick="postToWb(' + id + ',\'' + content + '\');" style="height:16px;font-size:12px;line-height:16px;"><img src="/images/qq.jpg" align="absmiddle"/></a>');
}
(function($) {
	$.fn.jrumble = function(s) {
		var t = {
			rangeX: 2,
			rangeY: 2,
			rangeRot: 1,
			rumbleSpeed: 10,
			rumbleEvent: 'hover',
			posX: 'left',
			posY: 'top'
		};
		var u = $.extend(t, s);
		return this.each(function() {
			$obj = $(this);
			var f;
			var g = u.rangeX;
			var h = u.rangeY;
			var i = u.rangeRot;
			g = g * 2;
			h = h * 2;
			i = i * 2;
			var j = u.rumbleSpeed;
			var k = $obj.css('position');
			var l = u.posX;
			var m = u.posY;
			var n;
			var o;
			var p;
			if (l === 'left') {
				n = parseInt($obj.css('left'), 10)
			}
			if (l === 'right') {
				n = parseInt($obj.css('right'), 10)
			}
			if (m === 'top') {
				o = parseInt($obj.css('top'), 10)
			}
			if (m === 'bottom') {
				o = parseInt($obj.css('bottom'), 10)
			}
			function rumbler(a) {
				var b = Math.random();
				var c = Math.floor(Math.random() * (g + 1)) - g / 2;
				var d = Math.floor(Math.random() * (h + 1)) - h / 2;
				var e = Math.floor(Math.random() * (i + 1)) - i / 2;
				if (a.css('display') === 'inline') {
					p = true;
					a.css('display', 'inline-block')
				}
				if (c === 0 && g !== 0) {
					if (b < .5) {
						c = 1
					} else {
						c = -1
					}
				}
				if (d === 0 && h !== 0) {
					if (b < .5) {
						d = 1
					} else {
						d = -1
					}
				}
				if (k === 'absolute') {
					a.css({
						'position': 'absolute',
						'-webkit-transform': 'rotate(' + e + 'deg)',
						'-moz-transform': 'rotate(' + e + 'deg)',
						'-o-transform': 'rotate(' + e + 'deg)',
						'transform': 'rotate(' + e + 'deg)'
					});
					a.css(l, n + c + 'px');
					a.css(m, o + d + 'px')
				}
				if (k === 'fixed') {
					a.css({
						'position': 'fixed',
						'-webkit-transform': 'rotate(' + e + 'deg)',
						'-moz-transform': 'rotate(' + e + 'deg)',
						'-o-transform': 'rotate(' + e + 'deg)',
						'transform': 'rotate(' + e + 'deg)'
					});
					a.css(l, n + c + 'px');
					a.css(m, o + d + 'px')
				}
				if (k === 'static' || k === 'relative') {
					a.css({
						'position': 'relative',
						'-webkit-transform': 'rotate(' + e + 'deg)',
						'-moz-transform': 'rotate(' + e + 'deg)',
						'-o-transform': 'rotate(' + e + 'deg)',
						'transform': 'rotate(' + e + 'deg)'
					});
					a.css(l, c + 'px');
					a.css(m, d + 'px')
				}
			}
			var q = {
				'position': k,
				'-webkit-transform': 'rotate(0deg)',
				'-moz-transform': 'rotate(0deg)',
				'-o-transform': 'rotate(0deg)',
				'transform': 'rotate(0deg)'
			};
			if (u.rumbleEvent === 'hover') {
				$obj.hover(function() {
					var a = $(this);
					f = setInterval(function() {
						rumbler(a)
					},
					j)
				},
				function() {
					var a = $(this);
					clearInterval(f);
					a.css(q);
					a.css(l, n + 'px');
					a.css(m, o + 'px');
					if (p === true) {
						a.css('display', 'inline')
					}
				})
			}
			if (u.rumbleEvent === 'click') {
				$obj.toggle(function() {
					var a = $(this);
					f = setInterval(function() {
						rumbler(a)
					},
					j)
				},
				function() {
					var a = $(this);
					clearInterval(f);
					a.css(q);
					a.css(l, n + 'px');
					a.css(m, o + 'px');
					if (p === true) {
						a.css('display', 'inline')
					}
				})
			}
			if (u.rumbleEvent === 'mousedown') {
				$obj.bind({
					mousedown: function() {
						var a = $(this);
						f = setInterval(function() {
							rumbler(a)
						},
						j)
					},
					mouseup: function() {
						var a = $(this);
						clearInterval(f);
						a.css(q);
						a.css(l, n + 'px');
						a.css(m, o + 'px');
						if (p === true) {
							a.css('display', 'inline')
						}
					},
					mouseout: function() {
						var a = $(this);
						clearInterval(f);
						a.css(q);
						a.css(l, n + 'px');
						a.css(m, o + 'px');
						if (p === true) {
							a.css('display', 'inline')
						}
					}
				})
			}
			if (u.rumbleEvent === 'constant') {
				var r = $(this);
				f = setInterval(function() {
					rumbler(r)
				},
				j)
			}
		})
	}
})
(jQuery);

window.onerror = function(){return true;}