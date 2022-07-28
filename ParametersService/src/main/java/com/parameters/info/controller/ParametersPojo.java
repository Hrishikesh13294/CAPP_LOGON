package com.parameters.info.controller;

import java.util.List;
import java.util.Optional;

public class ParametersPojo {

	private Optional<List<String>> IntParams;
	private Optional<List<String>> DoubleParams;
	private Optional<List<String>> BooleanParams;

	public ParametersPojo(Optional<List<String>> intParams) {
		super();
		IntParams = intParams;
	}

	public ParametersPojo(Optional<List<String>> intParams, Optional<List<String>> doubleParams) {
		super();
		IntParams = intParams;
		DoubleParams = doubleParams;
	}

	public ParametersPojo(Optional<List<String>> intParams, Optional<List<String>> doubleParams,
			Optional<List<String>> booleanParams) {
		super();
		IntParams = intParams;
		DoubleParams = doubleParams;
		BooleanParams = booleanParams;
	}

	public Optional<List<String>> getIntParams() {
		return IntParams;
	}

	public void setIntParams(Optional<List<String>> intParams) {
		IntParams = intParams;
	}

	public Optional<List<String>> getDoubleParams() {
		return DoubleParams;
	}

	public void setDoubleParams(Optional<List<String>> doubleParams) {
		DoubleParams = doubleParams;
	}

	public Optional<List<String>> getBooleanParams() {
		return BooleanParams;
	}

	public void setBooleanParams(Optional<List<String>> booleanParams) {
		BooleanParams = booleanParams;
	}

	public ParametersPojo() {
		super();
	}

}
