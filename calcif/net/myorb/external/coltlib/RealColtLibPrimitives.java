
package net.myorb.external.coltlib;

import cern.jet.math.*;

import java.util.List;

/**
 * real number interface layer to access methods of Colt library
 * @author Michael Druckman
 */
public class RealColtLibPrimitives extends ColtLibPrimitives<Double>
{

	/*
	 * 		Bessel Functions
	 */

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getH10Wrapper()
	 */
	CommonWrapper getH10Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.j0 (x); // + i*Y0
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
				public Double eval (Double x)
				{
					return Bessel.j0 (x); // - i*y0
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getI0Wrapper()
	 */
	CommonWrapper getI0Wrapper()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.i0 (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getI1Wrapper()
	 */
	CommonWrapper getI1Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.i1 (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getI1eWrapper()
	 */
	CommonWrapper getI1eWrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.i1e (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getI0eWrapper()
	 */
	CommonWrapper getI0eWrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.i0e (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getJ0Wrapper()
	 */
	CommonWrapper getJ0Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.j0 (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getJnImplementation()
	 */
	public CommonFunctionImplementation getJnImplementation ()
	{
		return new CommonFunctionImplementation ()
		{
			FunctionProfile profile =
				new FunctionProfile ("Jn", 2, 2);
			public Double evaluate (List<Double> using)
			{
				profile.parameterCheck (using.size ());
				int n = using.get (0).intValue ();
				return Bessel.jn (n, using.get (1));
			}
		};
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getK0Wrapper()
	 */
	CommonWrapper getK0Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.k0 (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getK0eWrapper()
	 */
	CommonWrapper getK0eWrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.k0e (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getKnImplementation()
	 */
	public CommonFunctionImplementation getKnImplementation ()
	{
		return new CommonFunctionImplementation ()
		{
			FunctionProfile profile =
				new FunctionProfile ("Kn", 2, 2);
			public Double evaluate (List<Double> using)
			{
				profile.parameterCheck (using.size ());
				int n = using.get (0).intValue ();
				return Bessel.kn (n, using.get (1));
			}
		};
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getY0Wrapper()
	 */
	CommonWrapper getY0Wrapper ()
	{
		return new CommonWrapper
		(
			new CommonFunction ()
			{
				public Double eval (Double x)
				{
					return Bessel.y0 (x);
				}
			}
		);
	}

	/* (non-Javadoc)
	 * @see net.myorb.math.coltlib.ColtLibPrimitives#getYnImplementation()
	 */
	public CommonFunctionImplementation getYnImplementation ()
	{
		return new CommonFunctionImplementation ()
		{
			FunctionProfile profile =
				new FunctionProfile ("Yn", 2, 2);
			public Double evaluate (List<Double> using)
			{
				profile.parameterCheck (using.size ());
				int n = using.get (0).intValue ();
				return Bessel.yn (n, using.get (1));
			}
		};
	}

}
