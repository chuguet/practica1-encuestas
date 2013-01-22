var cookie = {
	'set' : function(c_device, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
		document.cookie = c_device + "=" + c_value;
	},
	'get' : function(c_name) {
		var i, x, y, ARRcookies = document.cookie.split(";");
		for(i = 0; i < ARRcookies.length; i++) {
			x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
			y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
			x = x.replace(/^\s+|\s+$/g, "");
			if (x == c_name) {
				return unescape(y);
			}
		}
	},
	'check' : function(GUID) {
		var device = this.get("device");
		if (device == null || device == "") {
			device = GUID;
			if (device != null && device != "") {
				this.set("device", device, 365);
			}
		}
	}
};
