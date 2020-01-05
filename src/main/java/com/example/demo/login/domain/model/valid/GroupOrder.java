package com.example.demo.login.domain.model.valid;

import javax.validation.GroupSequence;

@GroupSequence({Required.class, Value.class, ValidPattern.class})
public interface GroupOrder {

}
