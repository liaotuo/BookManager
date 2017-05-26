package bean;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import entity.TUser;

@ManagedBean
@ApplicationScoped
public class UserBean {
	@EJB
	UserDao userDao;
	private TUser currentUser;
	private String userid;
	private String pwd;
	private String confirmpwd;
	private String newpwd;
	private String msg;
	private String msgRegist;

	// 登陆
	public String login() {
		TUser user = userDao.getById(userid);
		if (user != null && pwd.equals(user.getPwd())) {
			// 跳转
			currentUser = user;
			userid = user.getUserid();
			
			Object requestObject = getRequestObject();
			if(!(requestObject instanceof HttpServletRequest)) {
				return null;
			}else{
				HttpServletRequest request = (HttpServletRequest) requestObject;
				request.getSession().setAttribute("userId", userid);
			}
			msg=null;
			return "index.xhtml";
		} else {
			msg = "用户不存在或密码为错误";
			System.out.println("用户不存在或密码为错误");
			return null;
		}
	}
	//获取requst
	private Object getRequestObject() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		return context.getRequest();
	}

	// 注册
	public String regist() {
		TUser user = new TUser(userid, pwd);
		if (null == userDao.getById(userid)) {
			if (pwd.equals(confirmpwd)) {
				userDao.add(user);
				return "login.xhtml";
			} else {
				msgRegist = "两次密码不一致";
				return null;
			}
		}else{
			msgRegist = "此账号已存在";
			return null;
		}
	}
	
	public TUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(TUser currentUser) {
		this.currentUser = currentUser;
	}

	//修改密码
	public void changepwd(){
		System.err.println(currentUser);
		if(pwd.equals(currentUser.getPwd())){
			currentUser.setPwd(newpwd);
			userDao.editUser(currentUser);
			msg = "密码修改成功";
		}else{
			msg = "旧密码错误，请重试";
		}
	}
	
	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String goToRegist(){
		return "regist.xhtml";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getConfirmpwd() {
		return confirmpwd;
	}

	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

	public String getMsgRegist() {
		return msgRegist;
	}

	public void setMsgRegist(String msgRegist) {
		this.msgRegist = msgRegist;
	}

	
}
