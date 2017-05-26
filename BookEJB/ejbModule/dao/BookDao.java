package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.SearchBook;
import entity.TBookinfo;


/**
 * Session Bean implementation class BookDao
 */
@Stateless
@LocalBean
public class BookDao {

	@PersistenceContext(unitName = "BookEJB")
	private EntityManager em;
	
    public BookDao() {
        // TODO Auto-generated constructor stub
    }

	public List<TBookinfo> findTBookinfos() {
		TypedQuery<TBookinfo> query = em.createNamedQuery("findAllbooks", TBookinfo.class);
		return query.getResultList();
	}

	public TBookinfo findTBookinfoById(Integer id) {
		return em.find(TBookinfo.class, id);
	}

	public TBookinfo addTBookinfo(TBookinfo TBookinfo) {
		em.persist(TBookinfo);
		return TBookinfo;
	}

	public void deleteTBookinfo(TBookinfo TBookinfo) {
		em.remove(em.merge(TBookinfo));
	}

	public TBookinfo editTBookinfo(TBookinfo TBookinfo) {
		return em.merge(TBookinfo);
	}
	//��ȡȫ����¼��
	public int getRowCount() {
		Query query = em.createQuery("SELECT COUNT(s) FROM TBookinfo s");
		int result = Integer.parseInt(query.getSingleResult().toString());
		System.err.println(result);
		return result;
	}
	
	//��ȡͼ��
	public List<TBookinfo> getBookList(int startPosition, int maxResult) {
		System.out.println("=======");
		Query query = em.createQuery("SELECT t FROM TBookinfo t");
		query.setFirstResult(startPosition).setMaxResults(maxResult);
		@SuppressWarnings("unchecked")
		List<TBookinfo> result = query.getResultList();
		System.out.println(result.size());
		return result;
	}
	
	public List<TBookinfo> search(SearchBook sbook){
		StringBuffer sql = new StringBuffer("select * from T_Bookinfo where 1=1");
		//ƴ�Ӳ�ѯ���
		//��isbn��Ų�ѯ
		if(null!=sbook.getSearchISBN()&&!"".equals(sbook.getSearchISBN())){
			sql.append(" and isbn13 = '").append(sbook.getSearchISBN()).append("'");
			System.out.println("���isbn" + sql.toString());
		}
		//�����ֲ�ѯ
		if(null!=sbook.getSearchTitle()&&!"".equals(sbook.getSearchTitle())){
			sql.append(" and title like ").append("'%")
				.append(sbook.getSearchTitle()).append("%'");
			System.out.println("��ӱ���" + sql.toString());
		}
		//�����߲�ѯ
		if(null!=sbook.getSearchAuthor()&&!"".equals(sbook.getSearchAuthor())){
			sql.append(" and author like ").append("'%")
				.append(sbook.getSearchAuthor()).append("%'");
			System.out.println("�������" + sql.toString());
		}
		
		//���۸��ѯ
		if(Double.parseDouble(sbook.getSearchminPrice())>0 &&!"".equals(sbook.getSearchminPrice())){
			sql.append(" and price >='").append(sbook.getSearchminPrice()).append("'");
		}
		if(Double.parseDouble(sbook.getSearchmaxPrice())>0 &&!"".equals(sbook.getSearchmaxPrice())){
			sql.append(" and price <='").append(sbook.getSearchmaxPrice()).append("'");
		}
		System.out.println(sql.toString());
		Query query = em .createNativeQuery(sql.toString(),TBookinfo.class);
		@SuppressWarnings("unchecked")
		List<TBookinfo> result = query.getResultList();
		return result;
	}

}
