package project.internshipWebapp.dto;

public class InternshipDetailsDTO {
private String internshipId ;
private String description ;
private String type;
private String companyName ;
private String comAddress ;
private String comEmail ;
private String companyId ;


public String getCompanyId() {
	return companyId;
}
public void setCompanyId(String companyId) {
	this.companyId = companyId;
}
public String getInternshipId() {
	return internshipId;
}
public void setInternshipId(String internshipId) {
	this.internshipId = internshipId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getComAddress() {
	return comAddress;
}
public void setComAddress(String comAddress) {
	this.comAddress = comAddress;
}
public String getComEmail() {
	return comEmail;
}
public void setComEmail(String comEmail) {
	this.comEmail = comEmail;
}

@Override
public String toString() {
	return "InternshipDetailsDTO [internshipId=" + internshipId + ", description=" + description + ", type=" + type
			+ ", companyName=" + companyName + ", comAddress=" + comAddress + ", comEmail=" + comEmail + ", companyId="
			+ companyId + "]";
}




}
