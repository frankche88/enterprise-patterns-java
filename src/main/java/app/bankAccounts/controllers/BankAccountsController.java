package app.bankAccounts.controllers;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import app.bankAccounts.application.assembler.BankAccountCreateAssembler;
import app.bankAccounts.application.dto.BankAccountCreateDto;
import app.bankAccounts.domain.entity.BankAccount;
import app.bankAccounts.domain.repository.BankAccountRepository;
import app.common.application.dto.ApiStringResponseDto;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;

@Path("v1/customers")
@Api(value = "v1/customers")
public class BankAccountsController {

	@Inject
	private BankAccountRepository _bankAccountRepository;
	@Inject
	private BankAccountCreateAssembler _bankAccountCreateAssembler;

	@Path("/{customerId}/bank-accounts")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@UnitOfWork
	public Response Create(@PathParam("customerId") long customerId, BankAccountCreateDto bankAccountCreateDto) {

		try {

			bankAccountCreateDto.setCustomerId(customerId);
			// TODO: Validations with Notification Pattern
			BankAccount bankAccount = _bankAccountCreateAssembler.toEntity(bankAccountCreateDto);
			_bankAccountRepository.create(bankAccount);
			return Response.ok(new ApiStringResponseDto("BankAccount Created!")).build();
		} catch (Exception ex) {

			ex.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ApiStringResponseDto("Internal Server Error"))
					.build();
			// Console.WriteLine(ex.StackTrace);
			// return StatusCode(StatusCodes.Status500InternalServerError, new
			// ApiStringResponseDto("Internal Server Error"));

		}
	}

}
