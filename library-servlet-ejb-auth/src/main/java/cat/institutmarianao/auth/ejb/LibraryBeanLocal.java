package cat.institutmarianao.auth.ejb;

public interface LibraryBeanLocal {
	String catalog(String book);

	boolean checkAvailability(String book);

	boolean borrow(String book);
}