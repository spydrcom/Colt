
package net.myorb.external.coltlib;

import net.myorb.math.complexnumbers.*;

import net.myorb.math.expressions.managers.ExpressionComplexFieldManager;

import cern.jet.math.Bessel;

public class ComplexColtLibPrimitives extends ColtLibPrimitives<ComplexValue<Double>>
{

	static ExpressionComplexFieldManager mgr = new ExpressionComplexFieldManager ();

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getH10Wrapper()
	 */
	CommonWrapper getH10Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public ComplexValue<Double> eval (ComplexValue<Double> x)
				{
					double realpart = x.Re ();
					return mgr.C (Bessel.j0 (realpart), Bessel.y0 (realpart));
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getH20Wrapper()
	 */
	CommonWrapper getH20Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public ComplexValue<Double> eval (ComplexValue<Double> x)
				{
					double realpart = x.Re ();
					return mgr.C (Bessel.j0 (realpart), - Bessel.y0 (realpart));
				}
			}
		);
	}

	CommonWrapper getJ0Wrapper () { return null; }
	CommonWrapper getK0Wrapper () { return null; }
	CommonWrapper getK0eWrapper () { return null; }
	CommonWrapper getI0Wrapper () { return null; }
	CommonWrapper getI0eWrapper () { return null; }
	CommonWrapper getI1Wrapper () { return null; }
	CommonWrapper getI1eWrapper () { return null; }
	CommonWrapper getY0Wrapper () { return null; }

}
