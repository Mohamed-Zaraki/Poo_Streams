package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Employé {

	
	private  final int id;
	private String nom;
	private final int age;
	private double salaire;
	private String departement;
	public Employé(int id, String nom, int age, double salaire, String departement) {
		
		this.id = id;
		this.nom = nom;
		this.age = age;
		this.salaire = salaire;
		this.departement = departement;
	}
	 @Override
	    public String toString() {
	        return "Employé{" +
	                "id=" + id +
	                ", nom='" + nom + '\'' +
	                ", age=" + age +
	                ", salaire=" + salaire +
	                ", departement='" + departement + '\'' +
	                '}';
	    }
	
	public static void main(String[] args) {
		
		List<Employé> Employés =List.of(new Employé(1 , "John" ,30 ,50000.0 , "IT") ,
										new Employé(2 , "Jane" , 35 , 60000.0 , "Finance") ,
										new Employé(3  , "Alice", 40 , 70000.0, "IT") , 
										new Employé(4 , "Bob" , 45 , 80000.0 , "Finance") ,
										new Employé(5 , "Charlie" , 50 , 90000.0 , "HR"));
	
				Employés.stream().forEach(employe -> System.out.println(employe));
				
				OptionalDouble moyenne = Employés.stream()
                        .mapToDouble(employe -> employe.salaire)
                        .average();
				
				System.out.println(moyenne);
				
				Map<String , List<Employé>> GroupeBydepartement = Employés.stream().collect(Collectors.groupingBy(employe -> employe.departement));
				System.out.println(GroupeBydepartement);
				
				Map<String , Double>GroupeAndCalc = Employés.stream().collect(Collectors.groupingBy(employe ->employe.departement , Collectors.averagingDouble(employe -> employe.salaire)));
				System.out.println(GroupeAndCalc);
	
				Map<String , Double> oldindepartement =Employés.stream().collect(Collectors.groupingBy(
				        employe -> employe.departement,
				        Collectors.collectingAndThen(
				            Collectors.maxBy(Comparator.comparingInt(employe -> employe.age)) ,Employe -> Employe.get().salaire)));
	
					System.out.println(oldindepartement);
	
	}
	
}
