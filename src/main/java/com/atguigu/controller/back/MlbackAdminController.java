package com.atguigu.controller.back;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.MlbackAdminService;

@Controller
@RequestMapping("/MlbackAdmin")
public class MlbackAdminController {
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0
	 * @author zsh
	 * @param MlbackAdmin
	 * @exception 管理员帐号推出
	 * 20200428
	 * */
	@RequestMapping("/exitIndex")
	public String exitindex(HttpSession session) throws Exception{
		session.removeAttribute(Const.ADMIN_USER);
		session.invalidate();
		return "back/mlbackAdminLogin";
	}
	
	
	/**
	 * 1.0
	 * @author zsh
	 * @param MlbackAdmin
	 * @exception 管理员帐号推出
	 * 20200428
	 * */
	@RequestMapping("/tologin")
	public String tologin(HttpSession session) throws Exception{
		return "back/mlbackAdminLogin";
	}
	
	/**
	 * 2.0
	 * @author zsh
	 * @param MlbackAdmin
	 * @exception 管理员帐号登陆
	 * 20200428
	 * */
	@RequestMapping(value="/CheakAdminUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkuser(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MlbackAdmin MlbackAdminReq){
		//接收参数信息 
		MlbackAdmin mlbackAdminGet = new MlbackAdmin();
		mlbackAdminGet.setAdminAccname(MlbackAdminReq.getAdminAccname());
		List<MlbackAdmin> mlbackAdminGetresList = mlbackAdminService.selectMlbackAdmin(mlbackAdminGet);
		if(!(mlbackAdminGetresList.size()>0)){
			return Msg.fail().add("resMsg", "账号不存在");
		}
		mlbackAdminGet.setAdminPassword(MlbackAdminReq.getAdminPassword());
		List<MlbackAdmin> MlbackAdminListNameAndPwd = mlbackAdminService.selectMlbackAdmin(mlbackAdminGet);
		if(MlbackAdminListNameAndPwd.size()>0){
			//将登陆状态放入session对象
			session.setAttribute(Const.ADMIN_USER, mlbackAdminGet);
			return Msg.success().add("resMsg", "登陆成功");
		}else{
			return Msg.fail().add("resMsg", "密码错误登录失败");
		}
	}
	
}
