package miniproject;

import java.time.LocalDate;
import java.time.LocalTime;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
	         tx.begin();

	         // ������
	         Manager manager = new Manager();
	         manager.setName("������");
	         manager.setPassword("12345");
	         manager.setPhoneNumber("010-1234-5678");
	         manager.setWorkPeriod(new Period(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
	         Boolean MisWork = manager.getWorkPeriod().isWork(LocalDate.now());
	         System.out.println("==== Manager isWork : " + MisWork);
	         em.persist(manager);

	         // ������ ����
	         Account Maccount = new Account("����", "32141235432", 100000);
	         Maccount.setUser(manager);
	         em.persist(Maccount);

	         // ����1
	         List<Staff> staffs1 = new ArrayList<Staff>(); /// yeom
	         Staff staff = new Staff();
	         staff.setName("����1");
	         staff.setPassword("54321");
	         staff.setPhoneNumber("010-1111-1111");
	         staff.setWorkPeriod(new Period(LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 31)));
	         Boolean SisWork = staff.getWorkPeriod().isWork(LocalDate.now());
	         System.out.println("==== Staff isWork : " + SisWork);
	         em.persist(staff);

	         // ����1 ����
	         Account Saccount1 = new Account("����", "454132454355", 100000);
	         Saccount1.setUser(staff);
	         em.persist(Saccount1);

	         // ��ȭ�� ���
	         Theater theater = manager.registerTheater("���̿�ȭ��", staffs1); /// yeom
	         staff.setTheater(theater); /// yeom
	         staffs1.add(staff); /// yeom
	         theater.setTotalStaff(staffs1); /// yeom
	         em.persist(theater);

	         /// yeom
	         // ��ȭ1
	         Movie movie1 = new Movie(manager, "��Ʈ��", "��Ʈ�� ����", LocalDate.of(2020, 11, 20));
	         movie1.setStory("�θǽ�");
	         em.persist(movie1);
	         Statistics statistics = new Statistics();
	         movie1.setStatistics(statistics);
	         em.persist(statistics);

	         // ��ȭ1 ������
	         List<MovieSchedule> mss1 = new ArrayList<MovieSchedule>();
	         MovieSchedule movieschedule1 = manager.registerMovieSchedule(mss1, movie1, LocalTime.of(16, 30),
	               LocalTime.of(19, 15));
	         MovieSchedule movieschedule2 = manager.registerMovieSchedule(mss1, movie1, LocalTime.of(19, 30),
	               LocalTime.of(22, 15));
	         em.persist(movieschedule1);
	         em.persist(movieschedule2);
	         ///

	         // �󿵰� ��� - 1��
	         ScreenHall screenhall1 = manager.registerScreenHall(theater, "�󿵰�1", "�󿵰�1 �Դϴ�.");
	         screenhall1.setMs(mss1); // ms - screenhall ����
	         em.persist(screenhall1);


	         // �¼� ��� - 10��
	         Seat seat1 = new Seat("A1");
	         Seat seat2 = new Seat("A2");
	         Seat seat3 = new Seat("A3");
	         Seat seat4 = new Seat("A4");
	         Seat seat5 = new Seat("A5");
	         Seat seat6 = new Seat("A6");
	         Seat seat7 = new Seat("A7");
	         Seat seat8 = new Seat("A8");
	         Seat seat9 = new Seat("A9");
	         Seat seat10 = new Seat("A10");
	         seat1.setScreenhall(screenhall1);
	         seat2.setScreenhall(screenhall1);
	         seat3.setScreenhall(screenhall1);
	         seat4.setScreenhall(screenhall1);
	         seat5.setScreenhall(screenhall1);
	         seat6.setScreenhall(screenhall1);
	         seat7.setScreenhall(screenhall1);
	         seat8.setScreenhall(screenhall1);
	         seat9.setScreenhall(screenhall1);
	         seat10.setScreenhall(screenhall1);
	         em.persist(seat1);
	         em.persist(seat2);
	         em.persist(seat3);
	         em.persist(seat4);
	         em.persist(seat5);
	         em.persist(seat6);
	         em.persist(seat7);
	         em.persist(seat8);
	         em.persist(seat9);
	         em.persist(seat10);

	         // ��
	         // if (MisWork && SisWork)
	         Client client = new Client();
	         client.setRpn("991125-*******");
	         client.setEmail("wldms01125@kumoh.ac.kr");
	         client.setName("õ����");
	         client.setPassword("5781");
	         client.setPhoneNumber("010-8645-1131");
	         em.persist(client);

	         // ������
	         Account Caccount1 = new Account("īī������", "78544521354", 100000);
	         Caccount1.setUser(client);
	         em.persist(Caccount1);

	         // System.out.println("====== seat: "+seat1.getRs().size());

	         // ����1 - 3�ڸ�
	         Reservation reservation1 = new Reservation(Type.����, 2, Type.���, 1);
	         reservation1.setUser(client);
	         reservation1.setMs(movieschedule1);
	         em.persist(reservation1);
	         ReservationSeat rs1 = new ReservationSeat();
	         rs1.setReservation(reservation1);
	         rs1.setSeat(seat5);
	         em.persist(rs1);
	         ReservationSeat rs2 = new ReservationSeat();
	         rs2.setReservation(reservation1);
	         rs2.setSeat(seat6);
	         em.persist(rs2);
	         ReservationSeat rs3 = new ReservationSeat();
	         rs3.setReservation(reservation1);
	         rs3.setSeat(seat7);
	         em.persist(rs3);
	         

	         // ���� ù��° ���·� ���
	         Billing billing1 = client.pay(theater, reservation1, client.getAccount().get(0));
	         em.persist(billing1);

	         // ����2 - 1�ڸ�
	         Reservation reservation2 = new Reservation(Type.û�ҳ�, 1);
	         reservation2.setUser(client);
	         reservation2.setMs(movieschedule1);
	         em.persist(reservation2);
	         ReservationSeat rs4 = new ReservationSeat();
	         rs4.setReservation(reservation2);
	         rs4.setSeat(seat8);
	         em.persist(rs4);

	         // ���� ù��° ���·� ���
	         Billing billing2 = client.pay(theater, reservation2, client.getAccount().get(0));
	         em.persist(billing2);
	         
	         em.flush();
	         em.clear();

			
			System.out.println("=========== ��1�� ����1 ���� ===========");
			System.out.println("������ : "+client.getReservation().get(0).getReserveDate());
			System.out.print("�����¼� : ");
			for (int i=0;i<client.getReservation().get(0).getSeatNum();i++)
				System.out.print(client.getReservation().get(0).getRs().get(i).getSeat().getName()+" ");
			System.out.println();
			System.out.println("�󿵰� : "+client.getReservation().get(0).getRs().get(0).getSeat().getScreenhall().getName());
//			System.out.println("�󿵿�ȭ : "+client.getReservation().get(0).getRs().get(0).getMs().getMovie().getName());
//			System.out.println("�󿵽ð� : "+client.getReservation().get(0).getRs().get(0).getMs().getStartTime()+" ~ "+client.getReservation().get(0).getRs().get(0).getMs().getEndTime());
			
			
			
			//System.out.println("��1�� ����2 ���� : "+client.getReservation().get(1));

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}