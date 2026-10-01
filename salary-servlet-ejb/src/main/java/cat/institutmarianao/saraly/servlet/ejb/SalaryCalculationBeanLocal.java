package cat.institutmarianao.saraly.servlet.ejb;

import jakarta.ejb.Local;

@Local
public interface SalaryCalculationBeanLocal {
	double MIN_GROSS_SALARY = 1424.50; // Minimum gross salary in Spain for 2026
	int MIN_CHILDREN = 0; // Minimum number of children
	double MIN_WITHHOLDING = 0; // Minimum withholding percentage

	double calculateWithholding(int children);

	double calculateNetSalary(double grossSalary, int children);
}
