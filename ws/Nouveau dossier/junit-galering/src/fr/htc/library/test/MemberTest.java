package fr.htc.library.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.htc.library.main.Member;

public class MemberTest {
	private final String fn = "Djamel";
	private final String ln = "MOUCHENE";
	private final String expectedMat = "DM100";
	private Member member;
	
	
	@Before
	public void pub() {
		// TODO Auto-generated method stub
		System.out.println("before");
	}
	@After
	public void pub2() {
		// TODO Auto-generated method stub
		System.out.println("After");
	}
	
	

	@Test
	public final void testMemberStringString() {
		 member = new Member(fn, ln);
			
		 assertNotNull("should not be null", member);
		 assertEquals("", fn, member.getFirstName());
		 assertEquals("", ln, member.getLastName());
		 assertEquals("", expectedMat, member.getMatricule());
		 
		 Member member1 = new Member(fn, ln);
		 assertTrue("Should increment the matricule", member1.getMatricule().endsWith("101"));
		 
		 
		 
		
	}

}
