package com.futurewei.alcor.macmanager.service;

import com.futurewei.alcor.common.exception.ParameterNullOrEmptyException;
import com.futurewei.alcor.common.exception.ParameterUnexpectedValueException;
import com.futurewei.alcor.common.exception.ResourceNotFoundException;
import com.futurewei.alcor.macmanager.entity.MacRange;
import com.futurewei.alcor.macmanager.entity.MacState;
import com.futurewei.alcor.macmanager.exception.*;

import java.util.Map;

public interface MacService {
    MacState getMacStateByMacAddress(String macAddress) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacAddressInvalidException;

    MacState createMacState(MacState macState) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacRangeInvalidException, MacAddressUniquenessViolationException, MacAddressFullException, MacAddressRetryLimitExceedException;

    MacState createMacStateInRange(String rangeid, MacState macState ) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacRangeInvalidException, MacAddressUniquenessViolationException, MacAddressRetryLimitExceedException, MacAddressFullException;

    MacState updateMacState(String macaddress, MacState macState) throws ParameterNullOrEmptyException, ParameterUnexpectedValueException, MacRepositoryTransactionErrorException, ResourceNotFoundException;

    String releaseMacState(String macAddress) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, ResourceNotFoundException;

    MacRange getMacRangeByMacRangeId(String macRangeId) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException;

    Map<String, MacRange> getAllMacRanges() throws MacRepositoryTransactionErrorException;

    MacRange createMacRange(MacRange macRange) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacRangeInvalidException;

    MacRange updateMacRange(MacRange macRange) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacRangeInvalidException;

    String deleteMacRange(String rangeid) throws ParameterNullOrEmptyException, MacRepositoryTransactionErrorException, MacRangeDeleteNotAllowedException;
}
