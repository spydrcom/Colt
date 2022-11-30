
package cern.colt.library;

import cern.colt.matrix.linalg.*;
import cern.colt.matrix.*;

/**
 * interface to Colt library for Linear Algebra classes
 * @author Michael Druckman
 */
public class Linalg
{


	/**
	 * accept matrix data and build report
	 * @param m the matrix of data to analyze
	 * @return the text of the report
	 */
	public static String report (double[][] m)
	{
		return new Algebra ().toVerboseString (prep (m));
	}
	public static DoubleMatrix2D prep (double[][] m)
	{
		DoubleMatrix2D m2d;
		load (m2d = DoubleFactory2D.dense.make (m));
		//System.out.println ("LOADED");
		return m2d;
	}
	public static void load (double[][] m)
	{
		load (DoubleFactory2D.dense.make (m));
	}
	public static void load (DoubleMatrix2D m2d)
	{
		lastReport = new LinAlgReports (m2d);
	}
	static LinAlgReports lastReport;


	/*
	 * Singular Value Decomposition functionality
	 * 
		!+ GetSvdS() = ColtLinalg.getSvdS
		!+ GetSvdV() = ColtLinalg.getSvdV
		!+ GetSvdU() = ColtLinalg.getSvdU
	 */

	public static double[][] getSvdS ()
	{
		return lastReport.getSvd ().getS ().toArray ();
	}

	public static double[][] getSvdV ()
	{
		return lastReport.getSvd ().getV ().toArray ();
	}

	public static double[][] getSvdU ()
	{
		return lastReport.getSvd ().getU ().toArray ();
	}

	public static double getSvdNorm ()
	{
		return lastReport.getSvd ().cond ();
	}

	public static double getSvdNorm2 ()
	{
		return lastReport.getSvd ().norm2 ();
	}

	public static int getSvdRank ()
	{
		return lastReport.getSvd ().rank ();
	}


	/*
	 * Eigenvalue Decomposition functionality
	 * 
		!+ GetEvdD() = ColtLinalg.getEvdD
		!+ GetEvdDreal() = ColtLinalg.getEvdDreal
		!+ GetEvdDimag() = ColtLinalg.getEvdDimag
		!+ GetEvdV() = ColtLinalg.getEvdV
	 */

	public static double[][] getEvdD ()
	{
		return lastReport.getEvd ().getD ().toArray ();
	}

	public static double[] getEvdDreal ()
	{
		return lastReport.getEvd ().getRealEigenvalues ().toArray ();
	}

	public static double[] getEvdDimag ()
	{
		return lastReport.getEvd ().getImagEigenvalues ().toArray ();
	}

	public static double[][] getEvdV ()
	{
		return lastReport.getEvd ().getV ().toArray ();
	}


	/*
	 * QR Decomposition functionality
	 * 
		!+ GetQrdH() = ColtLinalg.getQrdH
		!+ GetQrdQ() = ColtLinalg.getQrdQ
		!+ GetQrdR() = ColtLinalg.getQrdR

		!+ GetQrdSolution(m) = ColtLinalg.getQrdSolution
		!+ SolveWithQRD(A,b) = ColtLinalg.solveWithQRD
	*/

	public static double[][] getQrdH ()
	{
		return lastReport.getQrd ().getH ().toArray ();
	}

	public static double[][] getQrdQ ()
	{
		return lastReport.getQrd ().getQ ().toArray ();
	}

	public static double[][] getQrdR ()
	{
		return lastReport.getQrd ().getR ().toArray ();
	}

	public static double[][] getQrdSolution (double[][] m)
	{
		DoubleMatrix2D m2d =
			DoubleFactory2D.dense.make (m);
		return lastReport.getQrd ().solve (m2d).toArray ();
	}
	public static double[][] solveWithQRD (double[][] A, double[][] b)
	{ load (A); return getQrdSolution (b); }


	/*
	 * LU Decomposition functionality
	 * 
		!+ GetLudL() = ColtLinalg.getLudL
		!+ GetLudU() = ColtLinalg.getLudU

		!+ GetLudSolution(m) = ColtLinalg.getLudSolution
		!+ SolveWithLUD(A,b) = ColtLinalg.solveWithLUD
	 */

	public static double[][] getLudL ()
	{
		return lastReport.getLud ().getL ().toArray ();
	}

	public static double[][] getLudU ()
	{
		return lastReport.getLud ().getU ().toArray ();
	}

	public static int [] getLudIntP ()
	{
		return lastReport.getLud().getPivot ();
	}

	public static double [] getLudP ()
	{
		int p [] = lastReport.getLud ().getPivot ();
		double P [] = new double [p.length];
		for (int i=p.length-1; i>=0; i--)
		{ P[i] = p[i]; }
		return P;
	}

	public static double getLudPdet ()
	{
		return lastReport.getLud().getDetP();
	}

	public static double getDet ()
	{
		return lastReport.getLud().det ();
	}

	public static double[][] getLudSolution (double[][] m)
	{
		DoubleMatrix2D m2d =
			DoubleFactory2D.dense.make (m);
		return lastReport.getLud ().solve (m2d).toArray ();
	}
	public static double[][] solveWithLUD (double[][] A, double[][] b)
	{ load (A); return getLudSolution (b); }


	/*
	 * Cholesky
	 */

	public static CholeskyDecomposition getCHD ()
	{ return lastReport.getChd (); }

	/**
	 * @return the Colt L matrix or C in other documentation
	 */
	public static double[][] getChd ()
	{
		// Colt calls the matrix L but bigger view is the C version
		return lastReport.getChd ().getL ().toArray ();
	}

	public static double[][] getCholeskySolution (double[] b)
	{
		double [][] B = new double [b.length][1];
		for (int i=0; i<b.length; i++) B[i][0] = b[i];
		return lastReport.getChd ().solve
		(
			DoubleFactory2D.dense.make (B)
		).toArray ();
	}

	public static double[][] getCholeskySolution (double[][] B)
	{
		return lastReport.getChd ().solve
		(
			DoubleFactory2D.dense.make (B)
		).toArray ();
	}


}


/**
 * wrapper / place-holder for the currently analyzed matrix and
 *  the libraries available to decompose the active matrix
 */
class LinAlgReports
{

	LinAlgReports (DoubleMatrix2D m2d)
	{
		this.m2d = m2d;
	}
	DoubleMatrix2D m2d;

	SingularValueDecomposition getSvd ()
	{
		if (svd == null)
			svd = new SingularValueDecomposition (m2d);
		return svd;
	}
	SingularValueDecomposition svd = null;

	QRDecomposition getQrd ()
	{
		if (qrd == null)
			qrd = new QRDecomposition (m2d);
		return qrd;
	}
	QRDecomposition qrd = null;

	EigenvalueDecomposition getEvd ()
	{
		if (evd == null)
			evd = new EigenvalueDecomposition (m2d);
		return evd;
	}
	EigenvalueDecomposition evd = null;

	LUDecomposition getLud ()
	{
		if (lud == null)
			lud = new LUDecomposition (m2d);
		return lud;
	}
	LUDecomposition lud = null;

	CholeskyDecomposition getChd ()
	{
		if (chd == null)
			chd = new CholeskyDecomposition (m2d);
		return chd;
	}
	CholeskyDecomposition chd = null;

}
