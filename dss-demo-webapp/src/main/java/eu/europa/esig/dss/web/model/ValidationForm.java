package eu.europa.esig.dss.web.model;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.springframework.web.multipart.MultipartFile;

import eu.europa.esig.dss.utils.Utils;
import eu.europa.esig.dss.validation.executor.ValidationLevel;

public class ValidationForm {

	private MultipartFile signedFile;

	private List<OriginalFile> originalFiles;

	private ValidationLevel validationLevel;

	private boolean defaultPolicy;

	private MultipartFile policyFile;
	
	private boolean includeCertificateTokens;
	
	private boolean includeRevocationTokens;
	
	private boolean includeTimestampTokens;

	public MultipartFile getSignedFile() {
		return signedFile;
	}

	public void setSignedFile(MultipartFile signedFile) {
		this.signedFile = signedFile;
	}

	public List<OriginalFile> getOriginalFiles() {
		return originalFiles;
	}

	public void setOriginalFiles(List<OriginalFile> originalFiles) {
		this.originalFiles = originalFiles;
	}

	public ValidationLevel getValidationLevel() {
		return validationLevel;
	}

	public void setValidationLevel(ValidationLevel validationLevel) {
		this.validationLevel = validationLevel;
	}

	public boolean isDefaultPolicy() {
		return defaultPolicy;
	}

	public void setDefaultPolicy(boolean defaultPolicy) {
		this.defaultPolicy = defaultPolicy;
	}

	public MultipartFile getPolicyFile() {
		return policyFile;
	}

	public void setPolicyFile(MultipartFile policyFile) {
		this.policyFile = policyFile;
	}
	
	public boolean isIncludeCertificateTokens() {
		return includeCertificateTokens;
	}

	public void setIncludeCertificateTokens(boolean includeCertificateTokens) {
		this.includeCertificateTokens = includeCertificateTokens;
	}

	public boolean isIncludeRevocationTokens() {
		return includeRevocationTokens;
	}

	public void setIncludeRevocationTokens(boolean includeRevocationTokens) {
		this.includeRevocationTokens = includeRevocationTokens;
	}

	public boolean isIncludeTimestampTokens() {
		return includeTimestampTokens;
	}

	public void setIncludeTimestampTokens(boolean includeTimestampTokens) {
		this.includeTimestampTokens = includeTimestampTokens;
	}

	@AssertTrue(message = "{error.signed.file.mandatory}")
	public boolean isSignedFile() {
		return (signedFile != null) && (!signedFile.isEmpty());
	}

	@AssertTrue(message = "{error.original.file.empty}")
	public boolean areOriginalFiles() {
		if (Utils.isCollectionNotEmpty(originalFiles)) {
			boolean atLeastOneOriginalDoc = false;
			for (OriginalFile originalDocument : originalFiles) {
				if (originalDocument.isNotEmpty()) {
					atLeastOneOriginalDoc = true;
					break;
				}
			}
			return atLeastOneOriginalDoc;
		}
		return true;
	}

}
