package com.tom.cpm.shared.loaders;

import java.io.IOException;
import java.net.URL;

/**
 * AIHMC 专用资源加载器
 * 适配域名: cpm.aihoss.top
 */
public class AIHMCResourceLoader extends HttpResourceLoader {

	@Override
	protected URL createURL(String path) throws IOException {
		// 假设传入的 path 已经是 year/month/day/uuid 格式
		return new URL("https://4d.aihoss.top/" + path);
	}

	@Override
	public Validator getValidator() {
		return new Validator(
				"AIHMC",
				"4d.aihoss.top",
				// 正则匹配: https://4d.aihoss.top/2026/01/07/32位字符
				"https\\:\\/\\/4d\\.aihoss\\.top\\/(\\d{4}\\/\\d{2}\\/\\d{2}\\/[a-zA-Z0-9]{32})",
				"aihmc:$1",
				"https://4d.aihoss.top/<year>/<month>/<day>/<id>");
	}
}