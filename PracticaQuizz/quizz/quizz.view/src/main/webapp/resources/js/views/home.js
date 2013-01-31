var home = {
	'init' : function(guuid, user, pwd) {
		var userCookie = $.cookie('usuario');
		var pwdCookie = $.cookie('pwd');
		var uuid = $.cookie('device');
		if (uuid == null || uuid == "") {
			$.cookie('device', guuid, {
				path : '/',
				expires : 365
			});
		}
		if (userCookie != null && userCookie != "" && pwdCookie != null && pwdCookie != "") {
			if ((user == null || user == "") && (pwd == null || pwd == "")) {
				window.location.href = "login";
			}
			else {
				$('body').css("display", "block");
			}
		}
		else {
			if (user != null && user != "" && pwd != null && pwd != "") {
				$.cookie('usuario', user, {
					path : '/',
					expires : 365
				});
				$.cookie('pwd', pwd, {
					path : '/',
					expires : 365
				});
			}
			$('body').css("display", "block");
		}
	},
	'logout' : function(uri) {
		$.removeCookie('usuario', null);
		$.removeCookie('pwd', null);
		window.location.href = uri;
	}
};