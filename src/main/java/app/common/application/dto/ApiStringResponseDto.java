package app.common.application.dto;

public class ApiStringResponseDto {
	
	public String message;

	public ApiStringResponseDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
