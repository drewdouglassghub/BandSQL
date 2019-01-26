package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BandMember;

public class BandMemberHelper {

	static	EntityManagerFactory emfactory	=	
			Persistence.createEntityManagerFactory("BandSQL");
	
	public void insertItem(BandMember bm) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bm);
		em.getTransaction().commit();
		em.close();
		
	}
		
		public List<BandMember> showAllItems() {
			EntityManager em = emfactory.createEntityManager();
			List<BandMember> allItems = em.createQuery("SELECT i FROM BandMember i").getResultList();
			return allItems;
		}

		public void deleteItem(BandMember toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery(
					"select bm from BandMember bm where bm.name = :selectedName and bm.instrument = :selectedInstrument",
					BandMember.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedName", toDelete.getName());
			typedQuery.setParameter("selectedInstrument", toDelete.getInstrument());

			// we only want one result
			typedQuery.setMaxResults(1);

			// get the result and save it into a new list item
			BandMember result = typedQuery.getSingleResult();

			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();

		}

		public BandMember searchForMemberById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			BandMember found = em.find(BandMember.class, idToEdit);
			em.close();
			return found;
		}

		public void updateItem(BandMember toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

		public List<BandMember> searchForMemberByName(String memberName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery("select bm from ListItem bm where bm.store = :selectedStore", BandMember.class);
			typedQuery.setParameter("selectedName", memberName);

			List<BandMember> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		public List<BandMember> searchForMemberByInstrument(String instrumentName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", BandMember.class);
			typedQuery.setParameter("selectedInstrument", instrumentName);

			List<BandMember> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public void cleanUp(){
			emfactory.close();
		
	}
	
	
}
