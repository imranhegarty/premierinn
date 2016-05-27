package com.whitbread.premierinn;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Provides methods that check if model is valid, and manipulate list of errors.
 *
 */
public abstract class AbstractValidatableModel implements Validatable {

	private final List<String> errors;

	public AbstractValidatableModel() {
		this.errors = Lists.newArrayList();
	}

	@Override
	public boolean isValid() {
		return errors.isEmpty();
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Use during validation to add an error message.
	 *
	 * @param error
	 *            error message to add; may be empty, never null.
	 */
	protected void addError(String error) {
		errors.add(error);
	}

	/**
	 * Use during validation to add error messages.
	 *
	 * @param errors
	 *            errors messages to add; may be empty, never null.
	 */
	protected void addAllErrors(Collection<String> errors) {
		if(errors != null) {
			this.errors.addAll(errors);
		}
	}
}
