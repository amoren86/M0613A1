package cat.institutmarianao.saraly.servlet.ejb.impl;

import cat.institutmarianao.saraly.servlet.ejb.SalaryCalculationBeanLocal;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class SalaryCalculationBean
 */
@Stateless
@LocalBean
public class SalaryCalculationBean implements SalaryCalculationBeanLocal {

	/**
	 * Default constructor.
	 */
	public SalaryCalculationBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateWithholding(int children) {
		return Math.max(MIN_WITHHOLDING, (21 - 5 * children) / 100.0);
	}

	@Override
	public double calculateNetSalary(double grossSalary, int children) {
		return grossSalary * (1 - calculateWithholding(0));
	}

}
