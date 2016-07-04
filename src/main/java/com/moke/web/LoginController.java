package com.moke.web;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public String login(String username, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			logger.info("Authentication start ...");
			currentUser.login(token);
			logger.info("Authentication pass");
		} catch (UnknownAccountException uae) {
			logger.info("UnknownAccountException");
		} catch (IncorrectCredentialsException ice) {
			logger.info("IncorrectCredentialsException");
		} catch (LockedAccountException lae) {
			logger.info("LockedAccountException");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("ExcessiveAttemptsException");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("AuthenticationException");
			ae.printStackTrace();
			// redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			logger.info("user authentiocated ...");
			return "user authentiocated";
		} else {
			token.clear();
			return "user not authentiocated";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout(RedirectAttributes redirectAttributes) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("message", "您已安全退出");
		return "logout success";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		logger.info("------没有权限-------");
		return "403";
	}

	@RequestMapping("/user")
	@ResponseBody
	public String getUserList(Map<String, Object> model) {
//		model.put("userList", userDao.getList());
		return "user";
	}

	@RequestMapping("/user/edit/{userid}")
	@ResponseBody
	public String getUserList(@PathVariable int userid) {
		logger.info("------进入用户信息修改-------");
		return "user_edit";
	}
}
