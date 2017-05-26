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

	// ��½
	public String login() {
		TUser user = userDao.getById(userid);
		if (user != null && pwd.equals(user.getPwd())) {
			// ��ת
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
			msg = "�û������ڻ�����Ϊ����";
			System.out.println("�û������ڻ�����Ϊ����");
			return null;
		}
	}
	//��ȡrequst
	private Object getRequestObject() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		return context.getRequest();
	}

	// ע��
	public String regist() {
		TUser user = new TUser(userid, pwd);
		if (null == userDao.getById(userid)) {
			if (pwd.equals(confirmpwd)) {
				userDao.add(user);
				return "login.xhtml";
			} else {
				msgRegist = "�������벻һ��";
				return null;
			}
		}else{
			msgRegist = "���˺��Ѵ���";
			return null;
		}
	}
	
	public TUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(TUser currentUser) {
		this.currentUser = currentUser;
	}

	//�޸�����
	public void changepwd(){
		System.err.println(currentUser);
		if(pwd.equals(currentUser.getPwd())){
			currentUser.setPwd(newpwd);
			userDao.editUser(currentUser);
			msg = "�����޸ĳɹ�";
		}else{
			msg = "���������������";
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
