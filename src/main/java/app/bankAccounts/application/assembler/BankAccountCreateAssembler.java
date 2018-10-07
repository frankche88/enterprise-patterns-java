package app.bankAccounts.application.assembler;

import org.modelmapper.ModelMapper;

import app.bankAccounts.application.dto.BankAccountCreateDto;
import app.bankAccounts.domain.entity.BankAccount;

public class BankAccountCreateAssembler {

	private final ModelMapper _mapper;

	public BankAccountCreateAssembler(ModelMapper mapper) {
		_mapper = mapper;
	}

	public BankAccount toEntity(BankAccountCreateDto bankAccountCreateDto) {
		return _mapper.map(bankAccountCreateDto, BankAccount.class);
	}

}
