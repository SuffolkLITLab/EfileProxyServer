package tyler.efm;

public class Conversion {
    
    public static tyler.efm.v2022_1.services.schema.common.ServiceContactType downgrade(tyler.efm.latest.services.schema.common.ServiceContactType orig) {
        var serviceContact = new tyler.efm.v2022_1.services.schema.common.ServiceContactType();
        serviceContact.setEmail(orig.getEmail());
        serviceContact.setFirstName(orig.getFirstName());
        serviceContact.setMiddleName(orig.getMiddleName());
        serviceContact.setLastName(orig.getLastName());
        serviceContact.setAdministrativeCopy(orig.getAdministrativeCopy());
        serviceContact.setAddress(orig.getAddress());
        serviceContact.setPhoneNumber(orig.getPhoneNumber());
        serviceContact.setIsPublic(orig.getIsPublic());
        serviceContact.setIsInFirmMasterList(orig.getIsInFirmMasterList());
        serviceContact.setIsUndeliverable(orig.getIsUndeliverable());
        serviceContact.setServiceContactID(orig.getServiceContactID());
        serviceContact.setFirmID(orig.getFirmID());
        serviceContact.setFirmName(orig.getFirmName());
        serviceContact.setAddByFirmName(orig.getAddByFirmName());
        return serviceContact;
    }

    public static tyler.efm.latest.services.schema.common.ServiceContactType upgrade(tyler.efm.v2022_1.services.schema.common.ServiceContactType orig) {
        var serviceContact = new tyler.efm.latest.services.schema.common.ServiceContactType();
        serviceContact.setEmail(orig.getEmail());
        serviceContact.setFirstName(orig.getFirstName());
        serviceContact.setMiddleName(orig.getMiddleName());
        serviceContact.setLastName(orig.getLastName());
        serviceContact.setAdministrativeCopy(orig.getAdministrativeCopy());
        serviceContact.setAddress(orig.getAddress());
        serviceContact.setPhoneNumber(orig.getPhoneNumber());
        serviceContact.setIsPublic(orig.getIsPublic());
        serviceContact.setIsInFirmMasterList(orig.getIsInFirmMasterList());
        serviceContact.setIsUndeliverable(orig.getIsUndeliverable());
        serviceContact.setServiceContactID(orig.getServiceContactID());
        serviceContact.setFirmID(orig.getFirmID());
        serviceContact.setFirmName(orig.getFirmName());
        serviceContact.setAddByFirmName(orig.getAddByFirmName());
        return serviceContact;
    }

    /** Drops Notification Contact list. */
    public static tyler.efm.v2022_1.services.schema.common.UserType downgrade(tyler.efm.latest.services.schema.common.UserType orig) {
        var user = new tyler.efm.v2022_1.services.schema.common.UserType();
        user.setEmail(orig.getEmail());
        user.setFirstName(orig.getFirstName());
        user.setMiddleName(orig.getMiddleName());
        user.setLastName(orig.getLastName());
        user.setLastLoginDate(orig.getLastLoginDate());
        user.getRole().addAll(orig.getRole());
        user.setRestrictFiling(orig.isRestrictFiling());
        user.setRestrictFilingComment(orig.getRestrictFilingComment());
        user.setIsUndeliverable(orig.getIsUndeliverable());
        user.setUserID(orig.getUserID());
        user.setFirmID(orig.getFirmID());
        user.setIsApproved(orig.isIsApproved());
        user.setIsActive(orig.isIsActive());
        user.setIsActivated(orig.isIsActivated());
        user.setIsLockedOut(orig.isIsLockedOut());
        return user;
    }

    /** TODO(brycew): Notification Contact not documented yet. Is it important? */
    public static tyler.efm.latest.services.schema.common.UserType upgrade(tyler.efm.v2022_1.services.schema.common.UserType orig) {
        var user = new tyler.efm.latest.services.schema.common.UserType();
        user.setEmail(orig.getEmail());
        user.setFirstName(orig.getFirstName());
        user.setMiddleName(orig.getMiddleName());
        user.setLastName(orig.getLastName());
        user.setLastLoginDate(orig.getLastLoginDate());
        user.getRole().addAll(orig.getRole());
        user.setRestrictFiling(orig.isRestrictFiling());
        user.setRestrictFilingComment(orig.getRestrictFilingComment());
        user.setIsUndeliverable(orig.getIsUndeliverable());
        user.setUserID(orig.getUserID());
        user.setFirmID(orig.getFirmID());
        user.setIsApproved(orig.isIsApproved());
        user.setIsActive(orig.isIsActive());
        user.setIsActivated(orig.isIsActivated());
        user.setIsLockedOut(orig.isIsLockedOut());
        return user;
    }

}
