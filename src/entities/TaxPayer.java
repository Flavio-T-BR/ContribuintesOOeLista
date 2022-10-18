package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
	}
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public static Double salaryTax(double salaryIncome) {
		if (salaryIncome/12 < 3000.00) {
			return 0.0;
		} else if (salaryIncome/12 < 5000) {
			return salaryIncome * 0.1;
		} else {
			return salaryIncome * 0.2;
		}
	}
	
	public Double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public Double grossTax() {
		return salaryTax(salaryIncome) + servicesTax() + capitalTax();
	}
	
	public Double taxRebate() {
		if (healthSpending + educationSpending >= grossTax() * 0.3) {
			return grossTax() * 0.3;
		} else { 
			return healthSpending + educationSpending;
		}
	}
	public Double netTax() {
		return grossTax() - taxRebate();
	}
}
