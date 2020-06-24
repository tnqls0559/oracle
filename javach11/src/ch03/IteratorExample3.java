package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample3 {

	public static void main(String[] args) {
		List<Account> list = new ArrayList<>();
		list.add(new Account("111-001","홍길동",1000000));
		list.add(new Account("111-002","일지매",1000000));
		list.add(new Account("111-003","임꺽정",1000000));
		
		Iterator<Account> itor = list.iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
		boolean isExits = list.contains(new Account("111-002","일지매",1000000));
		System.out.println(isExits?"계좌가 존재합니다.":"계좌가 없습니다.");
		
		for(int i=0;i<list.size();i++) {
			Account acc = list.get(i);
			if(list.get(i).equals(new Account("111-002","일지매",1000000))){
				System.out.println(acc);
				break;
			}
		}
	}
}
class Account{
	String ano;
	String owner;
	int balance;
	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	void deposit(int amount) {
		balance+=amount;
	}
	void withdraw(int amount) throws Exception{
		if(balance-amount<0)
			throw new Exception("잔고부족");
		else
			balance-=amount;
	}
	@Override
	public String toString() {
		return "Account [ano=" + ano + ", owner=" + owner + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		return ano.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Account) {
		return ano.equals(((Account)obj).ano);
		}else
			return false;
	}
}