package miniproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class Type {
	static Integer ���� = 9000;
	static Integer û�ҳ� = 8000;
	static Integer ��� = 6000;
}

public class JpaMain {
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Theater-System");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			//������
			Manager manager = new Manager();
			manager.setName("������");
			manager.setPassword("12345");
			manager.setPhoneNumber("010-1234-5678");
			manager.setWorkPeriod(new Period(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
			Boolean MisWork = manager.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Manager isWork : "+ MisWork);
			em.persist(manager);
			
			//������ ����
			Account Maccount = new Account("����","32141235432",100000);
			Maccount.setUser(manager);
			em.persist(Maccount);
			
			
			//����1
			Staff staff = new Staff();
			staff.setName("����1");
			staff.setPassword("54321");
			staff.setPhoneNumber("010-1111-1111");
			staff.setWorkPeriod(new Period(LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 31)));
			Boolean SisWork = staff.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Staff isWork : "+ SisWork);
			em.persist(staff);
			
			//����1 ����
			Account Saccount1 = new Account("����","454132454355",100000);
			Saccount1.setUser(staff);
			em.persist(Saccount1);
			
			
			// ��ȭ�� ���
			Theater theater = manager.registerTheater("���̿�ȭ��");
			em.persist(theater);
			
			// �󿵰� ��� - 1��
			ScreenHall screenhall1 = manager.registerScreenHall(theater, "�󿵰�1","�󿵰�1 �Դϴ�.");
			em.persist(screenhall1);
			
			// �¼� ��� - 10��
			Seat seat1 = screenhall1.registerSeat("A1");
			Seat seat2 = screenhall1.registerSeat("A2");
			Seat seat3 = screenhall1.registerSeat("A3");
			Seat seat4 = screenhall1.registerSeat("A4");
			Seat seat5 = screenhall1.registerSeat("A5");
			Seat seat6 = screenhall1.registerSeat("A6");
			Seat seat7 = screenhall1.registerSeat("A7");
			Seat seat8 = screenhall1.registerSeat("A8");
			Seat seat9 = screenhall1.registerSeat("A9");
			Seat seat10 = screenhall1.registerSeat("A10");
			em.persist(seat1);em.persist(seat2);em.persist(seat3);em.persist(seat4);em.persist(seat5);
			em.persist(seat6);em.persist(seat7);em.persist(seat8);em.persist(seat9);em.persist(seat10);

			
			//��
			//if (MisWork && SisWork)
			Client client = new Client();
			client.setRpn("991125-*******");
			client.setEmail("wldms01125@kumoh.ac.kr");
			client.setName("õ����");
			client.setPassword("5781");
			client.setPhoneNumber("010-8645-1131");
			em.persist(client);
			
			//������
			Account Caccount1 = new Account("īī������","78544521354",100000);
			Caccount1.setUser(client);
			em.persist(Caccount1);
			


			//System.out.println("====== seat: "+seat1.getRs().size());
			
			Reservation reservation1 = new Reservation(Type.����);
			reservation1.setUser(client);
			reservation1.setSeat(seat5);
			em.persist(reservation1);
			Reservation reservation2 = new Reservation(Type.û�ҳ�);
			reservation2.setUser(client);
			reservation2.setSeat(seat6);
			em.persist(reservation2);
			
			
			System.out.println("==== reservation count : "+client.getReservation().size());
			
			System.out.println("======: "+client.pay());
			
			Billing billing = new Billing(theater.getName(), client.pay());
			billing.setAccount(Caccount1);
			billing.check();
			reservation1.setBilling(billing);
			reservation2.setBilling(billing);
			em.persist(billing);
			

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}