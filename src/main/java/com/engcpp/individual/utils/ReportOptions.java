package com.engcpp.individual.utils;

/**
 *
 * @author engcpp
 */
public class ReportOptions {    
    private boolean propertyOwnershipVerification;
    private boolean licenceCheck;
    private boolean mojOverdueFineSearch;
    private boolean directorshipAffiliationSearch;
    
    private String accessPurposeCode;
    private boolean privateCodeConsent;

    public boolean isPropertyOwnershipVerification() {
        return propertyOwnershipVerification;
    }

    public ReportOptions withPropertyOwnershipVerification(boolean propertyOwnershipVerification) {
        this.propertyOwnershipVerification = propertyOwnershipVerification;
        return this;
    }

    public boolean isLicenceCheck() {
        return licenceCheck;
    }

    public ReportOptions withLicenceCheck(boolean licenceCheck) {
        this.licenceCheck = licenceCheck;
        return this;
    }

    public boolean isMojOverdueFineSearch() {
        return mojOverdueFineSearch;
    }

    public ReportOptions withMojOverdueFineSearch(boolean mojOverdueFineSearch) {
        this.mojOverdueFineSearch = mojOverdueFineSearch;
        return this;
    }

    public boolean isDirectorshipAffiliationSearch() {
        return directorshipAffiliationSearch;
    }

    public ReportOptions withDirectorshipAffiliationSearch(boolean directorshipAffiliationSearch) {
        this.directorshipAffiliationSearch = directorshipAffiliationSearch;
        return this;
    }

    public String getAccessPurposeCode() {
        return accessPurposeCode;
    }

    public ReportOptions withAccessPurposeCode(String accessPurposeCode) {
        this.accessPurposeCode = accessPurposeCode;
        return this;
    }

    public boolean isPrivateCodeConsent() {
        return privateCodeConsent;
    }

    public ReportOptions withPrivateCodeConsent(boolean privateCodeConsent) {
        this.privateCodeConsent = privateCodeConsent;
        return this;
    }

}