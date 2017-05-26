package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TUser;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
@LocalBean
public class UserDao {

	@PersistenceContext(unitName = "BookEJB")
	private EntityManager em;
    public UserDao() {
        // TODO Auto-generated constructor stub
    }
    
	
	//����id���û�
    public TUser getById (String userid){
		return em.find(TUser.class, userid);
    }
    //�����û�
	public TUser add(TUser user) {
		em.persist(user);
		return user;
	}
	//�����û�
	public TUser editUser(TUser user) {
		return em.merge(user);
	}

}
