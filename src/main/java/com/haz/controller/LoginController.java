package com.haz.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;
import com.haz.service.LoginService;
import com.haz.util.base.BaseController;

/**
 * 登录操作
 * 
 * @author aizhou.huang
 * @date 2018年7月31日
 */
@RestController
public class LoginController extends BaseController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private Producer producer;

	/**
	 * 获取验证码
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getCaptcha")
	public Map<String, Object> getCaptcha() throws Exception {
		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", outputStream);
		// 生成token
		Map<String, Object> map = loginService.createToken(text);
		// 对字节数组Base64编码
		map.put("img", new Base64().encode(outputStream.toByteArray()));
		return map;
	}
}
