package LinkedList_A1;

/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel = new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }
  
  public void clear() {
	  sentinel.next = sentinel;
	  sentinel.prev = sentinel;
	  numelms = 0;
	  
  }
  
  int numelms = 0;
  
  public int size() {
	  return numelms;
  }
  
  public boolean isEmpty() {
	  if (numelms == 0) {
		  return true;
	  } 
	  return false;
  }
  
  public boolean insert(double elt, int index) {
	  Node xyz = sentinel.next;
	  Node abc = new Node(elt);
	  Node omg = sentinel;
	  if (index > this.size()) {
		  return false;
	  } 
	  if (index < 0) {
		  return false;
	  }
	  if (numelms == 0) {
		  omg.next = abc;
		  abc.next = omg;
		  omg.prev = abc;
		  abc.prev = omg;
		  numelms++;
		  return true;
	  }
	  for (int i = 0; i < (numelms + 1); i++) {
		  if (index == i) {
			 abc.prev = xyz.prev;
			 abc.next = xyz;
			 xyz.prev = abc;
			 omg.next = abc;
			 numelms++;
			 return true;
		  } else {
			  omg = xyz;
			  xyz = omg.next;
		  }
	  }
	  return false;
  }
  
  public boolean remove(int index) {
	  Node xyz = sentinel.next;
	  Node abc = sentinel;
	  Node omg = sentinel.next.next;
	  if (index > this.size()) {
		  return false;
	  } else if (index < 0) {
		  return false;
	  }
	  for (int i = 0; i < (this.size() + 1); i++) {
		  if (index == i) {
			abc.next = omg;
			omg.prev = abc;
			xyz.next = null;
			xyz.prev = null;
			numelms--;
			return true;
		  } else {
			abc = xyz;
			xyz = omg;
			omg = xyz.next;
		  }
	  }
	  return false;
  }
  
  public double get(int index) {
	  Node xyz = sentinel.next;
	  if (index >= this.size()) {
		  return Double.NaN;
	  } else if (index < 0) {
		  return Double.NaN;
	  }
	  for (int i = 0; i < (this.size() + 1); i++) {
		  if (index == i) {
			  return xyz.data;
		  } else {
			  xyz = xyz.next;
		  }
	  }
	  return Double.NaN;
  }
 }
