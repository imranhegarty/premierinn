package com.whitbread.premierinn;

import java.util.List;

/**
 * Validatable model is aware of it's logical correctness. After it's been validated ({@link #validate()}) it can answer
 * the basic question: "Am I valid?" ({@link #isValid()}) and lists all the errors found during the validation (
 * {@link #getErrors()}).
 */
public interface Validatable {

	/**
	 * Use to validate model object - e.g. during instantiation. Validatable will not know if it's valid until
	 * validated.
	 */
	void validate();

	/**
	 * @return true if the validatable is valid, false otherwise
	 */
	boolean isValid();

	/**
	 * Returns list of error messages found during validation of component.
	 * 
	 * @return List of errors found; may be empty, never null.
	 */
	List<String> getErrors();
}
