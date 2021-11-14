
package net.myorb.external.coltlib;

import net.myorb.math.expressions.gui.rendering.NodeFormatting;
import net.myorb.math.expressions.algorithms.CommonOperatorLibrary;
import net.myorb.math.expressions.symbols.AbstractParameterizedFunction;
import net.myorb.math.expressions.ValueManager;

/**
 * generic interface layer to access methods of Colt library
 * @param <T> data type to use for computation
 * @author Michael Druckman
 */
public abstract class ColtLibPrimitives<T> extends CommonOperatorLibrary<T>
{

	/*
	 * 		Bessel Functions
	 */

	/**
	 * implement operator - J0
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getJ0Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return j0Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getJ0Wrapper ();
		};
	}
	String j0Render (NodeFormatting using) { return render ("J", "0", using); }
	abstract CommonWrapper getJ0Wrapper ();

	/**
	 * implement operator - Jn
	 * @param symbol the symbol associated with this object
	 * @return operation implementation object
	 */
	public AbstractParameterizedFunction getJnAlgorithm (String symbol)
	{ return new MultipleMarshalingWrapper (symbol, getJnImplementation ()); }
	public CommonFunctionImplementation getJnImplementation ()
	{ return new Missing ("Bessel Jn"); }

	/**
	 * implement operator - K0
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getK0Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return k0Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getK0Wrapper ();
		};
	}
	String k0Render (NodeFormatting using) { return render ("K", "0", using); }
	abstract CommonWrapper getK0Wrapper ();

	/**
	 * implement operator - K0e
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getK0eAlgorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return k0eRender (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getK0eWrapper ();
		};
	}
	String k0eRender (NodeFormatting using) { return render ("Ke", "0", using); }
	abstract CommonWrapper getK0eWrapper ();

	/**
	 * implement operator - Kn
	 * @param symbol the symbol associated with this object
	 * @return operation implementation object
	 */
	public AbstractParameterizedFunction getKnAlgorithm (String symbol)
	{ return new MultipleMarshalingWrapper (symbol, getKnImplementation ()); }
	public CommonFunctionImplementation getKnImplementation ()
	{ return new Missing ("Bessel Kn"); }

	String hRender (int kind, NodeFormatting using)
	{
		return using.formatSuperScript
		(
			formatIdentifierFor ("H", using),
			using.formatParenthetical
			(
				using.formatNumericReference (Integer.toString (kind))
			)
		);
	}

	/**
	 * implement operator - H10
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getH10Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return h10Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getH10Wrapper ();
		};
	}
	String h10Render (NodeFormatting using)
	{ return formatNumericSubscript (hRender (1, using), "0", using); }
	abstract CommonWrapper getH10Wrapper ();

	/**
	 * implement operator - H20
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getH20Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return h20Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getH20Wrapper ();
		};
	}
	String h20Render (NodeFormatting using)
	{ return formatNumericSubscript (hRender (2, using), "0", using); }
	abstract CommonWrapper getH20Wrapper ();

	/**
	 * implement operator - I0
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getI0Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return i0Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getI0Wrapper ();
		};
	}
	String i0Render (NodeFormatting using) { return render ("I", "0", using); }
	abstract CommonWrapper getI0Wrapper ();

	/**
	 * implement operator - I0e
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getI0eAlgorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return i0eRender (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getI0eWrapper ();
		};
	}
	String i0eRender (NodeFormatting using) { return render ("Ie", "0", using); }
	abstract CommonWrapper getI0eWrapper ();

	/**
	 * implement operator - I1
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getI1Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return i1Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getI1Wrapper ();
		};
	}
	String i1Render (NodeFormatting using) { return render ("I", "1", using); }
	abstract CommonWrapper getI1Wrapper ();

	/**
	 * implement operator - I1e
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getI1eAlgorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return i1eRender (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getI1eWrapper ();
		};
	}
	String i1eRender (NodeFormatting using) { return render ("Ie", "1", using); }
	abstract CommonWrapper getI1eWrapper ();

	/**
	 * implement operator - Y0
	 * @param symbol the symbol associated with this object
	 * @return implementation object
	 */
	public AbstractParameterizedFunction getY0Algorithm (String symbol)
	{
		return new EnhancedParameterizedFunction (symbol)
		{
			public ValueManager.GenericValue execute
			(ValueManager.GenericValue parameters) { return wrapper.eval (parameters); }
			public String markupForDisplay (String operator, String operand, NodeFormatting using)
			{ return y0Render (using) + using.formatParenthetical (operand); }
			public void addParameterization (String options) {}
			CommonWrapper wrapper = getY0Wrapper ();
		};
	}
	String y0Render (NodeFormatting using) { return render ("Y", "0", using); }
	abstract CommonWrapper getY0Wrapper ();

	/**
	 * implement operator - Yn
	 * @param symbol the symbol associated with this object
	 * @return operation implementation object
	 */
	public AbstractParameterizedFunction getYnAlgorithm (String symbol)
	{ return new MultipleMarshalingWrapper (symbol, getYnImplementation ()); }
	public CommonFunctionImplementation getYnImplementation ()
	{ return new Missing ("Bessel Yn"); }

	/**
	 * @param id the identifier form the function
	 * @param subscript the alpha value to show as subscript
	 * @param using the formatting object
	 * @return the MML text
	 */
	String render (String id, String subscript, NodeFormatting using)
	{
		return formatNumericSubscript (using.formatIdentifierReference (id), subscript, using);
	}

}
