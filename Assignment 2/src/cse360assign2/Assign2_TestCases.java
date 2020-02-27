package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assign2_TestCases {

	@Test
	void testArrayInstantiation() {
		SimpleList list = new SimpleList();
		assertEquals(0, list.count());
	}
	
	@Test
	void testAdd() {
		SimpleList list = new SimpleList();
		list.add(3);
		list.add(2);
		list.add(1);
		assertEquals(3, list.count());
	}
	
	@Test
	void testSearch() {
		SimpleList list = new SimpleList();
		list.add(3);
		assertEquals(0, list.search(3));
	}
	
	@Test
	void testRemove() {
		SimpleList list = new SimpleList();
		list.add(3);
		list.remove(3);
		assertEquals(0, list.count());
	}
	
	@Test
	void testToString() {
		SimpleList list = new SimpleList();
		list.add(-1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		String out = list.toString();
		assertEquals("5 4 3 2 1 -1", out);
	}
	
	@Test
	void testAddPushOffArray() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		String out = list.toString();
		assertEquals("14 13 12 11 10 9 8 7 6 5 4 3 2 1", out);
	}
	
	@Test
	void testAppend() {
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);
		list.append(10);
		list.append(11);
		list.append(12);
		list.append(13);
		list.append(14);
		String out = list.toString();
		assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14", out);
	}
	
	@Test
	void testFirst() {
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		list.append(3);
		assertEquals(1, list.first());
	}
	
	@Test
	void testSize() {
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);
		list.append(10);
		assertEquals(10, list.size());
	}
	
	@Test
	void testRemoveTruncate() {
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);
		list.append(10);
		//10*.25 = 2.5, so removing 3 should get a truncate
		list.remove(10);
		list.remove(9);
		list.remove(8);
		assertEquals(7,list.size());
	}
	
	@Test
	void testSearchFail() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(-1, list.search(42));
	}

}
