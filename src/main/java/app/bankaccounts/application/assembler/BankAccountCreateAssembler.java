package app.bankaccounts.application.assembler;

import org.modelmapper.ModelMapper;

import app.bankaccounts.application.dto.BankAccountCreateDto;
import app.bankaccounts.domain.entity.BankAccount;

public class BankAccountCreateAssembler {

	private final ModelMapper _mapper;

	public BankAccountCreateAssembler() {
		_mapper = new ModelMapper();
	}

	public BankAccount toEntity(BankAccountCreateDto bankAccountCreateDto) {
		_mapper.addMappings(new BankAccountCreateMapper());
		return _mapper.map(bankAccountCreateDto, BankAccount.class);
	}

}
