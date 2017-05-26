package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_user database table.
 * 
 */
@Entity
@Table(name="t_user")
@NamedQuery(name="TUser.findAll", query="SELECT t FROM TUser t")
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	private String pwd;

	public TUser() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "TUser [userid=" + userid + ", pwd=" + pwd + "]";
	}

	public TUser(String userid, String pwd) {
		super();
		this.userid = userid;
		this.pwd = pwd;
	}

	
	
}