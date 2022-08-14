package com.masai.model;


import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRegistration {

	@Id
//	@NotBlank(message = "Mobile Number is Mandatory")
//	@Size(max=10,message="Moblie Number length should be 10!")
//	@Pattern(regexp = "^[7-9][0-9]{9}$",message="Mobile No is Invalid!")
	private long mobileno;
	
//	@NotBlank(message = "Date of Registration is Mandatory")
    @JsonFormat(pattern = "dd-MM-yyyy")
//	@NotNull(message = "Date of Registration should not be Null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofregistration;

    @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccineRegistration")
	private Member member;
}
