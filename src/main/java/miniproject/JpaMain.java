package miniproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class Type {
	static Integer 성인 = 9000;
	static Integer 청소년 = 8000;
	static Integer 어린이 = 6000;
}

public class JpaMain {
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Theater-System");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			//관리자
			Manager manager = new Manager();
			manager.setName("관리자");
			manager.setPassword("12345");
			manager.setPhoneNumber("010-1234-5678");
			manager.setWorkPeriod(new Period(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
			Boolean MisWork = manager.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Manager isWork : "+ MisWork);
			em.persist(manager);
			
			//관리자 계좌
			Account Maccount = new Account("농협","32141235432",100000);
			Maccount.setUser(manager);
			em.persist(Maccount);
			
			
			//직원1
			Staff staff = new Staff();
			staff.setName("직원1");
			staff.setPassword("54321");
			staff.setPhoneNumber("010-1111-1111");
			staff.setWorkPeriod(new Period(LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 31)));
			Boolean SisWork = staff.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Staff isWork : "+ SisWork);
			em.persist(staff);
			
			//직원1 계좌
			Account Saccount1 = new Account("국민","454132454355",100000);
			Saccount1.setUser(staff);
			em.persist(Saccount1);
			
			
			// 영화관 등록
			Theater theater = manager.registerTheater("구미영화관", staffs1); /// yeom
			staff.setTheater(theater); /// yeom
			staffs1.add(staff); /// yeom
			theater.setStaffs(staffs1); /// yeom
			theater.setTotalStaff(staffs1); /// yeom
			em.persist(theater);
			
			///////// yeom
			// 영화1
			Movie movie1 = new Movie(manager, "노트북", "노트북 감독", LocalDate.of(2020, 11, 20));
			movie1.setStory("로맨스");
			em.persist(movie1);
			
			// 영화1 스케줄
			List<MovieSchedule> mss1 = new ArrayList<MovieSchedule>();
			MovieSchedule movieschedule1 = manager.registerMovieSchedule(mss1, movie1, LocalTime.of(16, 30), LocalTime.of(19, 15));
			MovieSchedule movieschedule2 = manager.registerMovieSchedule(mss1, movie1, LocalTime.of(19, 30), LocalTime.of(22, 15));
			em.persist(movieschedule1);
			em.persist(movieschedule2);
			/////////
			
			// 상영관 등록 - 1개
			ScreenHall screenhall1 = manager.registerScreenHall(theater, "상영관1","상영관1 입니다.");
			em.persist(screenhall1);
			
			// 좌석 등록 - 10개
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
			em.persist(seat1);em.persist(seat2);em.persist(seat3);em.persist(seat4);em.persist(seat5);
			em.persist(seat6);em.persist(seat7);em.persist(seat8);em.persist(seat9);em.persist(seat10);

			
			//고객
			//if (MisWork && SisWork)
			Client client = new Client();
			client.setRpn("991125-*******");
			client.setEmail("wldms01125@kumoh.ac.kr");
			client.setName("천지은");
			client.setPassword("5781");
			client.setPhoneNumber("010-8645-1131");
			em.persist(client);
			
			//고객계좌
			Account Caccount1 = new Account("카카오페이","78544521354",100000);
			Caccount1.setUser(client);
			em.persist(Caccount1);
			


			//System.out.println("====== seat: "+seat1.getRs().size());
			
			// 예매1 - 3자리
			Reservation reservation1 = new Reservation(Type.성인, 2, Type.어린이, 1);
			reservation1.setUser(client);
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
			
			// 가장 첫번째 계좌로 계산
			Billing billing1 = client.pay(theater, reservation1, client.getAccount().get(0));
			em.persist(billing1);
			
			
			
			
			// 예매2 - 1자리
			Reservation reservation2 = new Reservation(Type.청소년, 1);
			reservation2.setUser(client);
			em.persist(reservation2);
			ReservationSeat rs4 = new ReservationSeat();
			rs4.setReservation(reservation2);
			rs4.setSeat(seat8);
			em.persist(rs4);
	
			// 가장 첫번째 계좌로 계산
			Billing billing2 = client.pay(theater, reservation2, client.getAccount().get(0));
			em.persist(billing2);
			

			
			

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
