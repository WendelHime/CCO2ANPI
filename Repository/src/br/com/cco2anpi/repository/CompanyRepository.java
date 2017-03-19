/**
 * 
 */
package br.com.cco2anpi.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.cco2anpi.models.Company;
import br.com.cco2anpi.models.ICompany;

/**
 * @author wotan Company repository
 */
public class CompanyRepository extends BaseRepository implements ICompanyRepository {

	/**
	 * Constructor of the repository
	 * 
	 * @param context
	 */
	public CompanyRepository(String context) {
		super(context);
	}

	/**
	 * Method used to insert company
	 * 
	 * @param company
	 *            to be inserted
	 * @return company inserted
	 */
	public ICompany insert(ICompany company) {
		Session session = getSessionFactory().openSession();
		Serializable id = session.save(new br.com.cco2anpi.database.Company(company));
		ICompany temp = session.get(br.com.cco2anpi.database.Company.class, id);
		session.close();
		close();
		close();
		return new Company(temp);
	}

	/**
	 * Method to update company
	 * 
	 * @param company
	 *            to be updated
	 * @return company updated
	 */
	public ICompany update(ICompany company) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(new br.com.cco2anpi.database.Company(company));
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		}
		session.close();
		close();
		return company;
	}

	/**
	 * Method used to delete company
	 * 
	 * @param company
	 *            to be deleted
	 * @return status
	 */
	public boolean delete(ICompany company) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		boolean status = false;
		try {
			session.delete(new br.com.cco2anpi.database.Company(company));
			transaction.commit();
			status = true;
		} catch (Exception ex) {
			transaction.rollback();
		}
		session.close();
		close();
		return status;
	}

	/**
	 * Method used to get company by id
	 * 
	 * @param id
	 *            of the company
	 * @return company if exists
	 */
	public ICompany getCompany(Integer id) {
		Session session = getSessionFactory().openSession();
		Company company = new Company(session.find(br.com.cco2anpi.database.Company.class, id));
		session.close();
		close();
		return company;
	}

	/**
	 * Method used to get all companies
	 * 
	 * @param pageSize
	 *            quantity of objects
	 * @param offset
	 *            quantity offset
	 * @return array of the companies
	 */
	public HashMap<String, Object> getAllCompanies(int pageSize, int offset) {
		HashMap<String, Object> returnedValues = new HashMap<>();
		Session session = getSessionFactory().openSession();
		Query<br.com.cco2anpi.database.Company> query = session.createQuery("from Company",
				br.com.cco2anpi.database.Company.class);
		returnedValues.put("total", new Integer(query.getResultList().size()));
		List<br.com.cco2anpi.database.Company> companyList = query.setMaxResults(pageSize).setFirstResult(offset)
				.getResultList();
		ArrayList<ICompany> companies = new ArrayList<>(companyList);

		session.close();
		close();

		returnedValues.put("companies", companies);
		return returnedValues;
	}
}
